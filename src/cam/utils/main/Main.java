package cam.utils.main;

import cam.utils.personnages.Chasseur;
import cam.utils.personnages.Monstre;
import cam.utils.plateau.Plateau;

/**
 * Class principale du programme
 * @author -
 */

public class Main {
	
	public static void main(String[] args) {
		
		Menu.menu();
		System.out.println(Menu.getChoixMenu());
		System.out.println(Menu.getNomChasseur());
		System.out.println(Menu.getNomMonstre());
		
		//Monstre m = new Monstre(0, 0, "monster");
		//Chasseur c = new Chasseur(1, 1, "chass");
		
		
		//Plateau p = new Plateau(m, c, 8, 8);
		
		//p.printPlateau();
		
		
	}

}
