package cam.utils.cases;

import cam.utils.personnages.Position;
import cam.utils.plateau.Biome;

/**
 * Case de piège, le(s) pièges sont posés au début de la partie par le chasseur
 * Une case de piège ralentit le monstre quand il passe dessus (limite ses déplacements quand il est sur la case de piege)
 * @author Adrien BASSAIL
 *
 */

public class TrapCase extends SlowCase {

	/**
	 * Cree une nouvelle case de piege
	 */
	public TrapCase() {
		super();
	}

	/**
	 * Cree une nouvelle case de piege
	 * @param position : position de la case de piege sur le plateau
	 * @param biome    : biome dans lequel se trouve la case
	 */
	public TrapCase(Position position, Biome biome) {
		super(position, biome);
	}

	/**
	 * Cree une nouvelle case de piege
	 * @param position : position de la case de piege sur le plateau
	 */
	public TrapCase(Position position) {
		super(position);
	}
}