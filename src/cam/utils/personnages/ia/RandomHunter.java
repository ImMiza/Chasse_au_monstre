package cam.utils.personnages.ia;

import java.util.Random;

import cam.utils.personnages.Position;
import cam.utils.plateau.Plateau;

public class RandomHunter extends ChasseurIA{
	//CONSTRUCTEURS
	public RandomHunter(int x, int y, String nom) {
		super(x, y, nom);
		// TODO Auto-generated constructor stub
	}

	public RandomHunter(Position p, String nom) {
		super(p, nom);
		// TODO Auto-generated constructor stub
	}

	//METHODES
	@Override
	public Position posePiege(Plateau plateau) {
		Random m = new Random();
		int maxX = plateau.getPlateau().length;
		int x = m.nextInt(maxX);
		int maxY = plateau.getPlateau()[0].length;
		int y = m.nextInt(maxY);
		return new Position(x, y);
	}

	@Override
	public Position ChoosePosition(Plateau plateau) {
		Random m = new Random();
		int maxX = plateau.getPlateau().length;
		int maxY = plateau.getPlateau()[0].length;
		int x = m.nextInt(maxX);
		int y = m.nextInt(maxY);
		return new Position(x, y);
	}

}
