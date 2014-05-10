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
	base = 6;
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
	for(int i=0;i<size*size;i++)
	    p.set(jeu.get(i),i);
	//
	affiche_plateau_mini(p);
	tests();
	PositionPlateau pos= new PositionPlateau(0,0,4,0);
	resoudre(jeu,p,pos);
	System.out.println("Résultat :" );
	affiche_plateau_mini(p);
    }
    /**
     * conversion d'un entier positif (<62) en caractere [0-9A-Za-z]
     *@param int value valeur à convertir
     *
     */
    public static char onechar(int value){
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
    public static char charorstar(Triomino t,int c) {
	if (t!=null)
	    return (onechar(c));
	else return('*');
    }
    /*
     * affiche un plateau, meme partiellement rempli.
     */
    public static void affiche_plateau_mini(Plateau p) {
	for (int i = 0 ; i < p.largeur ; i++) {
	    for (int l=0; l<3; l++) {
		//AFFICHE LES ESPACES ENTRE BORD GAUCHE ET PREMIER TRIOMINO
		for(int k=0 ; k<p.largeur-i;k++)
		    System.out.print("   ");
		if (l%2>0)
		    System.out.print(" ");
		for (int j=0 ; j <= 2*i ; j++ ){
		    Triomino t=p.get(i,j);
		    switch (l) {
		    case 0:
			/* top line */
			if (j%2>0)//j pair
			    System.out.print(" "+charorstar(t,t.b));
			else
			    System.out.print("  ^ ");
			break;
		    case 1:
			/* middle line */
			if (j%2>0)//j pair
			    System.out.print(charorstar(t,t.g)+" "+charorstar(t,t.d));
			else
			    System.out.print(charorstar(t,t.d)+" "+charorstar(t,t.g));
			break;
		    case 2:
			/* bottom line */
			if (j%2>0)
			    System.out.print(" ");
			else
			    System.out.print("/_" + charorstar(t,t.b) + "_\\");
		    }
		}
		System.out.println("");
	    }
	}
    }
    /**
     * place sur un plateau p la solution a un ensemble de triominos
     * en commencant par le triomino de la pointe en haut du plateau
     * @param jeu  tirage de triomino aleatoirement par la classe Jeu
     * @param p    plateau vide a completer
     * @param pos  premiere case du plateau case (0,0)
     * @return     true si tous les triominos ont pu etre places sinon false
     */
    public static boolean resoudre(Jeu jeu, Plateau p, PositionPlateau pos){
	//initialisation des marqueurs
	int largeur = p.getLargeur();
	boolean trouve = false;
	//cas de sortie
	if(p.dernierePosition(pos)){
	    System.out.println("sortie : "+pos.getIndex());
	    trouve = true;
	}else{
	    PositionPlateau next_pos = p.nextPosition(pos);
	    int i = 0;
	    //on s'assure que l'on ne dépasse pas le nombre de colonnes(largeur)
	    while ((i<(largeur*largeur))&&(!trouve)) {
		//on s'assure que le triomino n'est pas déjà posé sur le plateau
		if (!jeu.utilise(i)){
		    //on retire le triomino de ceux disponibles
		    Triomino t = jeu.enlever(i);
		    int j = 0;//nombre de fois  que le triomino sera retourné
		    //2 retournements maximum
		    while ((j<2)&&(!trouve)){
			//si les contraintes sont vérifiées
			System.out.println("index : "+pos.getIndex());
			if (p.contraintes(t,pos)){
			    //on place un triomino
			    p.placer(t,pos);
			    //si le triomino ne répond pas aux contraintes
			    //on enlève le triomino
			    if (resoudre(jeu,p,next_pos))
				trouve = true;
			    else{
				p.enlever(pos);
				System.out.println("on enlève");
			    }
			}
			//si le triomino n'a pas satisfait aux contraintes
			//on le tourne 2 fois maximum (j<3)
			if (!trouve){
			    j++;
			    t = t.rotation();
			    System.out.println("on retourne "+j);
			}
		    }
		    //si test non satisfait après 2 retournements...
		    //le triominos retourne au jeu
		    if (!trouve){
			jeu.ajouter(i);
			i++;
		    }
		}
		//si le triomino est déjà sur le plateau, on passe au suivant
		else
		    i++;
	    }
	}
	return trouve;//sortie de la récursivité
    }
    public static void tests(){
	System.out.println("tests en cours !");
    }
}
