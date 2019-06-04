package cam.utils.tests;

import cam.utils.cases.Case;
import cam.utils.ihm.CaseIHM;
import cam.utils.ihm.PlateauIHM;
import cam.utils.personnages.Chasseur;
import cam.utils.personnages.Position;
import cam.utils.personnages.ia.EasyMonster;
import cam.utils.plateau.Plateau;

public class EasyMonsterTest {
	
	public static void main(String[] args) {
		EasyMonster monster = new EasyMonster(0, 0, "Adrien");
		
		Chasseur chasseur = new Chasseur(0, 0, "");
		PlateauIHM plateau = new PlateauIHM(monster, chasseur,initPlateau(10, 10));
		while(!plateau.sontToutesVisitee() && !plateau.monstreBloquer()) {

			Position pos = monster.ChoosePosition(plateau);
			
			plateau.deplacerMonstre(plateau.chercheCase(pos.getX(), pos.getY()));
			
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			clearScreen();
		}
		
		
		
		
	}
	
	
	
	
	
	
	
	public static CaseIHM[][] initPlateau(int lig, int col) {
		CaseIHM[][] plateau = new CaseIHM[lig][col];
		
		for (int i = 0; i < plateau.length; i++) {
			for (int j = 0; j < plateau[i].length; j++) {
				plateau[i][j] = new CaseIHM(i,j,0,0,10,10);
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
