package cam.utils.ia;

import java.util.List;

import cam.utils.cases.Case;
import cam.utils.personnages.Personnage;
import cam.utils.personnages.Position;
import cam.utils.plateau.Plateau;

public class NormalHunterIA extends Personnage{

	/**
	 * CLASSE EN TRAVAUX
	 */
	private List<Case> caseVisited;
	private List<Boolean> caseVisitedBoolean;

	public NormalHunterIA(int x, int y, String nom) {
		super(x, y, nom);
	}

	public NormalHunterIA(Position p, String nom) {
		super(p, nom);
	}

	public Position posePiege(Plateau plateau) {
		int ligne = (int) (Math.random() * plateau.getPlateau().length);
		int colonne = (int) (Math.random() * plateau.getPlateau()[0].length);
		return new Position(ligne, colonne);
	}
	
//	public Position clicCase(Plateau plateau) {
//	}
}
