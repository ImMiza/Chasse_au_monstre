package cam.main.games;

import cam.utils.cases.TrapCase;
import cam.utils.ihm.PlateauIHM;
import javafx.stage.Stage;

public abstract class Game {
	
	public static Stage PierreFeuilleCiseaux;
	
	public static boolean PFC;
	public static boolean gameFinish;
	
	protected TrapCase piege1;
	protected TrapCase piege2;
	protected TrapCase piege3;
	
	protected PlateauIHM plateau;
	
	public abstract void execute();
	
	public abstract void placePiege();
	
	public abstract void placeMonster();
	
	public abstract void tourHunter();
	
	public abstract void tourMonster();
}