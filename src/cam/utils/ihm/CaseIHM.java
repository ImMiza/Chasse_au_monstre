package cam.utils.ihm;

import cam.utils.cases.Case;
import cam.utils.personnages.Position;
import javafx.scene.shape.Rectangle;

public class CaseIHM {
	
	private Case uneCase;
	private Rectangle rectangle;
	
	public CaseIHM(int x, int y, double layoutX, double layoutY, double width, double height) {
		uneCase = new Case(new Position(x, y));
		rectangle = new Rectangle(layoutX, layoutY, width, height);
	}
	
	public Case getCase() {
		return this.uneCase;
	}
	
	public Rectangle getRectangle() {
		return this.rectangle;
	}
	
	public void setCase(Case uneCase)
	{
		this.uneCase = uneCase;
	}
	
	public void setRectangle(Rectangle rectangle)
	{
		this.rectangle = rectangle;
	}
}
