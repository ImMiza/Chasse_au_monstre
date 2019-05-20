package cam.utils.ihm;

import cam.utils.cases.Case;
import cam.utils.personnages.Position;
import javafx.scene.shape.Rectangle;

public class CaseIHM {
	
	private Case uneCase;
	private Rectangle rectangle;
	
	public CaseIHM(int x, int y, double width, double height) {
		uneCase = new Case(new Position(x, y));
		rectangle = new Rectangle(x, y, width, height);
	}
	
	public Case getCase() {
		return this.uneCase;
	}
	
	public Rectangle getRectangle() {
		return this.rectangle;
	}
	
}
