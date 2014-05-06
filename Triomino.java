/**
* classe Triomino modelise le triomino
* en fonction de la valeur inscrite
* sur chacune de ses trois faces
*/
public class Triomino{
// attributs
    int a,b,c;
/**
* constructeur general
* @param a
* 			valeur de la face 1
* @param b
* 			valeur de la face 2
* @param c
* 			valeur de la face 3
*/
    public Triomino(int a,int b,int c) {
		this.a=a;
		this.b=b;
		this.c=c;
    }
   
/**
 * methode rotation permute les faces de triomino
 * dans le sens alphabetique
 * @return
 * 			nouveau triomino
 */
    public Triomino rotation() {
    	int tmp;
    	tmp = c;
    	c = a;
    	a = b;
    	b = tmp;
    	Triomino t = new Triomino(a,b,c);
    	return t;
    }
}

