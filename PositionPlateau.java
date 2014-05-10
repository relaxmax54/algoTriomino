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
     * type permet de modéliser les types de positions sur un plateau :
     * 1 - 1 valeur à tester dans le rang au dessous de la base
     * 2 - 1 valeur à tester dans la colonne de droite
     * 3 - 1 valeur à tester dans la colonne de gauche
     * 4 - 2 valeurs à tester dans le rang au-dessous la base et la colonne de droite
     * 5 - 2 valeurs à tester dans le rang au-dessous la base et la colonne de gauche
     * 6 - 3 valeurs à tester dont une dans le rang au-dessous de la base
     * 7 - 3 valeurs à tester dont une dans le rang au-dessus de la base
     * 8 - 2 valeurs à tester à gauche et à droite dans le rang
     */
    private int type;
    /**
     * constructeur general
     * @param int c colonne de la case a construire
     * @param int r rangee de la case a construire
     * @param int i index de la position sur un plateau
     */
    public PositionPlateau(int c, int r, int t, int i) {
	this.triomino=null;//au départ aucun triomino n'est attribué à une position;
	this.colonne=c;
	this.rangee=r;
	this.type=t;
	this.index=i;
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
     */
    public Triomino getTriomino(){
	return this.triomino;
    }
    /**
     * getter pour accéder i l'index de la position
     */
    public int getIndex(){
	return this.index;
    }
    /**
     * setter pour accéder au Triomino de la position
     */
    public void setTriomino(Triomino t){
	this.triomino=t;
    }

    //
    public int getType(){//A ENLEVER !!!!
	return this.type;
    }
    /**
     * methode d acces a une coordonnee(colonne) du plateau
     * @return
     * 			colonne de la case
     */
    public int getColonne() {
	return colonne;
    }
    
    /**
     * methode d acces a une coordonnee(rangee) du plateau
     * @return
     * 			rangee de la case
     */
    public int getRangee() {
	return rangee;
    }
}
