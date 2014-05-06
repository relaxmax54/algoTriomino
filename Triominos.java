/*import java.util.Random;*/
import java.io.*;

/**
 * programme principal tire au sort le nombre de faces possibles avant tirage (variable base)
 * tire au sort la largeur l du plateau qui determine la taille de la liste initiale (l² triomios)
 * tire au sort la liste intiale de triominos
 * affiche sous forme de liste les triominos a placer
 * affiche sous forme de plateau les triominos a deplacer
 */
public class Triominos {
    public static void main(String[] args) throws IOException {
		System.out.println("Jeu des triominos");
/*	        Random generator = new Random();*/
	        int base,size;
	        base = 3;
	        size = 3;
/*	        base =  2 + Math.abs(generator.nextInt()%15);
	        size =  1 + Math.abs(generator.nextInt()%6);*/
		Jeu jeu=new Jeu(size,base);
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(new FileWriter("jeu_triomino.txt"));
			jeu.ecrit(pw);
			}
		finally {
	        if (pw != null)
	        {
	            pw.close();
	        }
		}
		Plateau p=new Plateau(size);
		jeu.affiche();
	
	        /*  placer les triominos sur le plateau.
	         *    on ne résout pas le problème ici
	         */ 
	
	    int k = 0;
	    for ( int i = 0; i < size; i++ ) {
	      for ( int j = 0; j < 2*i+1; j++ ) {
	    	  p.set(i,j,jeu.get(k));
	    	  k++;
	      }
	    }
	    affiche_plateau_mini(p);
	    
	    
    }
	

/*  
 * conversion d'un entier positif (<62) en caractere [0-9A-Za-z]
 */

	  static char onechar(int value){
	    if (value >= 0) {
	      if (value < 10) 
	        return (char) ('0'+value);
	      else
	        if (value < 36)
		  return (char) ('A'+value-10);
	        else
		  if (value < 62)
		    return (char) ('a'+value-36);
	    }
	    return '\0';
	  }

/**
 * methode charorstar affiche la face donnee d un triomino donne
 * affiche une asterisque si le premier parametre est nul
 * typiquement si le premier parametre fait partie d une ColonneTriomino
 * et que null a ete affecte a cet element de la colonne
 * @param t
 * 			Triomino a ecrire
 * @param c
 * 			face a ecrire
 * @return
 * 			valeur monocaractere de la face a ecrire
 */
	  
	static char charorstar(Triomino t,int c) {
	    if (t!=null)
	    	return (onechar(c));
	    else return('*');
	}

/*
 * affiche un plateau, meme partiellement rempli.
 */

	static void affiche_plateau_mini(Plateau p) {
	  for (int i = 0 ; i < p.largeur ; i++) {
	    for (int l=0; l<3; l++) {      
	      int k;
	      for(k=0 ; k<p.largeur-i;k++) System.out.print("   ");
	      	if (l%2>0) System.out.print(" ");
	      
	      for (int j=0 ; j <= 2*i ; j++ ){
			  Triomino t=p.get(i,j);
			  switch (l) {
				case 0:
				  /* top line */
				  if (j%2>0)
				      System.out.print(" "+charorstar(t,t.a));
				  else
				    System.out.print("  ^ ");
				  break;
				case 1:
				  /* middle line */
				  if (j%2>0)
				      System.out.print(charorstar(t,t.b)+" "+charorstar(t,t.c));
				  else
				      System.out.print(charorstar(t,t.c)+" "+charorstar(t,t.b));
				  break;
				case 2:
				  /* bottom line */
				  if (j%2>0)
				    System.out.print(" ");
				  else
				    System.out.print("/_" + charorstar(t,t.a) + "_\\");
	    	  }
	      }
	      System.out.println("");
	    }
	  }
	}
	
	
/**
 * methode resoudre place sur un plateau p la solution
 * a un probleme jeu de triomino
 * en commencant par la case pos du plateau
 * @param jeu
 * 				tirage de triomino typiquement instance de Jeu creee aleatoirement par le constructeur de la classe Jeu
 * @param p
 * 				plateau a completer typiquement plateau vide pour un premier appel a la fonction
 * @param pos
 * 				premiere case du plateau a completer typiquement case (0,0) pour un premier appel a la fonction
 * @return
 * 				true si tous les triominos ont pu etre places, false autrement
 */
	static boolean resoudre(Jeu jeu, Plateau p, PositionPlateau pos) {
		int largeur = p.getLargeur();
		boolean trouve = false;
		if (pos.dernierePosition(largeur))
			trouve = true;
		else {
			PositionPlateau next_pos = pos.nextPosition(largeur);
			int i = 0;
			while ((i<(largeur*largeur))&&(!trouve)) {
				if (!jeu.utilise(i)) {
					Triomino t = jeu.enlever(i);
					int j = 0;
					while ((j<3)&&(!trouve)) {
						if (p.contraintes(t,pos)) {
							p.placer(t,pos);
							if (resoudre(jeu,p,next_pos))
								trouve = true;
							else
								p.enlever(pos);
						}
						if (!trouve) {
							j++;
							t = t.rotation();
						}
					}
					if (!trouve) {
						jeu.ajouter(i);
						i++;
					}
				}
				else
					i++;
			}
		}
		return trouve;
	}

}
