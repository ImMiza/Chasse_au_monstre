package cam.utils.cases;

import cam.utils.personnages.Monstre;
import cam.utils.personnages.Personnage;
import cam.utils.personnages.Position;
import cam.utils.plateau.Biome;
import cam.utils.plateau.Plateau;

/**
 * Case de piège, le(s) pièges sont posés au début de la partie par le chasseur
 * Une case de piège ralentit le monstre quand il passe dessus
 * @author Adrien BASSAIL
 *
 */

public class TrapCase extends SlowCase {

	
	public TrapCase() {
		super();
	}

	public TrapCase(Position position, Biome biome) {
		super(position, biome);
	}

	public TrapCase(Position position) {
		super(position);
	}
}