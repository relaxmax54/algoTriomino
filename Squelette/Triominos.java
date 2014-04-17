import java.util.Random;
/**
 * programme principal tire au sort le nombre de faces possibles avant tirage (variable base)
 * tire au sort la largeur l du plateau qui determine la taille de la liste intiale (l² triomios)
 * tire au sort la liste intiale de triominos
 * affiche sous forme de liste les triominos a placer
 * affiche sous forme de plateau les triominos a deplacer
 */
public class Triominos {
    public static void main(String args[]) {
	System.out.println("Jeu des triominos");
        Random generator = new Random();
        int base,size;
        base =  2 + Math.abs(generator.nextInt()%15);
        size =  1 + Math.abs(generator.nextInt()%6);
	Jeu jeu=new Jeu(size,base);
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




}
