package cam.utils.personnages.ia;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import cam.utils.ihm.PlateauIHM;
import cam.utils.personnages.Position;

public class EasyHunter extends HunterIA{
	
	private List<Position> doublon = new ArrayList<>();
	private Position lastPositionHunter;

	public EasyHunter(int x, int y, String nom) {
		super(x, y, nom);
	}

	@Override
	public Position ChoosePosition(PlateauIHM plateau) {
	
		
		if(lastPositionHunter != null) {
			if(plateau.chercheCase(lastPositionHunter.getX(), lastPositionHunter.getY()).getTourVisited() < 3) {
				
				List<Position> cases = new ArrayList<>();
				try {
					cases.add(new Position(lastPositionHunter.getX()+1, lastPositionHunter.getY()));
				} catch (ArrayIndexOutOfBoundsException e) {
				}
				try {
					cases.add(new Position(lastPositionHunter.getX()-1, lastPositionHunter.getY()));
				} catch (ArrayIndexOutOfBoundsException e) {
				}
				try {
					cases.add(new Position(lastPositionHunter.getX(), lastPositionHunter.getY()+1));
				} catch (ArrayIndexOutOfBoundsException e) {
				}
				try {
					cases.add(new Position(lastPositionHunter.getX()-1, lastPositionHunter.getY()-1));
				} catch (ArrayIndexOutOfBoundsException e) {
				}
				
				Collections.shuffle(cases);
				return cases.get(0);
				
			}
			
		}
		
		Random m = new Random();
		int maxX = plateau.getPlateau().length;
		int maxY = plateau.getPlateau()[0].length;
		int x = m.nextInt(maxX);
		int y = m.nextInt(maxY);
		lastPositionHunter = new Position(x, y);
		return new Position(x, y);
		
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
