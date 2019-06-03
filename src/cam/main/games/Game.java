package cam.main.games;

import java.util.Scanner;

import cam.utils.ihm.MainController;
import cam.utils.ihm.PlateauIHM;
import cam.utils.ihm.menu.MenuIHM;
import cam.utils.personnages.Chasseur;
import cam.utils.personnages.Monstre;
import cam.utils.personnages.Personnage;
import cam.utils.personnages.Position;
import cam.utils.personnages.ia.EasyHunter;
import cam.utils.personnages.ia.EasyMonster;
import cam.utils.personnages.ia.RandomHunter;
import cam.utils.personnages.ia.RandomMonster;

public abstract class Game {

	private Scanner in = new Scanner(System.in);
	private boolean gameFinish;

	private Personnage joueur1;
	private boolean joueur1IsMonster;
	
	private Personnage joueur2;

	private PlateauIHM plateau;

	public Game() {
		this.gameFinish = false;
		initByMenu();
	}

	public abstract void start();

	protected void initByMenu() {
		
		if(MenuIHM.getModeDeJeu() == 1) { // game en solo
			
			if(MenuIHM.getPersonnage() == 1) { // c'est un monstre
				this.joueur1 = new Monstre(0, 0, MenuIHM.getNomMonstre());
				((Monstre) this.joueur1).setDeplacementHorizontal(MenuIHM.getDeplacementHorizontalMonstre());
				((Monstre) this.joueur1).setDeplacementVertical(MenuIHM.getDeplacementVerticalMonstre());
				((Monstre) this.joueur1).setDeplacementDiagonal(MenuIHM.getDeplacementDiagonaleMonstre());

				this.joueur1IsMonster = true;
				
				if(MenuIHM.getDifficulte() == 1) { // choix easy
					this.joueur2 = new RandomHunter(0, 0, "Chasseur");
				}
				else {
					this.joueur2 = new EasyHunter(0, 0, "Chasseur");
				}
				
				this.plateau = new PlateauIHM((Monstre) this.joueur1, (Chasseur) this.joueur2, MainController.cases);
			}
			else { // c'est un chasseur
				this.joueur1 = new Chasseur(0, 0, MenuIHM.getNomChasseur());
				this.joueur1IsMonster = false;

				if(MenuIHM.getDifficulte() == 1) { // choix easy
					this.joueur2 = new RandomMonster(0, 0, "Chasseur");
				}
				else {
					this.joueur2 = new EasyMonster(0, 0, "Chasseur");
				}
				((Monstre) this.joueur2).setDeplacementHorizontal(MenuIHM.getDeplacementHorizontalMonstre());
				((Monstre) this.joueur2).setDeplacementVertical(MenuIHM.getDeplacementVerticalMonstre());
				((Monstre) this.joueur2).setDeplacementDiagonal(MenuIHM.getDeplacementDiagonaleMonstre());
				
				this.plateau = new PlateauIHM((Monstre) this.joueur2, (Chasseur) this.joueur1, MainController.cases);
			}
			
		}
		
		
	}

	/**
	 * Permet de poser un piege pour le chasseur
	 * 
	 * @return la position du piege
	 */
	public Position posePiege() {
		MainController.canClick = true;
		MainController.lastCase = null;
		
		while(MainController.lastCase == null) {
			try
			{
				Thread.sleep(500);
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
		
		MainController.canClick = false;
		
		return new Position(MainController.lastCase.getCase().getPosition().getX(), MainController.lastCase.getCase().getPosition().getY());
	}

	/**
	 * Permet de placer le monstre sur les extremites du plateau
	 * 
	 * @param monstre le monstre a placer
	 * @param plateau le plateau sur lequel le placer
	 */
	public void placeMonstre(Monstre monstre) {
		MainController.canClick = true;
		MainController.lastCase = null;
		System.out.println("JUSTE COMME CA ");
		while(MainController.lastCase == null) {
			try
			{
				Thread.sleep(100);
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
		System.out.println("JUSTE COMME CA");
		MainController.canClick = false;
		

		monstre.setX(MainController.lastCase.getCase().getPosition().getX());
		monstre.setY(MainController.lastCase.getCase().getPosition().getY());
	}

	/**
	 * procede au tour du monstre.
	 * 
	 * @param plateau de jeu.
	 */
	public void tourDuMonstre(PlateauIHM plateau) {
		boolean finTour = false;

		MainController.canClick = true;
		
		
		while (!finTour) {
			MainController.lastCase = null;
			MainController.writeConsole("Clique sur une case valide");
			
			while(MainController.lastCase == null){
				try
				{
					Thread.sleep(100);
				}
				catch (InterruptedException e)
				{
					e.printStackTrace();
				}
			}

			finTour = plateau.deplacerMonstre(plateau.chercheCase(MainController.lastCase.getCase().getPosition().getX(), MainController.lastCase.getCase().getPosition().getY()));
		}
		
		MainController.canClick = false;
		
		for (int i = 0; i < plateau.getPlateau().length; i++) {
			for (int j = 0; j < plateau.getPlateau()[i].length; j++) {
				if (plateau.getPlateau()[i][j].getCase().isVisited()) {
					plateau.getPlateau()[i][j].getCase().setTourVisited(plateau.getPlateau()[i][j].getCase().getTourVisited() + 1);
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
	public void tourDuChasseur(PlateauIHM plateau, Monstre monstre, Chasseur chasseur) {
		int x, y;
		
		MainController.canClick = true;
		
		MainController.lastCase = null;
		MainController.writeConsole("Clique sur une case valide");
			
		while(MainController.lastCase == null){
			try
			{
				Thread.sleep(100);
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
		
		x = MainController.lastCase.getCase().getPosition().getX();
		y = MainController.lastCase.getCase().getPosition().getY();
		plateau.deplacerChasseur(MainController.lastCase.getCase());
		
		MainController.canClick = false;
		
		if (x == monstre.getPosition().getX() && y == monstre.getPosition().getY()) {
			PierreFeuilleCiseaux pfc = new PierreFeuilleCiseaux(monstre, chasseur);
			pfc.startGame();
			in.nextLine();
			if (pfc.getWinner() instanceof Chasseur) {
				this.gameFinish = true;
			}
		} else {
			MainController.writeConsole("Case visitée il y a " + plateau.getPlateau()[x][y].getCase().getTourVisited() + " tour(s)");
		}
		
		if (plateau.deplacementsPossible().isEmpty()) {
			this.gameFinish = true;
		}
	}

	public void printMonster() {
		MainController.removeMonster(this.plateau.getMonstrePositionLast().getX(), this.plateau.getMonstrePositionLast().getY());
		MainController.drawMonster(this.plateau.getMonstre().getPosition().getX(), this.plateau.getMonstre().getPosition().getY());
	}
	
	public void printHunter() {
		MainController.removeHunter(this.plateau.getChasseurPositionLast().getX(), this.plateau.getChasseurPositionLast().getY());
		MainController.drawHunter(this.plateau.getChasseur().getPosition().getX(), this.plateau.getChasseur().getPosition().getY());
	}
	
	public boolean isGameFinish() {
		return gameFinish;
	}

	public void setGameFinish(boolean gameFinish) {
		this.gameFinish = gameFinish;
	}

	public PlateauIHM getPlateau() {
		return plateau;
	}

	public void setPlateau(PlateauIHM plateau) {
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
