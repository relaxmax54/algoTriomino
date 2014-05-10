/**
* classe Triomino modelise le triomino
* en fonction de la valeur inscrite
* sur chacune de ses trois faces
*/
public class Triomino{
// attributs
    int b,g,d;
    /**
     * getter de l'attribut b
     */
    public int getBase(){
	return this.b;
    }
    /**
     * getter de l'attribut b
     */
    public int getDroite(){
	return this.d;
    }
    /**
     * getter de l'attribut b
     */
    public int getGauche(){
	return this.b;
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
    public Triomino rotation() {
	int tmp;
	tmp = b;
	b = d;
	d = g;
	g = tmp;
	Triomino t = new Triomino(b,g,d);
	return t;
    }
}

