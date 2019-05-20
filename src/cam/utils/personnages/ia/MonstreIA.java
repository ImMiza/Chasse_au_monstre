package cam.utils.personnages.ia;

import cam.utils.personnages.Monstre;
import cam.utils.personnages.Position;

public abstract class MonstreIA extends Monstre implements IA{

	public MonstreIA(int x, int y, String nom) {
		super(x, y, nom);
	}

	public MonstreIA(Position p, String nom) {
		super(p, nom);
	}
}
