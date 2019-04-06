package cam.utils.personnages;

/**
 * Class caractérisant le chasseur.
 * @author Aymeric DEFOSSEZ
 *
 */
public class Chasseur extends Personnage{
	
	private boolean etourdi;
	
	/**
	 * Constructeur permettant de créer un chasseur avec une position déjà existante ainsi qu'un nom.
	 * @param p : Position existante du chasseur.
	 * @param nom : Nom du chasseur.
	 */
	public Chasseur(Position p, String nom) {
		super(p, nom);
	}

	/**
	 * Constructeur permetant de créer un chasseur en donnant les coordonnées de sa position ainsi qu'un nom.
	 * @param x : 1ère coordonnée.
	 * @param y : 2nde coordonnée.
	 * @param nom : Nom du chasseur.
	 */
	public Chasseur(int x, int y, String nom) {
		this(new Position(x, y), nom);
	}

	/**
	 * Retourne true si le chasseur est étourdi et false le cas échéant.
	 * @return true si le chasseur est étourdi et false le cas échéant.
	 */
	public boolean isEtourdi() {
		return etourdi;
	}

	/**
	 * Permet de changer le fait que le chasseur soit étourdi ou non.
	 * @param etourdi : (true) le chasseur est étourdi. (false) le chasseur n'est pas étourdi.
	 */
	public void setEtourdi(boolean etourdi) {
		this.etourdi = etourdi;
	}
	
	/**
	 * Retourne la description du chasseur.
	 */
	public String toString() {
		return "Chasseur [" + this.getNom() + ", [" + this.getPosition().getX() + ", " + this.getPosition().getY() + "], " + this.etourdi + "]";
	}
}
