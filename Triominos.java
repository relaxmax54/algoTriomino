import java.util.Random;
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
	Random generator = new Random();
	int base,size;
	base =  2 + Math.abs(generator.nextInt()%15);
	size =  1 + Math.abs(generator.nextInt()%6);
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
	int i=0;
	Triomino tr;
	for(int r=0;r<size;r++){
	    for(int c=0;c<r*2+1;c++){
		p.set(jeu.get(i),i,r,c);
		i++;
	    }
	}
	affiche_plateau_mini(p);
	//on retire tous les triominos du plateau pour résoudre le problème
	p.vider();
	//
	if(size>1){
	    if(resoudre(jeu,p,p.pos[0])){
		System.out.print("Résultat :  " );
		affiche_plateau_mini(p);
	    }else
		System.out.println("Pas de résultat trouvé !");
	}else{
	    System.out.println("Résultat : La solution est identique à la question " );
	}
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
     * @param Triomino t
     * 			Triomino a ecrire
     * @param int c
     * 			face a ecrire
     * @return char
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
		for(int j=0 ; j <= 2*i ; j++ ){
		    Triomino t=p.get(i,j);
		    switch (l){
		    case 0:
			/* top line */
			if (j%2>0)//j pair
			    System.out.print(" "+charorstar(t,t.getBase()));
			else
			    System.out.print("  ^ ");
			break;
		    case 1:
			/* middle line */
			if (j%2>0)//j pair
			    System.out.print(charorstar(t,t.getDroite())+" "+charorstar(t,t.getGauche()));
			else
			    System.out.print(charorstar(t,t.getGauche())+" "+charorstar(t,t.getDroite()));
			break;
		    case 2:
			/* bottom line */
			if (j%2>0)
			    System.out.print(" ");
			else
			    System.out.print("/_" + charorstar(t,t.getBase()) + "_\\");
		    }
		}
		System.out.println("");
	    }
	}
    }
    /**
     * place sur un plateau p la solution a un ensemble de triominos
     * en commencant par le triomino de la pointe en haut du plateau
     * @param Jeu             jeu tirage de triomino aleatoirement par la classe Jeu
     * @param Plateau p       plateau vide a completer
     * @param PositionPlateau pos  premiere case du plateau case (0,0)
     * @return boolean        true si tous les triominos ont pu etre places sinon false
     */
    public static boolean resoudre(Jeu jeu, Plateau p, PositionPlateau pos){
	//initialisation des marqueurs
	int largeur = p.getLargeur();
	boolean trouve = false;
	//cas de sortie
	if(p.dernierePosition(pos)){
	    trouve = true;
	}else{
	    int i = 0;
	    //on s'assure que l'on ne dépasse pas le nombre de colonnes(largeur)
	    while ((i<(largeur*largeur))&&(!trouve)) {
		//triomino déjà posé sur le plateau ?
		if (!jeu.utilise(i)){
		    //on retire un triomino de ceux disponibles dans le jeu
		    Triomino t = jeu.enlever(i);
		    int j = 0;//nombre de fois  que le triomino sera retourné
		    //2 retournements maximum
		    while ((j<2)&&(!trouve)){
			//si les contraintes sont vérifiées
			if (p.contraintes(t,pos)){
			    //on place le triomino à la position en cours
			    p.placer(t,pos);
			    //si le triomino ne répond pas aux contraintes
			    //on enlève le triomino
			    if (resoudre(jeu,p,p.nextPosition(pos))){
				trouve = true;
			    }else{
				p.enlever(pos);
			    }
			}
			//si le triomino n'a pas satisfait aux contraintes
			//on le tourne 2 fois maximum (j<3)
			if (!trouve){
			    j++;
			    t.rotation();
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
}
