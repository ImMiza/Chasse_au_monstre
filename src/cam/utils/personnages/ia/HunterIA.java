package cam.utils.personnages.ia;

import cam.utils.ihm.PlateauIHM;
import cam.utils.personnages.Chasseur;
import cam.utils.personnages.Position;

public abstract class HunterIA extends Chasseur implements IA{

	public HunterIA(int x, int y, String nom) {
		super(x, y, nom);
	}

	public HunterIA(Position p, String nom) {
		super(p, nom);
	}

	public abstract Position posePiege(PlateauIHM plateau);
	
}
