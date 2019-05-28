package cam.main;

import java.util.Scanner;

import cam.utils.cases.Case;
import cam.utils.cases.SlowCase;
import cam.utils.ihm.CaseIHM;
import cam.utils.personnages.Chasseur;
import cam.utils.personnages.Monstre;
import cam.utils.personnages.Personnage;
import cam.utils.personnages.Position;
import cam.utils.personnages.ia.EasyHunter;
import cam.utils.personnages.ia.EasyMonster;
import cam.utils.personnages.ia.RandomHunter;
import cam.utils.personnages.ia.RandomMonster;
import cam.utils.plateau.Plateau;

public abstract class Game {

	private Scanner in = new Scanner(System.in);
	private boolean gameFinish;

	private CaseIHM[][] cases;
	private Personnage joueur1;
	private boolean joueur1IsMonster;
	
	private Personnage joueur2;

	private Plateau plateau;

	public Game(int width, int height) {
		this.cases = new CaseIHM[width][height];
		this.gameFinish = false;
		initByMenu();
	}

	public Game() {
		this(10, 10);
	}

	public abstract void start();

	public void initByMenu() {
		int choix = Menu.getChoixMenu();
		
		if(Integer.toString(choix).charAt(0) == '1') { // game en solo
			
			if(Integer.toString(choix).charAt(1) == '1') { // c'est un monstre
				this.joueur1 = new Monstre(0, 0, Menu.getNomMonstre());
				this.joueur1IsMonster = true;
				
				if(Integer.toString(choix).charAt(2) == '1') { // choix easy
					this.joueur2 = new RandomHunter(0, 0, "Chasseur");
				}
				else {
					this.joueur2 = new EasyHunter(0, 0, "Chasseur");
				}
				
				this.plateau = new Plateau((Monstre) this.joueur1, (Chasseur) this.joueur2, initPlateau(this.cases.length, this.cases[0].length));
			}
			else { // c'est un chasseur
				this.joueur1 = new Chasseur(0, 0, Menu.getNomChasseur());
				this.joueur1IsMonster = false;
				
				if(Integer.toString(choix).charAt(2) == '1') { // choix easy
					this.joueur2 = new RandomMonster(0, 0, "Chasseur");
				}
				else {
					this.joueur2 = new EasyMonster(0, 0, "Chasseur");
				}
				
				this.plateau = new Plateau((Monstre) this.joueur2, (Chasseur) this.joueur1, initPlateau(this.cases.length, this.cases[0].length));
			}
			
		}
		
		
	}

	/**
	 * Permet de poser un piege pour le chasseur
	 * 
	 * @return la position du piege
	 */
	public Position posePiege() {
		int X;
		do {
			System.out.print("Ligne (entre 1 et 8) : ");
			X = getSecureInt(1, 8);
		} while (X < 1 || X > 8);

		int Y;
		do {
			System.out.print("Colonne (entre 1 et 8) : ");
			Y = getSecureInt(1, 8);
		} while (Y < 1 || Y > 8);

		return new Position(X, Y);
	}

	/**
	 * Permet de recuperer un entier de facon securise et de façon delimitee
	 * 
	 * @param min la borne minimum
	 * @param max la borne maximum
	 * @return un entier
	 */
	public int getSecureInt(int min, int max) {
		String entry;
		int n = min - 1;

		do {
			entry = in.nextLine();
			if (isNumber(entry))
				n = Integer.parseInt(entry);

		} while (n < min || n > max);

		return n;
	}

	/**
	 * Permet de verifier si une phrase est aussi un chiffre
	 * 
	 * @param number la phrase a tester
	 * @return true si c'est que des chiffres, sinon false
	 */
	public boolean isNumber(String number) {
		if (number.equals(""))
			return false;

		for (int i = 0; i < number.length(); i++) {
			if (number.charAt(i) < '0' || number.charAt(i) > '9') {
				return false;
			}
		}
		return true;
	}

	/**
	 * initialisation du plateau de jeu.
	 * 
	 * @param lig nombre de lignes.
	 * @param col nombre de colonnes.
	 * @return le tableau de case qui sert de plateau.
	 */
	public Case[][] initPlateau(int lig, int col) {
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
	public void clearScreen() {
		for (int i = 0; i < 50; i++) {
			System.out.println();
		}
	}

	/**
	 * Permet de placer le monstre sur les extremites du plateau
	 * 
	 * @param monstre le monstre a placer
	 * @param plateau le plateau sur lequel le placer
	 */
	public void placeMonstre(Monstre monstre, Plateau plateau) {
		int X;
		int Y;

		do {
			System.out.print("Ligne du monstre (0 ou 9) : ");
			X = getSecureInt(0, 9);
			System.out.print("Colonne du monstre (0 ou 9) : ");
			Y = getSecureInt(0, 9);
		} while (Y != 0 && Y != 9 && X != 0 && X != 9);

		monstre.setX(X);
		monstre.setY(Y);
	}

	/**
	 * procede au tour du monstre.
	 * 
	 * @param plateau de jeu.
	 */
	public void tourDuMonstre(Plateau plateau) {
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
		
		if (plateau.sontToutesVisitee() || plateau.monstreBloquer()) {
			this.gameFinish = true;
		}
	}

	/**
	 * procede au tour du chasseur.
	 * 
	 * @param plateau  de jeu.
	 * @param monstre  du jeu.
	 * @param chasseur du jeu.
	 */
	public void tourDuChasseur(Plateau plateau, Monstre monstre, Chasseur chasseur) {
		int x, y;
		boolean finTour = false;

		in.nextLine();
		while (!finTour) {

			do {
				plateau.printPlateau(false);
				System.out.println("Coordonnees de la case à chercher :");
				System.out.println("Ligne :");
				x = getSecureInt(0, 9);
				System.out.println("Colonne :");
				y = getSecureInt(0, 9);
			} while (!plateau.appartientAuPlateau(x, y));

			chasseur.getPosition().setX(x);
			chasseur.getPosition().setY(y);

			if (x == monstre.getPosition().getX() && y == monstre.getPosition().getY()) {
				PierreFeuilleCiseaux pfc = new PierreFeuilleCiseaux(monstre, chasseur);
				pfc.startGame();
				in.nextLine();
				if (pfc.getWinner() instanceof Chasseur) {
					this.gameFinish = true;
				}
			} else {
				System.out.println("Case visitée il y a " + plateau.getPlateau()[x][y].getTourVisited() + " tour(s)");
			}
			in.nextLine();
			finTour = true;
		}
		
		if (plateau.deplacementsPossible().isEmpty()) {
			this.gameFinish = true;
		}
	}

	public boolean isGameFinish() {
		return gameFinish;
	}

	public void setGameFinish(boolean gameFinish) {
		this.gameFinish = gameFinish;
	}

	public CaseIHM[][] getCases() {
		return cases;
	}

	public void setCases(CaseIHM[][] cases) {
		this.cases = cases;
	}

	public Plateau getPlateau() {
		return plateau;
	}

	public void setPlateau(Plateau plateau) {
		this.plateau = plateau;
	}

	public Scanner getIn() {
		return in;
	}

	public Personnage getJoueur1() {
		return joueur1;
	}

	public boolean isJoueur1IsMonster() {
		return joueur1IsMonster;
	}

	public Personnage getJoueur2() {
		return joueur2;
	}
}
