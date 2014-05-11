/**
* classe Triomino modelise le triomino
* en fonction de la valeur inscrite
* sur chacune de ses trois faces
*/
public class Triomino{
    /**
     * int base valeur à la base du Triomino
     * int gauche valeur à gauche
     * int droite valeur à droite
     * int rangee rangee du Triomino
     * int colonne colonne du Triomino
     */
    private int base;
    private int gauche;
    private int droite;
    private int rangee;
    private int colonne;
    /**
     * getter de l'attribut b
     */
    public int getBase(){
	return this.base;
    }
    /**
     * getter de l'attribut d
     */
    public int getDroite(){
	return this.droite;
    }
    /**
     * getter de l'attribut g
     */
    public int getGauche(){
	return this.gauche;
    }
    /**
     * getter de l'attribut r
     */
    public int getRangee(){
	return this.rangee;
    }
    /**
     * getter de l'attribut c
     */
    public int getColonne(){
	return this.colonne;
    }
    /**
     * constructeur general
     * @param b valeur de la base du triomino
     * @param g valeur du cote gauche du triomino
     * @param d valeur du cote droit du triomino
     */
    public Triomino(int b,int g,int d) {
	this.base=b;
	this.gauche=g;
	this.droite=d;
    }
    /**
     * methode rotation permute les faces de triomino
     * dans le sens des aiguilles d'une montre
     * @return nouveau triomino
     */
    public void rotation() {
	int tmp;
	tmp = this.base;
	this.base = this.droite;
	this.droite = this.gauche;
	this.gauche = tmp;
    }
    public void setPlace(int r, int c){
	this.rangee=r;
	this.colonne=c;
    }
}

