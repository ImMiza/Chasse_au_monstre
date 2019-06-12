package cam.main.games;

import cam.utils.cases.EffectCase;
import cam.utils.cases.TrapCase;
import cam.utils.ihm.CaseIHM;
import cam.utils.ihm.MainController;
import cam.utils.ihm.PlateauIHM;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 * Classe mere permettant de creer les deroulements des differents mode de jeu
 * @author allan
 */
public abstract class Game {
	
	protected int tour;
	
	public static Stage PierreFeuilleCiseaux;
	
	public static boolean PFC;
	public static boolean gameFinish;
	
	protected TrapCase piege1;
	protected TrapCase piege2;
	protected TrapCase piege3;
	
	protected PlateauIHM plateau;
	
	protected String consoleHunterPlayer;
	protected String consoleMonsterPlayer;
	
	protected String indicatorHunterPlayer;
	protected String indicatorMonsterPlayer;
	
	public Game() {
		tour = 1;
	}
	
	/**
	 * Appeler par les events de MainController, permet d'executer le deroulement du jeu
	 */
	public abstract void execute();
	
	/**
	 * Permet de placer les pieges du chasseur
	 */
	public abstract void placePiege();
	
	/**
	 * Permet de placer le monstre
	 */
	public abstract void placeMonster();
	
	/**
	 * Permet d'executer les actions du chasseur
	 */
	public abstract void tourHunter();
	
	/**
	 * Permet d'executer les actions du monstre
	 */
	public abstract void tourMonster();
	
	/**
	 * Permet de mettre a jours les tours visités des cases
	 */
	protected void updateTourVisited() {
		for (int i = 0; i < plateau.getPlateau().length; i++) {
			for (int j = 0; j < plateau.getPlateau()[0].length; j++) {
				if(plateau.getPlateau()[i][j].getCase().isVisited()) {
					plateau.getPlateau()[i][j].getCase().setTourVisited(plateau.getPlateau()[i][j].getCase().getTourVisited() + 1);
				}
			}
		}
	}
	
	/**
	 * Permet de creer une temporisatin avec une fenetre modal 
	 * @param message le message a afficher sur la fenetre
	 */
	public void temporisation(String message) {
		MainController.canClick = false;
		
		Alert alert = new Alert(AlertType.INFORMATION, message, ButtonType.YES);
		alert.showAndWait();
		
		MainController.canClick = true;
	}
	
	/**
	 * Permet de remettre a zero le plateau et de vider la console de droite et l'indicateur
	 * @param isForMonster true si on clean pour le monstre et sauvegarder dans ses affaires, false l'inverse
	 */
	public void clearAll(boolean isForMonster) {
		clearMap();
		
		if(isForMonster) {
			this.consoleMonsterPlayer = MainController.console.getText();
			this.indicatorMonsterPlayer = MainController.indicateur.getText();
		}
		else {
			this.consoleHunterPlayer = MainController.console.getText();
			this.indicatorHunterPlayer = MainController.indicateur.getText();
		}
		
		MainController.clearConsole();
		MainController.setTextIndicator("");
	}
	
	/**
	 * permet de remettre a zero le plateau
	 */
	public void clearMap() {
		GraphicsContext context = MainController.plateau.getGraphicsContext2D();
		Image image = new Image("/cam/ressources/herbe.jpg");
		
		for (int i = 0; i < plateau.getPlateau().length; i++) {
			for (int j = 0; j < plateau.getPlateau()[0].length; j++) {
				Rectangle c = plateau.getPlateau()[i][j].getRectangle();
				context.clearRect(c.getX(), c.getY(), c.getWidth(), c.getHeight());
				context.drawImage(image, c.getX(), c.getY(), c.getWidth(), c.getHeight());
			}
		}
	}
	
	/**
	 * Permet d'afficher le plateau du monstre avec sa console et son indicateur
	 * @param withPossibilityCase true si on veut afficher les deplacement possibles du monstre, sinon false
	 */
	public void printAllMonster(boolean withPossibilityCase) {
		printMonsterMap(withPossibilityCase);
		
		MainController.console.setText(this.consoleMonsterPlayer);
		MainController.setTextIndicator(this.indicatorMonsterPlayer);
	}
	
	/**
	 * Permet d'afficher le plateau du monstre
	 * @param withPossibilityCase true si on veut afficher les deplacement possibles du monstre, sinon false
	 */
	public void printMonsterMap(boolean withPossibilityCase) {
		GraphicsContext context = MainController.plateau.getGraphicsContext2D();
		
		for (int i = 0; i < plateau.getPlateau().length; i++) {
			for (int j = 0; j < plateau.getPlateau()[0].length; j++) {
				CaseIHM c = plateau.getPlateau()[i][j];
				
				if(c.getCase().isVisited()) {
					context.clearRect(c.getRectangle().getX(), c.getRectangle().getY(), c.getRectangle().getWidth(), c.getRectangle().getHeight());
				}
				
			}
		}
		
		if(withPossibilityCase) {
			for(CaseIHM c : plateau.deplacementsPossible()) {
				context.clearRect(c.getRectangle().getX(), c.getRectangle().getY(), c.getRectangle().getWidth(), c.getRectangle().getHeight());
				Image image = new Image("/cam/ressources/herbe_possible.jpg");
				context.drawImage(image, c.getRectangle().getX(), c.getRectangle().getY(), c.getRectangle().getWidth(), c.getRectangle().getHeight());
			}
		}
		
		MainController.drawMonster(plateau.getMonstre().getPosition().getX(), plateau.getMonstre().getPosition().getY());
	}
	
	/**
	 * Permet d'afficher le plateau du chasseur avec sa console et son indicateur
	 */
	public void printAllHunter() {
		printHunterMap();
		
		MainController.console.setText(this.consoleHunterPlayer);
		MainController.setTextIndicator(this.indicatorHunterPlayer);
	}
	
	/**
	 * Permet d'afficher le plateau du chasseur
	 */
	public void printHunterMap() {
		GraphicsContext context = MainController.plateau.getGraphicsContext2D();
		Image effect = new Image("/cam/ressources/herbe_possible.jpg");
		
		for (int i = 0; i < plateau.getPlateau().length; i++) {
			for (int j = 0; j < plateau.getPlateau()[0].length; j++) {
				CaseIHM c = plateau.getPlateau()[i][j];
				
				if(c.getCase() instanceof EffectCase) {
					context.clearRect(c.getRectangle().getX(), c.getRectangle().getY(), c.getRectangle().getWidth(), c.getRectangle().getHeight());
					context.drawImage(effect, c.getRectangle().getX(), c.getRectangle().getY(), c.getRectangle().getWidth(), c.getRectangle().getHeight());
				}
				
			}
		}
		
		MainController.drawHunter(plateau.getChasseur().getPosition().getX(), plateau.getChasseur().getPosition().getY());
	}
	
	/**
	 * @return le plateau de jeu
	 */
	public PlateauIHM getPlateau()
	{
		return plateau;
	}
	
	/**
	 * @return le tour actuel du jeu
	 */
	public int getTour()
	{
		return tour;
	}
}