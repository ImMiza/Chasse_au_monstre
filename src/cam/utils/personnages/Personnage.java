package cam.utils.personnages;

/**
 * Class qui permet de créer un personnage.
 * @author Aymeric DEFOSSEZ
 *
 */
public class Personnage {

	private Position position;
	private String nom;
	
	/**
	 * Constructeur permetant de créer un personnage avec une position déjà existante ainsi qu'un nom.
	 * @param p : Position existante du personnage.
	 * @param nom : Nom du personnage.
	 */
	public Personnage(Position p, String nom) {
		this.position = p;
		this.nom = nom;
	}
	
	/**
	 * Constructeur permetant de créer un personnage en donnant les coordonnées de sa position ainsi qu'un nom.
	 * @param x : 1ère coordonnée.
	 * @param y : 2nde coordonnée.
	 * @param nom : Nom du personnage.
	 */
	public Personnage(int x, int y, String nom) {
		this.position = new Position(x, y);
		this.nom = nom;
	}
	
	/**
	 * Retourne le nom du personnage.
	 * @return le nom du personnage.
	 */
	public String getNom() {
		return nom;
	}
	
	/**
	 * Permet de changer le nom du personnage
	 * @param nom le nouveau nom
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	/**
	 * Retourne la position du personnage.
	 * @return la position du personnage.
	 */
	public Position getPosition() {
		return position;
	}
	
	/**
	 * Permet de modifier la 1ère coordonnée de la position du personnage.
	 * @param x : Nouvelle coordonnée.
	 */
	public void setX(int x) {
		this.position.setX(x);
	}
	
	/**
	 * Permet de modifier la 2nde coordonnée de la position du personnage.
	 * @param y : Nouvelle coordonnée.
	 */
	public void setY(int y) {
		this.position.setY(y);
	}
}
