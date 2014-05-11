/**
* classe Triomino modelise le triomino
* en fonction de la valeur inscrite
* sur chacune de ses trois faces
*/
public class Triomino{
// attributs
    int b,g,d;
    int r,c;
    /**
     * getter de l'attribut b
     */
    public int getBase(){
	return this.b;
    }
    /**
     * getter de l'attribut d
     */
    public int getDroite(){
	return this.d;
    }
    /**
     * getter de l'attribut g
     */
    public int getGauche(){
	return this.g;
    }
    /**
     * constructeur general
     * @param b valeur de la base du triomino
     * @param g valeur du cote gauche du triomino
     * @param d valeur du cote droit du triomino
     */
    public Triomino(int b,int g,int d) {
	this.b=b;
	this.g=g;
	this.d=d;
    }
    /**
     * methode rotation permute les faces de triomino
     * dans le sens des aiguilles d'une montre
     * @return nouveau triomino
     */
    public void rotation() {
	int tmp;
	tmp = b;
	b = d;
	d = g;
	g = tmp;
    }
    public void setPlace(int r, int c){
	this.r=r;
	this.c=c;
    }
}

