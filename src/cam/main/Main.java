package cam.main;

import java.util.Scanner;

import cam.utils.cases.Case;
import cam.utils.cases.SlowCase;
import cam.utils.cases.TrapCase;
import cam.utils.personnages.Chasseur;
import cam.utils.personnages.Monstre;
import cam.utils.personnages.Position;
import cam.utils.plateau.Plateau;

/**
 * Class principale qui fait fonctionner le jeu.
 * @author Aymeric Defossez
 *
 */
public class Main {
	
	private static Scanner in = new Scanner(System.in);
	private static boolean finDuJeu = false;

	/**
	 * methode principale.
	 * @param args
	 */
	public static void main(String[] args) {
		//Menu menu = new Menu();
		Menu.menu();
		int i = Menu.getChoixMenu();
		if(i == 2) {
			clearScreen();
			startMulti();
		}
		
		
	}
	
	public static void startMulti() {
		Monstre monstre = new Monstre(0, 0, "");
		Chasseur chasseur = new Chasseur(0, 0, "");
		Plateau plateau = new Plateau(monstre, chasseur, initPlateau(10, 10));
		
		Position piege1;
		Position piege2;
		Position piege3;

		System.out.println("MONSTRE : " + Menu.getNomMonstre());
		monstre.setNom(Menu.getNomMonstre());
		
		placeMonstre(monstre, plateau);
		
		clearScreen();
		
		System.out.println("CHASSEUR : " + Menu.getNomChasseur());
		chasseur.setNom(Menu.getNomChasseur());
		
		System.out.println("1er piege :");
		piege1 = posePiege();
		
		System.out.println("2eme piege :");
		piege2 = posePiege();

		System.out.println("3eme piege :");
		piege3 = posePiege();

		clearScreen();
		
		plateau.getPlateau()[piege1.getX()][piege1.getY()] = new TrapCase();
		plateau.getPlateau()[piege2.getX()][piege2.getY()] = new TrapCase();
		plateau.getPlateau()[piege3.getX()][piege3.getY()] = new TrapCase();
		
		while (!finDuJeu) {
			tourDuMonstre(plateau);
			clearScreen();
			tourDuChasseur(plateau, monstre, chasseur);
			clearScreen();
		}
	}
	
	/**
	 * procede au tour du monstre.
	 * @param plateau de jeu.
	 */
	public static void tourDuMonstre(Plateau plateau) {
		int nvX, nvY;
		boolean finTour = false;
		
		System.out.println("Tour du monstre");
		in.nextLine();
		while (!finTour) {
			plateau.printPlateau(true);
			System.out.println("Coordonnees de la nouvelle case :");
			System.out.println("Ligne :");
			nvX = getSecureInt(0, 9);
			System.out.println("Colonne :");
			nvY = getSecureInt(0, 9);
			finTour = plateau.deplacerMonstre(plateau.chercheCase(nvX, nvY));
		}
		for (int i = 0; i < plateau.getPlateau().length; i++) {
			for (int j = 0; j < plateau.getPlateau()[i].length; j++) {
				if (plateau.getPlateau()[i][j].isVisited()) {
					plateau.getPlateau()[i][j].setTourVisited(plateau.getPlateau()[i][j].getTourVisited() + 1);
				}
			}
		}
		if (plateau.sontToutesVisitée() || plateau.monstreBloquer()) {
			finDuJeu = true;
		}
	}
	
	
	/**
	 * procede au tour du chasseur.
	 * @param plateau de jeu.
	 * @param monstre du jeu.
	 * @param chasseur du jeu.
	 */
	public static void tourDuChasseur(Plateau plateau, Monstre monstre, Chasseur chasseur) {
		int x, y;
		boolean finTour = false;
		
		System.out.println("Tour du chasseur");
		in.nextLine();
		while (!finTour) {
			do {
				plateau.printPlateau(false);
				System.out.println("Coordonnees de la case à chercher :");
				System.out.println("Ligne :");
				x = getSecureInt(0, 9);
				System.out.println("Colonne :");
				y = getSecureInt(0, 9);
			} while(!plateau.appartientAuPlateau(x, y));
			chasseur.getPosition().setX(x);
			chasseur.getPosition().setY(y);
			if (x == monstre.getPosition().getX() && y == monstre.getPosition().getY()) {
				PierreFeuilleCiseaux pfc = new PierreFeuilleCiseaux(monstre, chasseur);
				pfc.startGame();
				in.nextLine();
				if (pfc.getWinner() instanceof Chasseur) {
					finDuJeu = true;
				}
			} else {
				System.out.println("Case visitée il y a " + plateau.getPlateau()[x][y].getTourVisited() + " tour(s)");
			}
			in.nextLine();
			finTour = true;
		}
		if (plateau.deplacementsPossible().isEmpty()) {
			finDuJeu = true;
		}
	}
	
}
