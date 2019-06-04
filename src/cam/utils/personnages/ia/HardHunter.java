package cam.utils.personnages.ia;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import cam.utils.ihm.PlateauIHM;
import cam.utils.personnages.Position;

public class HardHunter extends HunterIA{
	
	private List<Position> doublon = new ArrayList<>();

	public HardHunter(Position p, String nom) {
		super(p, nom);
	}

	public HardHunter(int x, int y, String nom) {
		super(x, y, nom);
	}

	@Override
	public Position ChoosePosition(PlateauIHM plateau) {
		return new Position(1, 1);
	}

	@Override
	public Position posePiege(PlateauIHM plateau) {
		boolean end = false;
		Position p = null;
		
		while(!end) {
			Random m = new Random();
			int maxX = plateau.getPlateau().length;
			int x = m.nextInt(maxX);
			int maxY = plateau.getPlateau()[0].length;
			int y = m.nextInt(maxY);
			p = new Position(x, y);
			if(doublon.contains(p) == false) {
				doublon.add(p);
				end = true;
			}
			
		}
		System.out.println(p);
		return p;
	}

}
