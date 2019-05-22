package cam.utils.ihm.menu;

import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public class Accueil extends GridPane{

	private Button solo;
	private Button multijoueur;
	private Button aide;
	private Button Quitter;
	
	public Accueil() {
		this.solo = new Button("Solo");
		this.multijoueur = new Button("Multijoueur");
		this.aide = new Button("Aide");
		this.Quitter = new Button("Quitter");
		
		this.add(this.solo, 0, 3);
		this.add(this.multijoueur, 0, 4);
		this.add(this.aide, 0, 5);
		this.add(this.Quitter, 0, 6);
	}
}
