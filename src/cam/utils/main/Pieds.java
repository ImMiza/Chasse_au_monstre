package cam.utils.main;

import java.util.Scanner;

import cam.utils.cases.Case;
import cam.utils.cases.TrapCase;
import cam.utils.personnages.Chasseur;
import cam.utils.personnages.Monstre;
import cam.utils.plateau.Plateau;

public class Pieds {

	public static void main(String[] args) {
		Monstre monstre;
		Chasseur chasseur;
		Plateau plateau;
		Scanner in = new Scanner(System.in);
		int xMonstre, yMonstre;
		String pseudo;
		
		System.out.println("Votre pseudo :");
		pseudo = in.nextLine();
		System.out.println("Ligne du monstre (0 ou 9) :");
		xMonstre = Integer.parseInt(in.nextLine());
		System.out.println("Colonne du monstre (0 ou 9) :");
		yMonstre = Integer.parseInt(in.nextLine());
		monstre = new Monstre(xMonstre, yMonstre, pseudo);
		chasseur = new Chasseur(0, 0, "Robert");
		plateau = new Plateau(monstre, chasseur, initPlateau(10, 10));
		
		plateau.printPlateauDebug();
		in.close();
	}
	
	public static Case[][] initPlateau(int lig, int col) {
		Case[][] plateau = new Case[lig][col];
		double proba = Math.random();
		
		for (int i = 0; i < plateau.length; i++) {
			for (int j = 0; j < plateau[i].length; j++) {
				if (proba < 0.1) {
					plateau[i][j] = new TrapCase();
				} else {
					plateau[i][j] = new Case();
				}
				proba = Math.random();
			}
		}
		return plateau;
	}
}
