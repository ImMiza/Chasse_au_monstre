package cam.utils.cases;

import cam.utils.personnages.Personnage;
import cam.utils.personnages.Position;
import cam.utils.plateau.Biome;
import cam.utils.plateau.Plateau;

/**
 * Cases permettant au monstre de se téléporter entre deux cases tp 
 * Le monstre, une fois sur cette case pourra se déplacer sur une autre cas teleporteur
 * @author Adrien BASSAIL
 *
 */

public class TeleportCase extends Case  implements IEffetCase {

	/**
	 * Crée une nouvelle case de téléportation
	 */
	public TeleportCase() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Cree une nouvelle case de teeleportation
	 * @param position : position de la case de teleportation sur le plateau
	 * @param biome    : biome dans lequel se trouve la case
	 */
	public TeleportCase(Position position, Biome biome) {
		super(position, biome);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Cree une nouvelle case de teleportation
	 * @param position : position de la case de teleportation sur le plateau
	 */
	public TeleportCase(Position position) {
		super(position);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void activeEffect(Personnage personnage, Plateau plateau) {
		// TODO
		
	}

}
