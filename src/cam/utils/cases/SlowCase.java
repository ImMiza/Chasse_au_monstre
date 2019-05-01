package cam.utils.cases;

import cam.utils.personnages.Monstre;
import cam.utils.personnages.Personnage;
import cam.utils.personnages.Position;
import cam.utils.plateau.Biome;
import cam.utils.plateau.Plateau;


/**
 * Crée une case qui ralentit le chasseur (diminue ses déplacements possibles)
 * @author Adrien BASSAIL
 */

public class SlowCase extends Case implements IEffetCase{

	/**
	 * Crée une nouvelle case à effet
	 */
	public SlowCase() {
		super();
	}

	/**
	 * Crée une nouvelle case à effet
	 * @param position : position de la base
	 * @param biome    : biome dans lequel se trouve la case
	 */
	public SlowCase(Position position, Biome biome) {
		super(position, biome);
	}

	/**
	 * Cree une nouvelle case à effet
	 * @param position : position de la case
	 */
	public SlowCase(Position position) {
		super(position);
	}

	/**
	 * Active la case à effet 
	 * @param personnage : Personnage qui est affecté par l'effet de la case
	 * @param plateau    : Plateau de la partie
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