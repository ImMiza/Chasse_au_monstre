package cam.main.games;

import cam.utils.cases.TrapCase;
import cam.utils.ihm.PlateauIHM;
import javafx.stage.Stage;

public abstract class Game {
	
	protected int tour;
	
	public static Stage PierreFeuilleCiseaux;
	
	public static boolean PFC;
	public static boolean gameFinish;
	
	protected TrapCase piege1;
	protected TrapCase piege2;
	protected TrapCase piege3;
	
	protected PlateauIHM plateau;
	
	public Game() {
		tour = 1;
	}
	
	public abstract void execute();
	
	public abstract void placePiege();
	
	public abstract void placeMonster();
	
	public abstract void tourHunter();
	
	public abstract void tourMonster();
	
	protected void updateTourVisited() {
		for (int i = 0; i < plateau.getPlateau().length; i++) {
			for (int j = 0; j < plateau.getPlateau()[0].length; j++) {
				if(plateau.getPlateau()[i][j].getCase().isVisited()) {
					plateau.getPlateau()[i][j].getCase().setTourVisited(plateau.getPlateau()[i][j].getCase().getTourVisited() + 1);
				}
			}
		}
	}
}