package cam.utils.personnages.ia;

/**
 * Classe qui gère une IA simple pour le Chasseur
 * @author Adrien Bassail
 */

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
	/**
	 * Methode permettant de choisir de facon iltellignete la prochaine position du chasseur 
	 * Le chasseur chassea de facon aléatoire jusqu'a ce qu'il trouve une case sur laquelle
	 * le monstre est déja passé, si il est passé il y à peu de temps, le chasseur essayera de toucher le monstre
	 * sur les cases entourant la case sur laquelle il sait que le monstre est passé il y a peu de temps.
	 */
	public Position ChoosePosition(PlateauIHM plateau) {
	
		
		if(lastPositionHunter != null) {
			if(plateau.chercheCase(lastPositionHunter.getX(), lastPositionHunter.getY()).getCase().getTourVisited() < 3) {
				
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
	/**
	 * Méthode qui permet de poser de façon aléatoire des pièges pour le chasseur 
	 * sans effectuer de doublons
	 */
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
