package cam.utils.main;

import java.util.Scanner;

import cam.utils.cases.Case;
import cam.utils.cases.SlowCase;
import cam.utils.cases.TrapCase;
import cam.utils.personnages.Chasseur;
import cam.utils.personnages.Monstre;
import cam.utils.plateau.Plateau;

/**
 * Class principale qui fait fonctionner le jeu.
 * @author Aymeric Defossez
 *
 */
public class Pieds {
	
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
		Monstre monstre;
		Chasseur chasseur;
		Plateau plateau;
		int xPiege1, yPiege1;
		int xPiege2, yPiege2;
		int xPiege3, yPiege3;
		int xMonstre, yMonstre;
		String pseudoMonstre, pseudoChasseur;
		String xPiege1String, yPiege1String;
		String xPiege2String, yPiege2String;
		String xPiege3String, yPiege3String;
		String xMonstreString, yMonstreString;
		
		System.out.println("MONSTRE : " + Menu.getNomMonstre());
		pseudoMonstre = Menu.getNomMonstre();
		System.out.println("Ligne du monstre (0 ou 9) :");
		xMonstreString = in.nextLine();
		while (xMonstreString.charAt(0) != '0' && xMonstreString.charAt(0) != '9' || xMonstreString.length() != 1) {
			System.out.println("Ligne du monstre (0 ou 9) :");
			xMonstreString = in.nextLine();
		}
		xMonstre = Integer.parseInt(xMonstreString);
		System.out.println("Colonne du monstre (0 ou 9) :");
		yMonstreString = in.nextLine();
		while (yMonstreString.charAt(0) != '0' && yMonstreString.charAt(0) != '9' || yMonstreString.length() != 1) {
			System.out.println("Colonne du monstre (0 ou 9) :");
			yMonstreString = in.nextLine();
		}
		yMonstre = Integer.parseInt(yMonstreString);
		clearScreen();
		System.out.println("CHASSEUR : " + Menu.getNomChasseur());
		pseudoChasseur = Menu.getNomChasseur();
		System.out.println("1er piege :");
		System.out.println("Ligne (entre 1 et 8) :");
		xPiege1String = in.nextLine();
		while (xPiege1String.charAt(0) < '1' || xPiege1String.charAt(0) > '8' || xPiege1String.length() != 1) {
			System.out.println("Ligne (entre 1 et 8) :");
			xPiege1String = in.nextLine();
		}
		xPiege1 = Integer.parseInt(xPiege1String);
		System.out.println("Colonne (entre 1 et 8) :");
		yPiege1String = in.nextLine();
		while (yPiege1String.charAt(0) < '1' || yPiege1String.charAt(0) > '8' || yPiege1String.length() != 1) {
			System.out.println("Colonne (entre 1 et 8) :");
			yPiege1String = in.nextLine();
		}
		yPiege1 = Integer.parseInt(yPiege1String);
		System.out.println("2eme piege :");
		System.out.println("Ligne (entre 1 et 8) :");
		xPiege2String = in.nextLine();
		while (xPiege2String.charAt(0) < '1' || xPiege2String.charAt(0) > '8' || xPiege2String.length() != 1) {
			System.out.println("Ligne (entre 1 et 8) :");
			xPiege2String = in.nextLine();
		}
		xPiege2 = Integer.parseInt(xPiege2String);
		System.out.println("Colonne (entre 1 et 8) :");
		yPiege2String = in.nextLine();
		while (yPiege2String.charAt(0) < '1' || yPiege2String.charAt(0) > '8' || yPiege2String.length() != 1) {
			System.out.println("Colonne (entre 1 et 8) :");
			yPiege2String = in.nextLine();
		}
		yPiege2 = Integer.parseInt(yPiege2String);
		System.out.println("3eme piege :");
		System.out.println("Ligne (entre 1 et 8) :");
		xPiege3String = in.nextLine();
		while (xPiege3String.charAt(0) < '1' || xPiege3String.charAt(0) > '8' || xPiege3String.length() != 1) {
			System.out.println("Ligne (entre 1 et 8) :");
			xPiege3String = in.nextLine();
		}
		xPiege3 = Integer.parseInt(xPiege3String);
		System.out.println("Colonne (entre 1 et 8) :");
		yPiege3String = in.nextLine();
		while (yPiege3String.charAt(0) < '1' || yPiege3String.charAt(0) > '8' || yPiege3String.length() != 1) {
			System.out.println("Ligne (entre 1 et 8) :");
			yPiege3String = in.nextLine();
		}
		yPiege3 = Integer.parseInt(yPiege3String);
		clearScreen();
		
		monstre = new Monstre(xMonstre, yMonstre, pseudoMonstre);
		chasseur = new Chasseur(0, 0, pseudoChasseur);
		plateau = new Plateau(monstre, chasseur, initPlateau(10, 10));
		plateau.getPlateau()[xPiege1][yPiege1] = new TrapCase();
		plateau.getPlateau()[xPiege2][yPiege2] = new TrapCase();
		plateau.getPlateau()[xPiege3][yPiege3] = new TrapCase();
		
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
			nvX = Integer.parseInt(in.nextLine());
			System.out.println("Colonne :");
			nvY = Integer.parseInt(in.nextLine());
			finTour = plateau.deplacerMonstre(plateau.chercheCase(nvX, nvY));
		}
		for (int i = 0; i < plateau.getPlateau().length; i++) {
			for (int j = 0; j < plateau.getPlateau()[i].length; j++) {
				if (plateau.getPlateau()[i][j].isVisited()) {
					plateau.getPlateau()[i][j].setTourVisited(plateau.getPlateau()[i][j].getTourVisited() + 1);
				}
			}
		}
		if (plateau.sontToutesVisitée()) {
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
				x = Integer.parseInt(in.nextLine());
				System.out.println("Colonne :");
				y = Integer.parseInt(in.nextLine());
			} while(!plateau.appartientAuPlateau(x, y));
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
	
	/**
	 * initialisation du plateau de jeu.
	 * @param lig nombre de lignes.
	 * @param col nombre de colonnes.
	 * @return le tableau de case qui sert de plateau.
	 */
	public static Case[][] initPlateau(int lig, int col) {
		Case[][] plateau = new Case[lig][col];
		double proba = Math.random();
		
		for (int i = 0; i < plateau.length; i++) {
			for (int j = 0; j < plateau[i].length; j++) {
				if (proba < 0.10) {
					plateau[i][j] = new SlowCase();
				} else {
					plateau[i][j] = new Case();
				}
				proba = Math.random();
			}
		}
		return plateau;
	}
	
	/**
	 * effacer tout ce que contient le terminal.
	 */
	private static void clearScreen() {
		for(int i=0 ; i<100 ; i++) {
			System.out.println("\n");
		}
	}
}
