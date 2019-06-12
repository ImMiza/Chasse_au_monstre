package cam.utils.ihm;

/**
 * Classe qui permet de gérer les cases de jeu pour une partie avec l'interface graphique du jeu
 * @author Allan Boukhebza
 */

import cam.utils.cases.Case;
import cam.utils.personnages.Position;
import javafx.scene.shape.Rectangle;

public class CaseIHM {
	// ATTRIBUTS
	private Case uneCase;
	private Rectangle rectangle;

	/**
	 * Constructeur
	 * @param x (int) position de la case en x par rapport au plateau
	 * @param y (int) position de la case en y par rapport au plateau
	 * @param layoutX (double) position en x du debut de la case
	 * @param layoutY (double) position en y du debut de la case
	 * @param width (double) largeur de la case
	 * @param height (double) longueur de la case
	 */
	public CaseIHM(int x, int y, double layoutX, double layoutY, double width, double height) {
		uneCase = new Case(new Position(x, y));
		rectangle = new Rectangle(layoutX, layoutY, width, height);
	}

	/**
	 * Getter de la case
	 * @return (Case) renvoie la case correspondante
	 */
	public Case getCase() {
		return this.uneCase;
	}

	/**
	 * Getter du rectangle
	 * @return (Rectangle) Renvoie le rectangle correspondant
	 */
	public Rectangle getRectangle() {
		return this.rectangle;
	}

	/**
	 * Setter de la case
	 * @param uneCase La case qui va remplacer celle initiale
	 */
	public void setCase(Case uneCase)
	{
		this.uneCase = uneCase;
	}

	/**
	 * Setter du rectangle
	 * @param rectangle Le rectangle qui va remplacer celui initial
	 */
	public void setRectangle(Rectangle rectangle)
	{
		this.rectangle = rectangle;
	}
}
