/**
 * classe Plateau modelise un plan triangulaire
 * sur lequel poser les triominos
 */
public class Plateau{
    //attributs
    int largeur;
    ColonneTriominos[] triominos=null;
    /**
     * constructeur general
     * @param largeur
     * largeur du plateau
     */
    Plateau(int largeur) {
	this.largeur=largeur;
	triominos=new ColonneTriominos[largeur];
	for(int i=0;i<largeur;i++)
	    triominos[i]=new ColonneTriominos(2*i+1);
    }
    /**
     * methode de placement d un triomino
     * @param i
     * numero de colonne de l endroit ou placer
     * @param j
     * rang dans la colonne de l endroit ou placer
     * @param t
     * triomino a placer
     */
    void set(int i,int j,Triomino t) {
	triominos[i].set(j,t);
    }
    /**
     * methode d acces a un triomino deja place
     * @param i
     * numero de la colonne ou se trouve le triomino
     * @param j
     * rang du triomino dans sa colonne
     * @return
     * triomino 
     */
    Triomino get(int i,int j) {
	return triominos[i].get(j);
    }

}

