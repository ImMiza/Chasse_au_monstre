package cam.utils.cases;

import cam.utils.personnages.Personnage;
import cam.utils.personnages.Position;
import cam.utils.plateau.Biome;
import cam.utils.plateau.Plateau;

/**
 * Cases permettant au monstre de se téléporter entre deux cases tp 
 * La case sera visible par le monstre lors de son tour
 * Le monstre, une fois sur cette case pourra se déplacer sur une autre cas teleporteur
 * A VOIR ? UNE TELEPORT CASE NE SERAIT PAS FORCEMENT UNE CASE SUR LAQUELLE LE MONSTRE DOIT PASSER 
 * POUR FAIRE GAGNER LE MONSTRE
 * @author Adrien BASSAIL
 *
 */

public class TeleportCase extends Case  implements IEffetCase {

	
	public TeleportCase() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TeleportCase(Position position, Biome biome) {
		super(position, biome);
		// TODO Auto-generated constructor stub
	}

	public TeleportCase(Position position) {
		super(position);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void activeEffect(Personnage personnage, Plateau plateau) {
		// TODO
		
	}

}
