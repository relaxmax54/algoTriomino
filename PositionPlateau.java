
public class PositionPlateau {
	private int colonne;
	private int rangee;
	
	public PositionPlateau(int c, int r) {
		this.colonne = c;
		this.rangee = r;
	}
	
	public int getColonne() {
		return colonne;
	}

	public int getRangee() {
		return rangee;
	}

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
