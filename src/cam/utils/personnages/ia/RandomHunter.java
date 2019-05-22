package cam.utils.personnages.ia;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import cam.utils.personnages.Position;
import cam.utils.plateau.Plateau;

public class RandomHunter extends ChasseurIA{
	//ATTRIBUTS
	private List<Position> doublon = new ArrayList<>();
	
	
	//CONSTRUCTEURS
	public RandomHunter(int x, int y, String nom) {
		super(x, y, nom);
	}

	public RandomHunter(Position p, String nom) {
		super(p, nom);
		// TODO Auto-generated constructor stub
	}

	//METHODES
	@Override
	public Position posePiege(Plateau plateau) {
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
				//System.out.println(p);
				end = true;
			}
			
		}
		System.out.println(p);
		return p;
		
		
		/**
		Random m = new Random();
		int maxX = plateau.getPlateau().length;
		int x = m.nextInt(maxX);
		int maxY = plateau.getPlateau()[0].length;
		int y = m.nextInt(maxY);
		return new Position(x, y);
		//AJOUTER LA DETECTION DE DOUBLONS
		 **/
		 
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
