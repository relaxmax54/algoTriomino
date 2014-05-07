import java.util.Random;
import java.io.*;
/**
 * classe jeu modelise des
 * tirages de triomino
 */
public class Jeu{
    // attributs
    private int largeur;
    private Triomino[] pieces=null;
    private boolean[] utilises=null;
    /**
     * constructeur general
     * @param largeur
     * largeur du plateau destine a recevoir les triominos
     * @param base
     * nombre de valeurs possibles par face avant de la tirer au sort (2 si binaire, 16 si hexa)
     */
    Jeu(int largeur,int base) {
		this.largeur=largeur;
		pieces=new Triomino[largeur*largeur];
		utilises=new boolean[largeur*largeur];
		Random generator = new Random();
		for (int i=0;i<largeur*largeur;i++) {
		    pieces[i]=new Triomino(Math.abs(generator.nextInt()%base), Math.abs(generator.nextInt()%base), Math.abs(generator.nextInt()%base));
		}
		for (int i=0;i<largeur*largeur;i++) {
		    utilises[i]=false;
		}
    }
    
    /**
     * methode ajouter remet un triomino dans la pioche
     * apres avoir essaye en vain de le placer
     * @param i
     * 			rang du triomino dans la pioche de depart	
     */
    public void ajouter(int i) {
    	utilises[i] = false;
    }
    
    /**
     * methode enlever prend un triomino dans la pioche
     * @param i
     * 			rang du triomino dans la pioche
     * @return
     * 			triomino de rang i dans la pioche de depart
     */
    public Triomino enlever(int i) {
    	utilises[i] = true;
    	return pieces[i];
    }
    
    /**
     * methode utilise teste si un triomino est toujours dans la pioche
     * ou au contraire est place ou en cours de placement
     * @param i
     * 			rang du triomino dans la pioche
     * @return
     * 			true si le triomino est toujours dans la pioche, false autrement
     */
    
    public boolean utilise(int i) {
    	if (this.utilises[i])
    		return true;
    	else
    		return false;
    }
    
    /**
     * methode ecrit
     * ecrit le tirage de triominos dans un fichier texte
     */
    void ecrit(PrintWriter pw) {
    	String l1 = new String();
    	String l2 = new String();
    	String l3 = new String();
		for(int i=0; i<largeur*largeur;i++)
			l1 += "   ^  ";
		pw.println(l1);
		for(int i=0; i<largeur*largeur;i++)
			l2 += "  "+Triominos.onechar(pieces[i].d) + " "+Triominos.onechar(pieces[i].g)+ " ";
		pw.println(l2);
		for(int i=0; i<largeur*largeur;i++)
			l3 += " /_" + Triominos.onechar(pieces[i].b) + "_\\";
		pw.println(l3);
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
          System.out.print("  "+Triominos.onechar(pieces[j2].d) + " "+Triominos.onechar(pieces[j2].g)+ " ");
        System.out.println("");
        for(j3 = i ; (j3 < largeur*largeur) && (j3 < i+12) ; j3++)
          System.out.print(" /_" + Triominos.onechar(pieces[j3].b) + "_\\");
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
    	return pieces[i];
    }


}
