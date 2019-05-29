package cam.utils.ihm;

import cam.utils.cases.Case;
import cam.utils.personnages.Chasseur;
import cam.utils.personnages.Monstre;
import cam.utils.plateau.Plateau;
import javafx.scene.shape.Rectangle;

public class PlateauIHM {

	private Plateau plateau;
	private Rectangle[][] lesRectangles;
	
	public PlateauIHM(Monstre monstre, Chasseur chasseur, int nbLignes, int nbColonnes) {
		this.plateau = new Plateau(monstre, chasseur, nbLignes, nbColonnes);
		this.lesRectangles = new Rectangle[nbLignes][nbColonnes];
	}
	
	public Plateau getPlateau() {
		return plateau;
	}
	
	public Rectangle getRectangle(int i, int j) {
		return this.lesRectangles[i][j];
	}
	
	public Rectangle estDans(double x, double y) {
		for (int i = 0; i < lesRectangles.length; i++) {
			for (int j = 0; j < lesRectangles[0].length; j++) {
				if (lesRectangles[i][j].contains(x, y)) {
					return lesRectangles[i][j];
				}
			}
		}
		return null;
	}
	
	public Case getCase(int i, int j) {
		return this.plateau.chercheCase(i, j);
	}
	
	public Rectangle[][] getLesRectangles() {
		return lesRectangles;
	}
	
}
