/**
 * classe PositionPlateau modelise des cases de plateau de triomino
 * @author remi
 *
 */
public class PositionPlateau {
    // attributs
    private int colonne;
    private int rangee;
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
     * @param c
     * 			colonne de la case a construire
     * @param r
     * 			rangee de la case a construire
     */
    public PositionPlateau(int c, int r, int t) {
	this.colonne = c;
	this.rangee = r;
	this.type=t;
    }
    /**
     * setter pour modifier le type de position
     *@param : int type : type de position
     *
     */
    public void setType(int t){
	this.type=t;
    }
    public int getType(){
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
    
    /**
     * methode dernierePosition verifie si la position
     * passee en parametre est la derniere du plateau
     * @param largeur
     * 					largeur du plateau
     * @return
     * 			true si la position est la derniere, false autrement
     */
    public boolean dernierePosition(int largeur) {
	if (largeur == 1) {
	    if ((rangee == 0)&&(colonne == 0))
		return true;
	    else
		return false;
	}else{
	    if ((rangee == colonne*2+1)&&(colonne == largeur-1))
		return true;
	    else
		return false;
	}
    }
    /**
     * methode nextPosition retourne la position consecutive
     * de la position qui execute la methode
     * @param largeur
     * 					largeur du plateau
     * @return p
     * 			position suivante
     */
    public PositionPlateau nextPosition(int largeur) {
	int c,r,t;
	t=0;
	if ((rangee == 0)&&(colonne == 0)) {
	    c = 0;
	    r = 0;
	}
	else {
	    if (rangee == colonne*2+1) {
		c = colonne+1;
		r = 0;
	    }
	    else {
		c = colonne;
		r = rangee+1;
	    }
	}
	PositionPlateau p = new PositionPlateau(c,r,t);
	return p;
    }
}
