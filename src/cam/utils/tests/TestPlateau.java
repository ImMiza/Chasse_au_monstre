package cam.utils.tests;

import cam.utils.cases.Case;
import cam.utils.cases.SlowCase;
import cam.utils.personnages.Chasseur;
import cam.utils.personnages.Monstre;
import cam.utils.plateau.Plateau;

public class TestPlateau {

	public static void main(String[] args) {
		Case[][] cases = new Case[10][10];
		
		for(int i = 0; i < cases.length; i++) {
			for(int j = 0; j < cases.length; j++) {
				cases[i][j] = initCase();
			}
		}
		Monstre m = new Monstre(5, 5, "Kevin");
		Chasseur c = new Chasseur(1, 1, "Pierre");
		Plateau p = new Plateau(m, c, cases);
		
		p.printPlateau(true);
		System.out.println("=======");
		
		p.printPlateau(false);
		System.out.println("=======");
		
		p.printPlateauDebug();
		
		System.out.println("=======");
		System.out.println(p.appartientAuPlateau(11, 9));
		System.out.println(p.appartientAuPlateau(-1, 5));
		System.out.println(p.appartientAuPlateau(5, 8));
		
	}
	
	public static Case initCase() {
		if (Math.random() < 0.10) {
			return new SlowCase();
		} else {
			return new Case();
		}
	}
}
