/**
 * classe Plateau modelise un plan triangulaire
 * sur lequel poser les triominos
 */
public class Plateau{
    //largeur du plateau en nombre de colonnes
    int largeur;
    //tableau  représentant toutes les positions possibles sur le plateau
    PositionPlateau[] pos;
    /**
     * constructeur general
     * @param largeur du plateau
     */
    Plateau(int largeur){
	//le Plateau reprend la largeur du jeu
	this.largeur=largeur;
	//on crée toutes les positions possibles dans le plateau
	pos=new PositionPlateau[largeur*largeur];
	int i=0;
	int milieu=largeur-1;
	for(int r=0;r<largeur;r++){
	    for(int c=0;c<r*2+1;c++){
		//cas généraux
		if(c%2==0)                 //colonne paires
		    pos[i]=new PositionPlateau(c+milieu,r,13,i);
		else                       //colonnes impaires
		    pos[i]=new PositionPlateau(c+milieu,r,11,i);
		//cas particuliers
		if(r==0)          //première rangée
		    pos[i].setType(4);
		else if(r==largeur-1){//dernière rangée
		    if(c%2>0)              //colonnes impaires
			pos[i].setType(11);
		    else                   //colonnes paires
			pos[i].setType(9);
		    if(c==0)
			pos[i].setType(1);
		    if(c==r*2)
			pos[i].setType(8);
		}else{   //toutes les autres rangées
		    if(c==0)
			pos[i].setType(5);
		    if(c==r*2)
			pos[i].setType(0b1100);
		}
		System.out.println(i+" "+(c+milieu)+" "+r+" "+pos[i].getType());
		i++;
	    }
	    milieu--;
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
     * @param index de la position du triomino
     * @param t triomino a placer
     */
    public void set(Triomino t,int index){
	pos[index].setTriomino(t);
    }
    /**
     * methode d acces a un triomino deja place
     * @param int r rang du triomino
     * @param int c colonne du Triomino
     * @return triomino
     */
    public Triomino get(int r,int c){
	int rep=0;
	for(int i=0;i<largeur*largeur;i++){
	    if(pos[i].getRangee()==r && pos[i].getColonne()==c)
		rep=i;
	}
	return pos[rep].getTriomino();
    }
    /**
     * methode pour placer un Triomino sur le plateau
     */
    public void placer(Triomino t, PositionPlateau p){
	p.setTriomino(t);
    }
    /**
     * methode enlever
     * enleve un triomino du plateau
     * typiquement s il y a un probleme de placement
     * @param p position du triomino a enlever
     */
    public void enlever(PositionPlateau p) {
	p.setTriomino(null);
    }    
    /**
     * dernierePosition verifie si la position
     * est la derniere du plateau
     * @return true si la position est la derniere, false autrement
     */
    public boolean dernierePosition(PositionPlateau p) {
	//l'attribut type=8 de PositionPlateau détermine la dernière position du plateau
	if(p.getType()==8)
	    return true;
	else
	    return false;
    }
    /**
     * methode nextPosition retourne la position suivante sur le plateau
     * @return p positionPlateau suivante
     */
    public PositionPlateau nextPosition(PositionPlateau p){
	return pos[p.getIndex()+1];
    }
    /**
     * methode pour verifier le respect des contraintes
     */
    public boolean contraintes(Triomino t, PositionPlateau p){
	boolean test=false;
	//rappel : la PositionPlateau p ne contient aucun Triomino / triomino=null
	//test à gauche = test du bit 4
	if((p.getType()&8)==8)
	    if(pos[p.getIndex()-1].getTriomino()==null)
		test=true;
	    else
		test=(t.getGauche()==pos[p.getIndex()-1].getTriomino().getDroite());//on compare la valeur de gauche avec celle de la droite du voisin
	//test à droite = test du bit 1
	if((p.getType()&1)==1)
	    if(pos[p.getIndex()+1].getTriomino()==null)//test si un triomino est à côté
		test=true;
	    else
		test=(t.getDroite()==pos[p.getIndex()+1].getTriomino().getGauche());
	//test en haut = test du bit 2
	if((p.getType()&2)==2){
	    int i=p.getIndex()-1;
	    while(p.getRangee()!=pos[i].getRangee())
		i--;//on recule jusqu'à retrouver la même rangée au dessus
	test=(t.getBase()==pos[i].getTriomino().getBase());
	}
	//test en bas = test du bit 3
	if((p.getType()&4)==4){
	    int i=p.getIndex()+1;
	    while(p.getRangee()!=pos[i].getRangee())
		i++;//on avance jusqu'à retrouver la même rangée en dessous
	    if(pos[i].getTriomino()==null)//test si un triomino en dessous
		test=true;
	    else
		test=(t.getBase()==pos[i].getTriomino().getBase());
	}
	//on retourne la valeur de test, true si tests satisfaits
	return test;
    }
}

