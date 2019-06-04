package cam.utils.personnages.ia;

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

	public Position ChoosePosition(PlateauIHM plateau) {
		List<Case> cases = plateau.deplacementsPossible();
		Collections.shuffle(cases);
		return cases.get(0).getPosition();
	}

}
