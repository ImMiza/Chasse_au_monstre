package cam.utils.tests;

import cam.utils.personnages.Position;

/**
 * Classe de test de Position
 * @author Boukhebza Allan
 *
 */
public class TestPosition {

	public static void main(String[] args) {
		Position pos = new Position(0, 0);
		
		System.out.println(pos.toString());
		System.out.println("X = " + pos.getX());
		System.out.println("Y = " + pos.getY());
		
		System.out.println("=====");
		pos.setX(5);
		pos.setY(6);
		System.out.println("X = " + pos.getX());
		System.out.println("Y = " + pos.getY());
	}
}
