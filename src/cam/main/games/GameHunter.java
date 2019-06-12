package cam.main.games;

import java.io.IOException;

import cam.utils.cases.TrapCase;
import cam.utils.ihm.CaseIHM;
import cam.utils.ihm.MainController;
import cam.utils.ihm.PlateauIHM;
import cam.utils.ihm.menu.events.PierreFeuilleCiseauxEvent;
import cam.utils.personnages.Chasseur;
import cam.utils.personnages.Position;
import cam.utils.personnages.ia.EasyMonster;
import cam.utils.personnages.ia.HardMonster;
import cam.utils.personnages.ia.MonstreIA;
import cam.utils.personnages.ia.RandomMonster;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 * Classe fille heritant de Game
 * Cette classe permet de creer une partie en incarnant le chasseur contre un bot Monstre
 * @author allan
 */
public class GameHunter extends Game
{

	private int nbPiege;
	
	
	private Chasseur joueur;
	private MonstreIA ia;
	
	/**
	 * constructeur qui permet de creer une partie en incarnant le chasseur contre un bot Monstre
	 * @param hunterName le nom du chasseur
	 * @param botLevel le niveau du bot monstre (1: facile | 2: normal | 3: difficile)
	 * @param cases le tableau de case du plateau
	 */
	public GameHunter(String hunterName, int botLevel, CaseIHM[][] cases)
	{
		nbPiege = 3;
		
		gameFinish = false;
		PFC = false;
		
		this.joueur = new Chasseur(0, 0, hunterName);
		
		if(botLevel == 1)
			this.ia = new RandomMonster(0, 0, "Monstre");
		else if(botLevel == 2)
			this.ia = new EasyMonster(0, 0, "Monstre");
		else
			this.ia = new HardMonster(0, 0, "Monstre");
		
		this.plateau = new PlateauIHM(ia, joueur, cases);
		
		MainController.writeConsole("Chasseur: " + this.joueur.getNom());
		MainController.writeConsole("Le chasseur doit pose 3 pieges");
		MainController.setTextIndicator("Poser "+ nbPiege + " pieges dans la carte");
	}
	
	
	@Override
	public void execute()
	{
		if(!gameFinish && !PFC) {
			
			if(nbPiege > 0) {
				placePiege();
			}
			else {
				tourHunter();
			}
			
		}
	}
	
	@Override
	public void placeMonster() {
		ia.placeMonster(plateau);
	}


	@Override
	public void placePiege()
	{
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
				placeMonster();
				MainController.writeConsole("Le monstre est place !");
				MainController.setTextIndicator("C'est a votre tour " + joueur.getNom() + " !");
			
				MainController.writeConsole("TOUR " + tour);
			}
		}
		
	}


	@Override
	public void tourHunter()
	{
		CaseIHM c = MainController.lastCase;
		plateau.deplacerChasseur(plateau.getPlateau()[c.getCase().getPosition().getX()][c.getCase().getPosition().getY()].getCase());
		
		MainController.removeHunter(plateau.getChasseurPositionLast().getX(), plateau.getChasseurPositionLast().getY());
		MainController.drawHunter(plateau.getChasseur().getPosition().getX(), plateau.getChasseur().getPosition().getY());
		
		
		if(plateau.getChasseur().getPosition().equals(plateau.getMonstre().getPosition())) {
			PFC = true;
			
			PierreFeuilleCiseauxEvent.playerIsMonster = false;
			MainController.canClick = false;
			MainController.writeConsole("Vous avez trouve le monstre !");
			MainController.setTextIndicator("PIERRE FEUILLE CISEAUX DE LA VICTOIRE !");
			
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
		else {
			if(c.getCase().isVisited()) {
				MainController.writeConsole("La case a etait visitee il y a " + c.getCase().getTourVisited() + " tour(s)");
			}
			else {
				MainController.writeConsole("La case n'a jamais etait visite par le monstre");
			}
		}
		
		updateTourVisited();
		tourMonster();
		tour++;
		MainController.writeConsole("TOUR " + tour);
	}


	@Override
	public void tourMonster()
	{
		Position pos = ia.ChoosePosition(plateau);
		plateau.deplacerMonstre(plateau.getPlateau()[pos.getX()][pos.getY()]);
		
		if(!gameFinish && !PFC) {
			if(plateau.sontToutesVisitee()) {
				gameFinish = true;
				MainController.setTextIndicator("Le monstre a gagne !");
				MainController.clearConsole();
				MainController.writeConsole("Le monstre a parcouru tout le plateau");
			}
			else if(plateau.monstreBloquer()) {
				gameFinish = true;
				MainController.setTextIndicator("Match nul !");
				MainController.clearConsole();
				MainController.writeConsole("Le monstre est bloque !");
			}
		}
	}

}
