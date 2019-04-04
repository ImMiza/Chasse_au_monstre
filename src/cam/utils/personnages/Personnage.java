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
	 * @param x : 
	 * @param y
	 * @param nom
	 */
	public Personnage(int x, int y, String nom) {
		this.position = new Position(x, y);
		this.nom = nom;
	}
	
	public String getNom() {
		return nom;
	}
	
	public Position getPosition() {
		return position;
	}
	
	public void setX(int x) {
		this.position.setX(x);
	}
	
	public void setY(int y) {
		this.position.setY(y);
	}
}
