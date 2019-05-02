package cam.utils.main;

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
		Plateau plateau = new Plateau(monstre, chasseur, initPlateau(10, 10));;
		
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
		if (plateau.sontToutesVisitée()) {
			finDuJeu = true;
		}
	}
	
	/**
	 * Permet de poser un piege pour le chasseur
	 * @return la position du piege
	 */
	public static Position posePiege() {
		int X;
		do {
			System.out.print("Ligne (entre 1 et 8) : ");
			X = getSecureInt(1, 8);
		}while(X < 1 || X > 8);
		
		int Y;
		do {
			System.out.print("Colonne (entre 1 et 8) : ");
			Y = getSecureInt(1, 8);
		}while(Y < 1 || Y > 8);
		
		return new Position(X, Y);
	}
	
	/**
	 * Permet de placer le monstre sur les extremites du plateau
	 * @param monstre le monstre a placer
	 * @param plateau le plateau sur lequel le placer
	 */
	public static void placeMonstre(Monstre monstre, Plateau plateau) {
		
		int X;
		do {
			System.out.print("Ligne du monstre (0 ou 9) : ");
			X = getSecureInt(0, 9);
		}while(X != 0 && X != 9);
		
		int Y;
		do {
			System.out.print("Colonne du monstre (0 ou 9) : ");
			Y = getSecureInt(0, 9);
		}while(Y != 0 && Y != 9);
		
		monstre.setX(X);
		monstre.setY(Y);
	}
	
	/**
	 * Permet de recuperer un entier de facon securise et de 
	 * façon delimitee
	 * @param min la borne minimum
	 * @param max la borne maximum
	 * @return un entier
	 */
	public static int getSecureInt(int min, int max) {
		String entry;
		int n = min - 1;
		
		do {
			entry = in.nextLine();
			if(isNumber(entry))
				n = Integer.parseInt(entry);
			
		}while(n < min || n > max);
		
		return n;
	}
	
	/**
	 * Permet de verifier si une phrase est aussi un chiffre
	 * @param number la phrase a tester
	 * @return true si c'est que des chiffres, sinon false
	 */
	public static boolean isNumber(String number) {
		if(number.equals(""))
			return false;
		
        for(int i = 0; i < number.length(); i++) {
            if(number.charAt(i) < '0' || number.charAt(i) > '9') {
                return false;
            }
        }
        return true;
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
		for(int i=0 ; i<50 ; i++) {
			System.out.println();
		}
	}
}
