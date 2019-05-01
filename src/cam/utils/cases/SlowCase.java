package cam.utils.cases;

import cam.utils.personnages.Monstre;
import cam.utils.personnages.Personnage;
import cam.utils.personnages.Position;
import cam.utils.plateau.Biome;
import cam.utils.plateau.Plateau;


/**
 * Crée une case qui ralentit le chasseur
 * @author Adrien BASSAIL
 *
 */

public class SlowCase extends Case implements IEffetCase{

	public SlowCase() {
		super();
	}

	public SlowCase(Position position, Biome biome) {
		super(position, biome);
	}

	public SlowCase(Position position) {
		super(position);
	}

	/**
	 * Active l'effet de personnage ralenti
	 * @param monstre à ralentir
	 */
	public void activeEffect(Personnage personnage, Plateau plateau) {
		if(personnage instanceof Monstre) {
			Monstre monster = (Monstre) personnage;
			monster.setDeplacementDiagonal(0);
			monster.setDeplacementHorizontal(1);
			monster.setDeplacementVertical(1);
			
			System.out.println("Monstre ralenti par une case slow !");
		}
	}
}