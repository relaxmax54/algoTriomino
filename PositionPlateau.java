/**
 * classe PositionPlateau modelise des cases de plateau de triomino
 * @author remi
 *
 */
public class PositionPlateau {
    // triomino placé à cette position
    private Triomino triomino;
    // colonne correspondante à cette position
    private int colonne;
    // rangée correspondante à cette position
    private int rangee;
    // index correspondant à l'ordre de la position sur un plateau
    private int index;
    /**
     * type codé sur un octet Gauche/Bas/Haut/Droite
     * permet de modéliser les types de positions sur un plateau :
     * 0b0100 4  - 1 valeur à tester dans le rang au dessous de la base
     * 0b0001 1  - 1 valeur à tester dans la colonne de droite
     * 0b1000 8  - 1 valeur à tester dans la colonne de gauche
     * 0b0101 5  - 2 valeurs à tester rang au-dessous et colonne de droite
     * 0b1100 12 - 2 valeurs à tester rang au-dessous et colonne de gauche
     * 0b1101 13 - 3 valeurs à tester dont rang au-dessous de la base
     * 0b1011 11 - 3 valeurs à tester dont rang au-dessus de la base
     * 0b1001 9  - 2 valeurs à tester à gauche et à droite dans le rang
     */
    private int type;
    /**
     * constructeur general
     * @param int c colonne de la case a construire
     * @param int r rangee de la case a construire
     * @param int i index de la position sur un plateau
     * @param int t type de position 
     */
    public PositionPlateau(int r, int c, int t, int i) {
	this.triomino=null;//au départ aucun triomino n'est attribué;
	this.colonne=c;
	this.rangee=r;
	this.type=t;
	this.index=i;
    }
    /**
     * getter pour accéder au type de la position
     *@return int type
     */
    public int getType(){
	return this.type;
    }
    /**
     * setter pour modifier le type de position
     *@param : int type : type de position
     *
     */
    public void setType(int t){
	this.type=t;
    }
    /**
     * getter pour accéder au Triomino de la position
     *@return Triomino triomino
     */
    public Triomino getTriomino(){
	return this.triomino;
    }
    /**
     * getter pour accéder i l'index de la position
     *@return int index
     */
    public int getIndex(){
	return this.index;
    }
    /**
     * setter pour accéder au Triomino de la position
     *@param : Triomino t triomino de la position
     */
    public void setTriomino(Triomino t){
	this.triomino=t;
    }
    /**
     * methode d acces a une coordonnee(colonne) du plateau
     * @return int colonne de la case
     */
    public int getColonne() {
	return colonne;
    }
    /**
     * methode d acces a une coordonnee(rangee) du plateau
     * @return int rangee de la case
     */
    public int getRangee() {
	return rangee;
    }
}
