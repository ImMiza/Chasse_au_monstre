package cam.utils.personnages;

public class Monstre extends Personnage{
	
	private boolean bloque;
	private int deplacementVertical;
	private int deplacementHorizontal;
	private int deplacementDiagonal;

	public Monstre(Position p, String nom) {
		super(p, nom);
		this.bloque = false;
		this.deplacementVertical = 2;
		this.deplacementHorizontal = 2;
		this.deplacementDiagonal = 1;
	}
	
	public Monstre(int x, int y, String nom) {
		this(new Position(x, y), nom);
	}

	public boolean isBloque() {
		return bloque;
	}

	public void setBloque(boolean bloque) {
		this.bloque = bloque;
	}

	public int getDeplacementVertical() {
		return deplacementVertical;
	}

	public void setDeplacementVertical(int deplacementVertical) {
		this.deplacementVertical = deplacementVertical;
	}

	public int getDeplacementHorizontal() {
		return deplacementHorizontal;
	}

	public void setDeplacementHorizontal(int deplacementHorizontal) {
		this.deplacementHorizontal = deplacementHorizontal;
	}

	public int getDeplacementDiagonal() {
		return deplacementDiagonal;
	}

	public void setDeplacementDiagonal(int deplacementDiagonal) {
		this.deplacementDiagonal = deplacementDiagonal;
	}
}
