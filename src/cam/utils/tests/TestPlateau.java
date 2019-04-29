package cam.utils.tests;

import cam.utils.personnages.Chasseur;
import cam.utils.personnages.Monstre;
import cam.utils.plateau.Plateau;

public class TestPlateau {

	public static void main(String[] args) {
		Monstre m = new Monstre(5, 5, "Kevin");
		Chasseur c = new Chasseur(0, 0, "Pierre");
		Plateau p = new Plateau(m, c, 10, 10);
		
		p.printPlateau();
	}
}
