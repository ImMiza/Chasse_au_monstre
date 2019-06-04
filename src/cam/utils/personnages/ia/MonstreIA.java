package cam.utils.personnages.ia;

import cam.utils.ihm.PlateauIHM;
import cam.utils.personnages.Monstre;
import cam.utils.personnages.Position;

public abstract class MonstreIA extends Monstre implements IA{

	public MonstreIA(int x, int y, String nom) {
		super(x, y, nom);
	}

	public MonstreIA(Position p, String nom) {
		super(p, nom);
	}
	
	public void placeMonster(PlateauIHM plateau) {
		plateau.getMonstre().setX(0);
		plateau.getMonstre().setY(0);
	}
}
