import java.util.Random;
/**
 * classe jeu modelise des
 * tirages de triomino
 */
public class Jeu{
    // attributs
    private int largeur;
    private Triomino[] tab=null;
    /**
     * constructeur general
     * @param largeur
     * largeur du plateau destine a recevoir les triominos
     * @param base
     * nombre de valeurs possibles par face avant de la tirer au sort (2 si binaire, 16 si hexa)
     */
    Jeu(int largeur,int base) {
	this.largeur=largeur;
	tab=new Triomino[largeur*largeur];
        Random generator = new Random();
	for (int i=0;i<largeur*largeur;i++) {
	    tab[i]=new Triomino(Math.abs(generator.nextInt()%base), Math.abs(generator.nextInt()%base), Math.abs(generator.nextInt()%base));
	}
    }
    /**
     * methode affiche
     * affiche le tirage sous forme textuelle
     * affichage des triominos cote a cote sur les 3 memes lignes
     * retour a la ligne tous les 12 triominos
     */
    void affiche() {
      for(int i=0; i<largeur*largeur;i+=12){
        int j1,j2,j3;
        for(j1 = i ; (j1 < largeur*largeur) && (j1 < i+12) ; j1++)
          System.out.print("   ^  ");
        System.out.println("");
        for(j2 = i ; (j2 < largeur*largeur) && (j2 < i+12) ; j2++)
          System.out.print("  "+Triominos.onechar(tab[j2].c) + " " 
                              +Triominos.onechar(tab[j2].b)+ " ");
        System.out.println("");
        for(j3 = i ; (j3 < largeur*largeur) && (j3 < i+12) ; j3++)
          System.out.print(" /_" + Triominos.onechar(tab[j3].a) + "_\\");
        System.out.println("");
      }
    }
    /**
     * methode d acces au triomino d un tirage
     * @param i
     * rang du triomino dans le tirage
     * @return
     * triomino
     */
    Triomino get(int i) {
	return tab[i];
    }


}
