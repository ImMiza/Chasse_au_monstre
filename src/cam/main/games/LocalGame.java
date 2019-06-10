package cam.main.games;

import java.io.IOException;

import cam.utils.cases.EffectCase;
import cam.utils.cases.TrapCase;
import cam.utils.ihm.CaseIHM;
import cam.utils.ihm.MainController;
import cam.utils.ihm.PlateauIHM;
import cam.utils.ihm.menu.events.PierreFeuilleCiseauxEvent;
import cam.utils.personnages.Chasseur;
import cam.utils.personnages.Monstre;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class LocalGame extends Game {

	private Chasseur HunterPlayer;
	private Monstre MonsterPlayer;

	private String consoleHunterPlayer;
	private String consoleMonsterPlayer;
	
	private String indicatorHunterPlayer;
	private String indicatorMonsterPlayer;
	
	private boolean monsterPlace;
	private int nbPiege;
	private boolean tourMonster;
	

	public LocalGame(String monsterName, String hunterName, CaseIHM[][] cases)
	{
		nbPiege = 3;
		
		gameFinish = false;
		PFC = false;
		tourMonster = false;
		
		this.HunterPlayer = new Chasseur(0, 0, hunterName);
		this.MonsterPlayer = new Monstre(0, 0, monsterName);
		
		this.plateau = new PlateauIHM(this.MonsterPlayer, this.HunterPlayer, cases);
		
		temporisation("Tour du Chasseur !");
		
		MainController.writeConsole("Chasseur: " + this.HunterPlayer.getNom());
		MainController.writeConsole("Le chasseur doit pose 3 pieges");
		MainController.setTextIndicator("Poser "+ nbPiege + " pieges dans la carte");
		printHunterMap();
	}
	
	@Override
	public void execute() {
		
		if(!gameFinish && !PFC) {
			
			if(nbPiege > 0) {
				placePiege();
			}
			else if(!monsterPlace) {
				placeMonster();
			}
			else if(tourMonster){
				tourMonster();
			}
			else {
				tourHunter();
			}
		}
		
	}

	@Override
	public void placePiege() {
		CaseIHM c = MainController.lastCase;
		
		if(!(c.getCase() instanceof TrapCase)) {
			c.setCase(new TrapCase());
			
			nbPiege--;
			MainController.writeConsole("Piege pose");
			MainController.setTextIndicator("Poser "+ nbPiege + " pieges dans la carte");
			
			GraphicsContext context = MainController.plateau.getGraphicsContext2D();
			context.clearRect(c.getRectangle().getX(), c.getRectangle().getY(), c.getRectangle().getWidth(), c.getRectangle().getHeight());
			Image herbe = new Image("/cam/ressources/herbe_possible.jpg");
			context.drawImage(herbe, c.getRectangle().getX(), c.getRectangle().getY(), c.getRectangle().getWidth(), c.getRectangle().getHeight());
		
			if(nbPiege <= 0) {
				MainController.writeConsole("Tout les pieges sont places");
				clearAll(false);
				temporisation("Tour du monstre");
				printAllMonster();
				MainController.setTextIndicator("Placer votre monstre");
				tourMonster = true;
			}
		}
		
	}

	@Override
	public void placeMonster() {
		
		CaseIHM c = MainController.lastCase;
		
		if(c.getCase().getPosition().getX() == 0 || c.getCase().getPosition().getX() == MainController.width - 1 ||
				c.getCase().getPosition().getY() == 0 || c.getCase().getPosition().getY() == MainController.height - 1) {
			
			plateau.getMonstre().setX(c.getCase().getPosition().getX());
			plateau.getMonstre().setY(c.getCase().getPosition().getY());
			
			MainController.drawMonster(c.getCase().getPosition().getX(), c.getCase().getPosition().getY());
			
			MainController.writeConsole("Le monstre est pose");
			
			monsterPlace = true;
		
		
			clearAll(true);
			temporisation("Tour du Chasseur");
			printAllHunter();
			MainController.setTextIndicator("C'est a votre tour " + HunterPlayer.getNom());
			tourMonster = false;
		}
	}

	@Override
	public void tourHunter() {

		CaseIHM c = MainController.lastCase;
		plateau.deplacerChasseur(plateau.getPlateau()[c.getCase().getPosition().getX()][c.getCase().getPosition().getY()].getCase());
		
		MainController.removeHunter(plateau.getChasseurPositionLast().getX(), plateau.getChasseurPositionLast().getY());
		MainController.drawHunter(plateau.getChasseur().getPosition().getX(), plateau.getChasseur().getPosition().getY());
		
		
		if(plateau.getChasseur().getPosition().equals(plateau.getMonstre().getPosition())) {
			PFC = true;
			
			PierreFeuilleCiseauxEvent.localGame = true;
			MainController.canClick = false;
			
			MainController.writeConsole("Vous avez trouve le monstre !");
			MainController.setTextIndicator("PIERRE FEUILLE CISEAUX DE LA VICTOIRE !");
			clearAll(false);
			
			try{
				Game.PierreFeuilleCiseaux = new Stage();
				FXMLLoader loader = new FXMLLoader();
		        loader.setLocation(getClass().getResource("/cam/ressources/PierreFeuilleCiseauxFenetre.fxml"));
		        Parent parent;
				parent = loader.load();
				Scene scene = new Scene(parent);
				Game.PierreFeuilleCiseaux.setScene(scene);
				Game.PierreFeuilleCiseaux.setAlwaysOnTop(true);
				Game.PierreFeuilleCiseaux.setTitle("Pierre-Feuille-Ciseaux");
				Game.PierreFeuilleCiseaux.show();
				
				PierreFeuilleCiseauxEvent.Indicator.setText("Au CHASSEUR de choisir");
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
	        
		}
		else {
			if(c.getCase().isVisited()) {
				MainController.writeConsole("La case a etait visitee il y a " + c.getCase().getTourVisited() + " tour(s)");
			}
			else {
				MainController.writeConsole("La case n'a jamais etait visite par le monstre");
			}
		}
		
		clearAll(false);
		temporisation("Tour du monstre");
		printAllMonster();
		
		MainController.setTextIndicator("C'est a votre tour " + MonsterPlayer.getNom());
		
		MainController.writeConsole("TOUR " + tour);
	}

	@Override
	public void tourMonster() {

		CaseIHM c = MainController.lastCase;
		
		if(plateau.deplacerMonstre(c.getCase())) {
			MainController.removeMonster(plateau.getMonstrePositionLast().getX(), plateau.getMonstrePositionLast().getY());
			MainController.drawMonster(plateau.getMonstre().getPosition().getX(), plateau.getMonstre().getPosition().getY());
			
			if(plateau.sontToutesVisitee()) {
				MainController.writeConsole("Partie Terminee !");
				MainController.setTextIndicator("Le monstre gagne !");
				gameFinish = true;
			}
			else if(plateau.monstreBloquer()) {
				MainController.writeConsole("Partie Terminee !");
				MainController.setTextIndicator("Match nul ! monstre bloque !");
				gameFinish = true;
			}
			else {
				clearAll(true);
				temporisation("Tour du Chasseur");
				printAllHunter();
				
				tourMonster = false;
				
				MainController.setTextIndicator("C'est a votre tour " + HunterPlayer.getNom());
				
				updateTourVisited();
				tour++;
				MainController.writeConsole("TOUR " + tour);
				
				MainController.setTextIndicator("Tour du monstre: choisissez une case valide");
			}
		}
	}
	
	private void temporisation(String message) {
		MainController.canClick = false;
		
		Alert alert = new Alert(AlertType.INFORMATION, message, ButtonType.YES);
		alert.showAndWait();
		
		MainController.canClick = true;
	}
	
	private void clearAll(boolean isForMonster) {
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
	
	private void clearMap() {
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
	
	private void printAllMonster() {
		printMonsterMap();
		
		MainController.console.setText(this.consoleMonsterPlayer);
		MainController.setTextIndicator(this.indicatorMonsterPlayer);
	}
	
	private void printMonsterMap() {
		GraphicsContext context = MainController.plateau.getGraphicsContext2D();
		
		for (int i = 0; i < plateau.getPlateau().length; i++) {
			for (int j = 0; j < plateau.getPlateau()[0].length; j++) {
				CaseIHM c = plateau.getPlateau()[i][j];
				
				if(c.getCase().isVisited()) {
					context.clearRect(c.getRectangle().getX(), c.getRectangle().getY(), c.getRectangle().getWidth(), c.getRectangle().getHeight());
				}
				
			}
		}
		
		MainController.drawMonster(plateau.getMonstre().getPosition().getX(), plateau.getMonstre().getPosition().getY());
	}
	
	private void printAllHunter() {
		printHunterMap();
		
		MainController.console.setText(this.consoleHunterPlayer);
		MainController.setTextIndicator(this.indicatorHunterPlayer);
	}
	
	private void printHunterMap() {
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

}
