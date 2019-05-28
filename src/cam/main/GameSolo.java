package cam.main;

import cam.utils.ihm.CaseIHM;
import cam.utils.personnages.Personnage;
import cam.utils.personnages.ia.IA;
import cam.utils.plateau.Plateau;

/**
 * Deroulement d'une partie solo contre une IA
 * @author miza
 */
public class GameSolo {

	private CaseIHM[][] cases;
	
	private Personnage joueur;
	private IA bot;
	
	private Plateau plateau;
	
	public GameSolo(int width, int height) {
		init();
		
		
	}
	
	public GameSolo() {
		this(10,10);
	}
	
	public void init() {
		this.cases = new CaseIHM[width][height];
	}
}
