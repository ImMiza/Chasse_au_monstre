package cam.utils.personnages.ia;

import cam.utils.personnages.Chasseur;
import cam.utils.personnages.Position;
import cam.utils.plateau.Plateau;

public abstract class ChasseurIA extends Chasseur implements IA{

	public ChasseurIA(int x, int y, String nom) {
		super(x, y, nom);
	}

	public ChasseurIA(Position p, String nom) {
		super(p, nom);
	}

	public abstract Position posePiege(Plateau plateau);
	
}
