package cam.utils.personnages.ia;

/**
 * Classe qui gère une IA aléatoire pour le Monstre
 * @author Allan Boukhebza 
 */

import java.util.Collections;
import java.util.List;

import cam.utils.cases.Case;
import cam.utils.ihm.PlateauIHM;
import cam.utils.personnages.Position;

public class RandomMonster extends MonstreIA{

	public RandomMonster(int x, int y, String nom) {
		super(x, y, nom);
	}

	public RandomMonster(Position p, String nom) {
		super(p, nom);
	}

	/**
	 * Choix de la nouvelle position du monstre de manière aléatoire dans la liste des cases
	 * possibles du monstre au moment de son tour de jeu
	 */
	public Position ChoosePosition(PlateauIHM plateau) {
		List<Case> cases = plateau.deplacementsPossible();
		Collections.shuffle(cases);
		return cases.get(0).getPosition();
	}

}
