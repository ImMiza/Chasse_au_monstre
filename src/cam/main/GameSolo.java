package cam.main;

import cam.utils.cases.TrapCase;
import cam.utils.personnages.Chasseur;
import cam.utils.personnages.Monstre;
import cam.utils.personnages.Position;

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

		System.out.println("==== MONSTRE : " + Menu.getNomMonstre());
		
		if(isJoueur1IsMonster())
			placeMonstre((Monstre) getJoueur1(), getPlateau());
		else
			placeMonstre((Monstre) getJoueur2(), getPlateau());
		
		clearScreen();
		
		System.out.println("==== CHASSEUR : " + Menu.getNomChasseur());
		
		System.out.println("1er piege :");
		piege1 = posePiege();
		
		System.out.println("2eme piege :");
		piege2 = posePiege();

		System.out.println("3eme piege :");
		piege3 = posePiege();

		clearScreen();
		
		getPlateau().getPlateau()[piege1.getX()][piege1.getY()] = new TrapCase();
		getPlateau().getPlateau()[piege2.getX()][piege2.getY()] = new TrapCase();
		getPlateau().getPlateau()[piege3.getX()][piege3.getY()] = new TrapCase();
		
		while (!isGameFinish()) {
			tourDuMonstre(getPlateau());
			clearScreen();
			
			if(isJoueur1IsMonster())
				tourDuChasseur(getPlateau(), (Monstre) getJoueur1(), (Chasseur) getJoueur2());
			else
				tourDuChasseur(getPlateau(), (Monstre) getJoueur2(), (Chasseur) getJoueur1());
			
			clearScreen();
		}
	}
	
}
