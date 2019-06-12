package cam.main.games;

import java.io.IOException;

import cam.utils.ihm.CaseIHM;
import cam.utils.ihm.MainController;
import cam.utils.ihm.PlateauIHM;
import cam.utils.ihm.menu.events.PierreFeuilleCiseauxEvent;
import cam.utils.personnages.Monstre;
import cam.utils.personnages.Position;
import cam.utils.personnages.ia.EasyHunter;
import cam.utils.personnages.ia.HardHunter;
import cam.utils.personnages.ia.HunterIA;
import cam.utils.personnages.ia.RandomHunter;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GameMonster extends Game
{

	private boolean monsterPlace;
	
	private Monstre joueur;
	private HunterIA ia;
	
	public GameMonster(String monsterName, int botLevel, CaseIHM[][] cases)
	{
		monsterPlace = false;
		gameFinish = false;
		PFC = false;
		
		this.joueur = new Monstre(0, 0, monsterName);
		
		if(botLevel == 1)
			this.ia = new RandomHunter(0, 0, "Chasseur");
		else if(botLevel == 2)
			this.ia = new EasyHunter(0, 0, "Chasseur");
		else
			this.ia = new HardHunter(0, 0, "Chasseur");
		
		this.plateau = new PlateauIHM(joueur, ia, cases);
		
		MainController.writeConsole("Chasseur: Chasseur");
		MainController.writeConsole("Le chasseur a pose 3 pieges");
		MainController.setTextIndicator("Tour du monstre: Placer le monstre aux extremites");
	
		placePiege();
	}
	
	
	@Override
	public void execute()
	{
		if(!gameFinish && !PFC) {
			if(!monsterPlace) {
				placeMonster();
			}
			else {
				tourMonster();
			}
		}
	}
	
	public void placeMonster() {
		CaseIHM c = MainController.lastCase;
		
		if(c.getCase().getPosition().getX() == 0 || c.getCase().getPosition().getX() == MainController.width - 1 ||
				c.getCase().getPosition().getY() == 0 || c.getCase().getPosition().getY() == MainController.height - 1) {
			
			plateau.getMonstre().setX(c.getCase().getPosition().getX());
			plateau.getMonstre().setY(c.getCase().getPosition().getY());
			
			MainController.drawMonster(c.getCase().getPosition().getX(), c.getCase().getPosition().getY());
			
			MainController.writeConsole("Le monstre est pose");
			
			monsterPlace = true;
		
			tourHunter();
			MainController.writeConsole("Le chasseur a joue !");
			MainController.setTextIndicator("Tour du monstre: choisissez une case valide");
		}
	}


	@Override
	public void placePiege()
	{
		ia.posePiege(plateau);
	}


	@Override
	public void tourHunter()
	{
		Position pos = ia.ChoosePosition(plateau);
		plateau.deplacerChasseur(plateau.getPlateau()[pos.getX()][pos.getY()].getCase());
		
		if(pos.equals(plateau.getMonstre().getPosition())) {
			PFC = true;
			
			PierreFeuilleCiseauxEvent.playerIsMonster = true;
			MainController.canClick = false;
			MainController.writeConsole("Le chasseur a trouve le monstre ! Attention");
			MainController.setTextIndicator("PIERRE FEUILLE CISEAUX DE LA SURVIE");
			
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
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
	        
		}
	}


	@Override
	public void tourMonster()
	{
		CaseIHM c = MainController.lastCase;
		
		if(plateau.deplacerMonstre(c)) {
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
				tourHunter();
				MainController.writeConsole("Le chasseur a joue !");
				
				updateTourVisited();
				tourMonster();
				tour++;
				MainController.writeConsole("TOUR " + tour);
				
				MainController.setTextIndicator("Tour du monstre: choisissez une case valide");
			}
		}
	}

}
