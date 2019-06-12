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

/**
 * Classe fille heritant de Game
 * Cette classe permet de creer une partie en incarnant le monstre contre un bot Chasseur
 * @author allan
 */
public class GameMonster extends Game
{

	private boolean monsterPlace;
	
	private Monstre joueur;
	private HunterIA ia;
	
	/**
	 * constructeur qui permet de creer une partie en incarnant le monstre contre un bot Chasseur
	 * @param monsterName le nom du chasseur
	 * @param botLevel le niveau du bot monstre (1: facile | 2: normal | 3: difficile)
	 * @param cases le tableau de case du plateau
	 */
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
		MainController.writeConsole("Le chasseur a posé 3 pèges");
		MainController.setTextIndicator("Tour du monstre: Placer le monstre aux extrèmités");
	
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
			
			printMonsterMap(true);
			
			MainController.writeConsole("Le monstre est posé");
			
			monsterPlace = true;
		
			tourHunter();
			MainController.writeConsole("Le chasseur à joué !");
			MainController.setTextIndicator("Tour du monstre: Choisissez une case valide");
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
			MainController.writeConsole("Le chasseur à trouvé le monstre ! Attention");
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
			clearMap();
			printMonsterMap(true);
			
			if(plateau.sontToutesVisitee()) {
				MainController.writeConsole("Partie Terminée !");
				MainController.setTextIndicator("Le monstre gagne !");
				gameFinish = true;
			}
			else if(plateau.monstreBloquer()) {
				MainController.writeConsole("Partie Terminee !");
				MainController.setTextIndicator("Match nul ! monstre bloqué !");
				gameFinish = true;
			}
			else {
				tourHunter();
				MainController.writeConsole("Le chasseur à joué !");
				
				updateTourVisited();
				tourMonster();
				tour++;
				MainController.writeConsole("TOUR :" + tour);
				
				MainController.setTextIndicator("Tour du monstre: choisissez une case valide");
			}
		}
	}

}
