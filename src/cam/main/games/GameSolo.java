package cam.main.games;

import cam.utils.cases.TrapCase;
import cam.utils.ihm.MainController;
import cam.utils.ihm.menu.MenuIHM;
import cam.utils.personnages.Chasseur;
import cam.utils.personnages.Monstre;
import cam.utils.personnages.Position;
import cam.utils.personnages.ia.HunterIA;
import cam.utils.personnages.ia.MonstreIA;

/**
 * Deroulement d'une partie solo contre une IA
 * @author miza
 */
public class GameSolo extends Game{

	
	@Override
	public void start() {
		Position piege1;
		Position piege2;
		Position piege3;
		System.out.println("DEBUG 1 + " + isJoueur1IsMonster());
		
		MainController.writeConsole("MONSTRE: " + MenuIHM.getNomMonstre());
		MainController.setTextIndicator("Placer votre monstre");
		
		System.out.println("DEBUG 2");
		if(isJoueur1IsMonster())
			placeMonstre((Monstre) getJoueur1());
		else
			((MonstreIA) getJoueur2()).placeMonster(getPlateau());
		
		System.out.println("DEBUG 3");
		MainController.writeConsole("CHASSEUR: " + MenuIHM.getNomChasseur());

		System.out.println("DEBUG 4");
		if(isJoueur1IsMonster()) {
			piege1 = ((HunterIA) getJoueur2()).posePiege(getPlateau());
			piege2 = ((HunterIA) getJoueur2()).posePiege(getPlateau());
			piege3 = ((HunterIA) getJoueur2()).posePiege(getPlateau());
		}
		else {
			MainController.setTextIndicator("Placer le 1er piege");
			piege1 = posePiege();
			
			MainController.setTextIndicator("Placer le 2eme piege");
			piege2 = posePiege();

			MainController.setTextIndicator("Placer le 3eme piege");
			piege3 = posePiege();
		}

		System.out.println("DEBUG 5");
		getPlateau().getPlateau()[piege1.getX()][piege1.getY()].setCase(new TrapCase());
		getPlateau().getPlateau()[piege2.getX()][piege2.getY()].setCase(new TrapCase());
		getPlateau().getPlateau()[piege3.getX()][piege3.getY()].setCase(new TrapCase());
		
		System.out.println("DEBUG 6");
		while (!isGameFinish()) {
			
			if(isJoueur1IsMonster()) {
				MainController.removeHunter(getPlateau().getChasseur().getPosition().getX(), getPlateau().getChasseur().getPosition().getY());
				MainController.drawMonster(getPlateau().getMonstre().getPosition().getX(), getPlateau().getMonstre().getPosition().getY());
				tourDuMonstre(getPlateau());
			}
			else
				((MonstreIA) getJoueur2()).ChoosePosition(getPlateau());
			
			if(!isJoueur1IsMonster()) {
				MainController.removeMonster(getPlateau().getChasseur().getPosition().getX(), getPlateau().getChasseur().getPosition().getY());
				MainController.drawHunter(getPlateau().getMonstre().getPosition().getX(), getPlateau().getMonstre().getPosition().getY());
				tourDuChasseur(getPlateau(), (Monstre) getJoueur1(), (Chasseur) getJoueur2());
			}
			else
				((HunterIA) getJoueur2()).ChoosePosition(getPlateau());
			
		}
	}
	
}
