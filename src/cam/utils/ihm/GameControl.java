package cam.utils.ihm;

import cam.main.games.PierreFeuilleCiseaux;
import cam.utils.cases.TrapCase;
import cam.utils.ihm.menu.MenuIHM;
import cam.utils.personnages.Chasseur;
import cam.utils.personnages.Monstre;
import cam.utils.personnages.Personnage;
import cam.utils.personnages.ia.EasyHunter;
import cam.utils.personnages.ia.EasyMonster;
import cam.utils.personnages.ia.RandomHunter;
import cam.utils.personnages.ia.RandomMonster;

public class GameControl {

	public static boolean gameFinish = false;
	
	public static boolean posePiege = false;
	public static int nbPiegePose = 0;
	
	public static boolean poseMonster = false;
	public static boolean monsterIsPosed = false;
	
	public static boolean monsterTour = false;
	public static boolean hunterTour = false;
	
	public static PlateauIHM plateau;
	
	public static Personnage joueur1;
	public static Personnage joueur2;
	public static boolean joueur1IsMonster;
	
	public static void execute() {
		if(gameFinish)
			return;
		
		if(posePiege) {
			onPosePiege();
		}
		else if(poseMonster) {
			placeMonster();
		}
		else if(monsterTour) {
			tourDuMonstre();
		}
		else if(hunterTour) {
			tourDuChasseur();
		}
	}

	public static void initByMenu() {
		if(MenuIHM.getModeDeJeu() == 1) { // game en solo
			
			if(MenuIHM.getPersonnage() == 1) { // c'est un monstre
				joueur1 = new Monstre(0, 0, MenuIHM.getNomMonstre());
				((Monstre) joueur1).setDeplacementHorizontal(MenuIHM.getDeplacementHorizontalMonstre());
				((Monstre) joueur1).setDeplacementVertical(MenuIHM.getDeplacementVerticalMonstre());
				((Monstre) joueur1).setDeplacementDiagonal(MenuIHM.getDeplacementDiagonaleMonstre());

				joueur1IsMonster = true;
				
				if(MenuIHM.getDifficulte() == 1) { // choix easy
					joueur2 = new RandomHunter(0, 0, "Chasseur");
				}
				else {
					joueur2 = new EasyHunter(0, 0, "Chasseur");
				}
				
				plateau = new PlateauIHM((Monstre) joueur1, (Chasseur) joueur2, MainController.cases);
			}
			else { // c'est un chasseur
				joueur1 = new Chasseur(0, 0, MenuIHM.getNomChasseur());
				joueur1IsMonster = false;

				if(MenuIHM.getDifficulte() == 1) { // choix easy
					joueur2 = new RandomMonster(0, 0, "Chasseur");
				}
				else {
					joueur2 = new EasyMonster(0, 0, "Chasseur");
				}
				((Monstre) joueur2).setDeplacementHorizontal(MenuIHM.getDeplacementHorizontalMonstre());
				((Monstre) joueur2).setDeplacementVertical(MenuIHM.getDeplacementVerticalMonstre());
				((Monstre) joueur2).setDeplacementDiagonal(MenuIHM.getDeplacementDiagonaleMonstre());
				
				plateau = new PlateauIHM((Monstre) joueur2, (Chasseur) joueur1, MainController.cases);
			}
			
		}
	}
	
	public static void onPosePiege() {
		if(MainController.lastCase == null)
			return;
		
		if(nbPiegePose < 3) {
			nbPiegePose++;
		}
		else
			return;
		
		CaseIHM c = MainController.lastCase;
		plateau.getPlateau()[c.getCase().getPosition().getX()][c.getCase().getPosition().getY()].setCase(new TrapCase());
		
		MainController.setTextIndicator("Piege " + nbPiegePose + " pose");
		MainController.lastCase = null;
	}
	
	public static void placeMonster() {
		if(MainController.lastCase == null)
			return;
		
		if(monsterIsPosed)
			return;
		
		CaseIHM c = MainController.lastCase;
		plateau.getMonstre().setX(c.getCase().getPosition().getX());
		plateau.getMonstre().setY(c.getCase().getPosition().getY());
		
		monsterIsPosed = true;
		poseMonster = false;
	}
	
	public static void tourDuMonstre() {
		if(MainController.lastCase == null)
			return;
		
		if(plateau.deplacerMonstre(plateau.chercheCase(MainController.lastCase.getCase().getPosition().getX(), MainController.lastCase.getCase().getPosition().getY()))) {
			monsterTour = false;
			MainController.removeMonster(plateau.getMonstrePositionLast().getX(), plateau.getMonstrePositionLast().getY());
			MainController.drawMonster(plateau.getMonstre().getPosition().getX(), plateau.getMonstre().getPosition().getY());
		}
		else
			return;
		
		for (int i = 0; i < plateau.getPlateau().length; i++) {
			for (int j = 0; j < plateau.getPlateau()[i].length; j++) {
				if (plateau.getPlateau()[i][j].getCase().isVisited()) {
					plateau.getPlateau()[i][j].getCase().setTourVisited(plateau.getPlateau()[i][j].getCase().getTourVisited() + 1);
				}
			}
		}
		
		if (plateau.sontToutesVisitee() || plateau.monstreBloquer()) {
			gameFinish = true;
		}
	}
	
	/**
	 * procede au tour du chasseur.
	 * 
	 * @param plateau  de jeu.
	 * @param monstre  du jeu.
	 * @param chasseur du jeu.
	 */
	public static void tourDuChasseur() {
		if(MainController.lastCase == null)
			return;
		
		int x, y;
		
		x = MainController.lastCase.getCase().getPosition().getX();
		y = MainController.lastCase.getCase().getPosition().getY();
		plateau.deplacerChasseur(MainController.lastCase.getCase());
		
		if (x == plateau.getMonstre().getPosition().getX() && y == plateau.getMonstre().getPosition().getY()) {
			PierreFeuilleCiseaux pfc = new PierreFeuilleCiseaux(plateau.getMonstre(), plateau.getChasseur());
			pfc.startGame();
			if (pfc.getWinner() instanceof Chasseur) {
				gameFinish = true;
			}
		} else {
			MainController.writeConsole("Case visitée il y a " + plateau.getPlateau()[x][y].getCase().getTourVisited() + " tour(s)");
		}
		
		if (plateau.deplacementsPossible().isEmpty()) {
			gameFinish = true;
		}
		
		hunterTour = false;
	}
}
