package cam.utils.personnages;

/**
 * Class qui permet de créer une position relative à un objet.
 * @author Aymeric DEFOSSEZ
 *
 */
public class Position {

	private int x, y;
	
	/**
	 * Constructeur qui prend en paramètre 2 int pour créer une position.
	 * @param x : 1ère coordonnée.
	 * @param y : 2nde coordonnée.
	 */
	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Retourne la 1ère coordonnée de la position.
	 * @return la 1ère coordonnée de la position.
	 */
	public int getX() {
		return x;
	}
	
	/**
	 * Permet de modifier la 1ère coordonnée de la position.
	 * @param x : Nouvelle coordonnée.
	 */
	public void setX(int x) {
		this.x = x;
	}
	
	/**
	 * Retourne la 2nde coordonnée de la position.
	 * @return la 2nde coordonnée de la position.
	 */
	public int getY() {
		return y;
	}
	
	/**
	 * Permet de modifier la 2nde coordonnée de la position.
	 * @param y : Nouvelle coordonnée.
	 */
	public void setY(int y) {
		this.y = y;
	}

	@Override
	public String toString() {
		return "Position [x=" + x + ", y=" + y + "]";
	}
	
	
}
