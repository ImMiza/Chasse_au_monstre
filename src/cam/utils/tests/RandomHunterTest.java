package cam.utils.tests;

import cam.utils.cases.Case;
import cam.utils.personnages.Position;
import cam.utils.personnages.ia.RandomHunter;
import cam.utils.personnages.ia.RandomMonster;
import cam.utils.plateau.Plateau;

public class RandomHunterTest {

	public static void main(String[] args) {
		RandomMonster monster = new RandomMonster(0, 0, "Adrien");
		RandomHunter chasseur = new RandomHunter(0, 0, "Allan");
		
		Plateau plateau = new Plateau(monster, chasseur, initPlateau(10, 10));
		
		for(int i = 0; i < 50; i++) {
			plateau.printPlateauDebug();
			Position pos = chasseur.ChoosePosition(plateau);
			
			chasseur.setX(pos.getX());
			chasseur.setY(pos.getY());
			
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			clearScreen();
		}

	}
	
	public static Case[][] initPlateau(int lig, int col) {
		Case[][] plateau = new Case[lig][col];
		
		for (int i = 0; i < plateau.length; i++) {
			for (int j = 0; j < plateau[i].length; j++) {
				plateau[i][j] = new Case(new Position(i, j));
			}
		}
		return plateau;
	}
	
	private static void clearScreen() {
		for(int i=0 ; i<50 ; i++) {
			System.out.println();
		}
	}
}
