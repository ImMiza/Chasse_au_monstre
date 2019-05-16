package cam.utils.personnages.ia;

import cam.utils.personnages.Personnage;
import cam.utils.personnages.Position;
import cam.utils.plateau.Plateau;

public abstract class IA extends Personnage{

	public IA(Position p, String nom) {
		super(p, nom);
	}

	public IA(int x, int y, String nom) {
		super(x, y, nom);
	}

	public int ChoosePierreFeuilleCiseaux() {
		return (int) ((Math.random() * 3) + 1);
	}
	
	public abstract Position ChoosePosition(Plateau plateau);
	
}
