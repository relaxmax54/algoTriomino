/**
 * classe Plateau modelise un plan triangulaire
 * sur lequel poser les triominos
 */
public class Plateau{
    //largeur du plateau en nombre de colonnes
    int largeur;
    //tableau de triominos par colonne
    ColonneTriominos[] triominos=null;
    /**
     * constructeur general
     * @param largeur du plateau
     */
    Plateau(int largeur){
	this.largeur=largeur;
	triominos=new ColonneTriominos[largeur];
	for(int i=0;i<largeur;i++)
	    triominos[i]=new ColonneTriominos(2*i+1);
    }
    /**
     * methode d acces a l attribut largeur du plateau
     * @return largeur
     */
    public int getLargeur() {
	return largeur;
    }
    /**
     * methode de placement d un triomino
     * @param i numero de colonne de l endroit ou placer
     * @param j rang dans la colonne de l endroit ou placer
     * @param t triomino a placer
     */
    void set(int i,int j,Triomino t) {
	triominos[i].set(j,t);
    }
    /**
     * methode d acces a un triomino deja place
     * @param i numero de la colonne ou se trouve le triomino
     * @param j rang du triomino dans sa colonne
     * @return triomino
     */
    Triomino get(int i,int j) {
	return triominos[i].get(j);
    }

    /**
     * methode enlever
     * enleve un triomino du plateau
     * typiquement s il y a un probleme de placement
     * @param p position du triomino a enlever
     */
    public void enlever(PositionPlateau p) {
	int i = p.getColonne();
	int j = p.getRangee();
	(this.triominos[i]).set(j,null);
    }
    /**
     * methode pour placer un Triomino sur le plateau
     */
    public void placer(Triomino t, PositionPlateau p){
	int i = p.getColonne();
	int j = p.getRangee();
	(this.triominos[i]).set(j,t);
    }
    /**
     * methode pour verifier le respect des contraintes
     */
    public boolean contraintes(Triomino t, PositionPlateau p) {
	//la base du triomino correspond-t'elle à la base du haut ?
	//la base du triomino correspond-t'elle à la base du bas ?
	//y'a-t'il un triomino à gauche ?
	//les valeurs correspondent-elles ?
	//y'a-t'il un triomino à droite ?
	//les valeurs correspondent-elles ?

    	return true;
    }
    
    
}

