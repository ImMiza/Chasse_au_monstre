package cam.utils.personnages;

/**
 * Class caractérisant le monstre.
 * @author Aymeric DEFOSSEZ
 *
 */
public class Monstre extends Personnage{
	
	private boolean bloque;
	private int deplacementVertical;
	private int deplacementHorizontal;
	private int deplacementDiagonal;

	/**
	 * Constructeur permetant de créer un monstre avec une position déjà existante ainsi qu'un nom.
	 * @param p : Position existante du monstre.
	 * @param nom : Nom du monstre.
	 */
	public Monstre(Position p, String nom) {
		super(p, nom);
		this.bloque = false;
		this.deplacementVertical = 2;
		this.deplacementHorizontal = 2;
		this.deplacementDiagonal = 1;
	}
	
	/**
	 * Constructeur permetant de créer un monstre en donnant les coordonnées de sa position ainsi qu'un nom.
	 * @param x : 1ère coordonnée.
	 * @param y : 2nde coordonnée.
	 * @param nom : Nom du monstre.
	 */
	public Monstre(int x, int y, String nom) {
		this(new Position(x, y), nom);
	}

	/**
	 * Retourne true si le monstre est bloqué et false le cas échéant.
	 * @return true si le monstre est bloqué et false le cas échéant.
	 */
	public boolean isBloque() {
		return bloque;
	}

	/**
	 * Permet de changer le fait que le monstre soit bloqué ou non.
	 * @param bloque : (true) le monstre est bloqué. (false) le monstre n'est pas bloqué.
	 */
	public void setBloque(boolean bloque) {
		this.bloque = bloque;
	}

	/**
	 * Retourne le nombre de case que le monstre peux se déplacer verticalement.
	 * @return le nombre de case que le monstre peux se déplacer verticalement.
	 */
	public int getDeplacementVertical() {
		return deplacementVertical;
	}

	/**
	 * Permet de changer le nombre de case que le monstre peux se déplacer verticalement.
	 * @param deplacementVertical : Nouveau nombre de case.
	 */
	public void setDeplacementVertical(int deplacementVertical) {
		this.deplacementVertical = deplacementVertical;
	}

	/**
	 * Retourne le nombre de case que le monstre peux se déplacer horizontalement.
	 * @return le nombre de case que le monstre peux se déplacer horizontalement.
	 */
	public int getDeplacementHorizontal() {
		return deplacementHorizontal;
	}

	/**
	 * Permet de changer le nombre de case que le monstre peux se déplacer horizontalement.
	 * @param deplacementHorizontal : Nouveau nombre de case.
	 */
	public void setDeplacementHorizontal(int deplacementHorizontal) {
		this.deplacementHorizontal = deplacementHorizontal;
	}

	/**
	 * Retourne le nombre de case que le monstre peux se déplacer diagonalement.
	 * @return le nombre de case que le monstre peux se déplacer diagonalement.
	 */
	public int getDeplacementDiagonal() {
		return deplacementDiagonal;
	}

	/**
	 * Permet de changer le nombre de case que le monstre peux se déplacer diagonalement.
	 * @param deplacementDiagonal : Nouveau nombre de case.
	 */
	public void setDeplacementDiagonal(int deplacementDiagonal) {
		this.deplacementDiagonal = deplacementDiagonal;
	}
	
	/**
	 * Retourne la description du monstre.
	 */
	public String toString() {
		return "Monstre [" + this.getNom() + ", [" + this.getPosition().getX() + ", " + this.getPosition().getY() + "], " + this.bloque + "]";
	}
}
