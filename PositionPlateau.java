/**
 * classe PositionPlateau modelise des cases de plateau de triomino
 * @author remi
 *
 */
public class PositionPlateau {
	// attributs
	private int colonne;
	private int rangee;
	
	
	/**
	 * constructeur general
	 * @param c
	 * 			colonne de la case a construire
	 * @param r
	 * 			rangee de la case a construire
	 */
	public PositionPlateau(int c, int r) {
		this.colonne = c;
		this.rangee = r;
	}
	
	/**
	 * methode d acces a une coordonnee(colonne) du plateau
	 * @return
	 * 			colonne de la case
	 */
	public int getColonne() {
		return colonne;
	}

	/**
	 * methode d acces a une coordonnee(rangee) du plateau
	 * @return
	 * 			rangee de la case
	 */
	public int getRangee() {
		return rangee;
	}

	/**
	 * methode dernierePosition verifie si la position
	 * passee en parametre est la derniere du plateau
	 * @param largeur
	 * 					largeur du plateau
	 * @return
	 * 			true si la position est la derniere, false autrement
	 */
	public boolean dernierePosition(int largeur) {
		if (largeur == 1) {
			if ((rangee == 0)&&(colonne == 0))
				return true;
			else
				return false;
		}
		else {
			if ((rangee == colonne*2+1)&&(colonne == largeur-1))
				return true;
			else
				return false;
		}
	}
	
	/**
	 * methode nextPosition retourne la position consecutive
	 * de la position qui execute la methode
	 * @param largeur
	 * 					largeur du plateau
	 * @return p
	 * 			position suivante
	 */
	public PositionPlateau nextPosition(int largeur) {
		int c,r;
		if ((rangee == 0)&&(colonne == 0)) {
			c = 1;
			r = 0;
		}
		else {
			if (rangee == colonne*2+1) {
				c = colonne+1;
				r = 0;
			}
			else {
				c = colonne;
				r = rangee+1;
			}
		}
		PositionPlateau p = new PositionPlateau(c,r);
		return p;
	}
}
