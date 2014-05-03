/**
 * classe ColonneTriominos modelise les colonnes
 * d un plateau de triomino
 * @author remi
 *
 */
public class ColonneTriominos{
	// attribut
    private Triomino[] colonne=null;
    
    /**
     * constructeur general
     * @param hauteur
     * 					hauteur de la colonne
     */
    ColonneTriominos(int hauteur) {
	colonne=new Triomino[hauteur];
    }

    /**
     * methode de placement d un triomino dans une colonne
     * @param j
     * 			rang du triomino dans la colonne
     * @param t
     * 			triomino a placer
     */
    void set(int j,Triomino t) {
	colonne[j]=t;
    }

    /**
     * methode d acces a un triomino de la pile
     * @param j
     * 			ordre dans la pile
     * @return
     * 			triomino possedant ce numero d ordre dans la pile
     */
    Triomino get(int j) {
	return colonne[j];
    }
}
