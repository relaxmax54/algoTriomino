/**
 * classe Plateau modelise un plan triangulaire
 * sur lequel poser les triominos
 */
public class Plateau{
    //largeur du plateau en nombre de colonnes
    int largeur;
    //tableau de triominos par colonne
    ColonneTriominos[] triominos=null;
    PositionPlateau[] pos;
    /**
     * constructeur general
     * @param largeur du plateau
     */
    Plateau(int largeur){
	//le Plateau reprend la largeur du jeu
	this.largeur=largeur;
	//on crée autant de colonnes que l'unité de largeur
	triominos=new ColonneTriominos[largeur];
	//on crée des colonnes dont la hauteur varie en fonction de leur position dans le jeu
	for(int i=0;i<largeur;i++)
	    triominos[i]=new ColonneTriominos(2*i+1);
	//on crée autant de positions qu'il existe de triominos dans le plateau
	pos=new PositionPlateau[largeur*largeur];
	int i=0;
	for(int r=0;r<largeur;r++){
	    for(int c=0;r<r*2+1,r++){
		//cas généraux
		if(c%2==0)                 //colonne paires
		    pos[i]=new PositionPlateau(r,c,6);
		else                       //colonnes impaires
		    pos[i]=new PositionPlateau(r,c,7);
		//cas particuliers
		if(r=0)          //première rangée
		    pos[i].setType(1);
		else if(r=r*2+1){//dernière rangée
		    if(c=0)
			pos[i].setType(2);
		    if(c=r*2+1)
			pos[i].setType(3);
		    if(c%2>0)              //colonnes impaires
			pos[i].setType(8);
		    else                   //colonnes paires
			pos[i].setType(7);
			}else{   //toutes les autres rangées
		    if(c=0)
			pos[i].setType(4);
		    if(c=r*2+1)
			pos[i].setType(5);
		}
	    }
	}
    }
    /**
     * methode d acces a l attribut largeur du plateau
     * @return largeur
     */
    public int getLargeur() {
	return largeur;
    }
    /**
     * methode de placement d un triomino
     * @param i numero de colonne de l endroit ou placer
     * @param j rang dans la colonne de l endroit ou placer
     * @param t triomino a placer
     */
    void set(int i,int j,Triomino t) {
	triominos[i].set(j,t);
    }
    /**
     * methode d acces a un triomino deja place
     * @param i numero de la colonne ou se trouve le triomino
     * @param j rang du triomino dans sa colonne
     * @return triomino
     */
    Triomino get(int i,int j) {
	return triominos[i].get(j);
    }

    /**
     * methode enlever
     * enleve un triomino du plateau
     * typiquement s il y a un probleme de placement
     * @param p position du triomino a enlever
     */
    public void enlever(PositionPlateau p) {
	int c = p.getColonne();
	int r = p.getRangee();
	System.out.println("Colonne : "+c+" Rangée : "+r);
	(this.triominos[c]).set(r,null);

    }
    /**
     * methode pour placer un Triomino sur le plateau
     */
    public void placer(Triomino t, PositionPlateau p){
	/*int i = p.getColonne();
	int j = p.getRangee();
	(this.triominos[i]).set(j,t);
	*/
    }
    /**
     * methode pour verifier le respect des contraintes
     */
    public boolean contraintes(Triomino t, PositionPlateau p) {
	int c = p.getColonne();
	int r = p.getRangee();
	//y'a-t-il un triomino à tester sous/sur la base ?
	//	System.out.println("Colonne : "+c+" Rangée : "+r);
	//la base du triomino correspond-t'elle à la base du haut ?
	//la base du triomino correspond-t'elle à la base du bas ?
	//y'a-t'il un triomino à gauche ?
	//les valeurs correspondent-elles ?
	//y'a-t'il un triomino à droite ?
	//les valeurs correspondent-elles ?

    	return true;
    }
    
    
}

