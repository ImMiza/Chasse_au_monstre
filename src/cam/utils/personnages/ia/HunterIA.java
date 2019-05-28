package cam.utils.personnages.ia;

import cam.utils.personnages.Chasseur;
import cam.utils.personnages.Position;
import cam.utils.plateau.Plateau;

public abstract class HunterIA extends Chasseur implements IA{

	public HunterIA(int x, int y, String nom) {
		super(x, y, nom);
	}

	public HunterIA(Position p, String nom) {
		super(p, nom);
	}

	public abstract Position posePiege(Plateau plateau);
	
}
