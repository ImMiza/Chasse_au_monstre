package cam.utils.personnages.ia;

import cam.utils.personnages.Monstre;
import cam.utils.personnages.Position;
import cam.utils.plateau.Plateau;

public class EasyMonster extends Monstre implements IA{

	public EasyMonster(int x, int y, String nom) {
		super(x, y, nom);
	}

	public EasyMonster(Position p, String nom) {
		super(p, nom);
	}

	public Position ChoosePosition(Plateau plateau) {
		return null;
	}
}
