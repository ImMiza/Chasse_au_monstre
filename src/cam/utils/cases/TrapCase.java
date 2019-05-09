package cam.utils.cases;

import cam.utils.personnages.Position;
import cam.utils.plateau.Biome;

/**
 * Case de piège, le(s) pièges sont posés au début de la partie par le chasseur
 * Une case de piège ralentit le monstre quand il passe dessus (limite ses déplacements quand il est sur la case de piege)
 * @author Adrien BASSAIL
 *
 */

public class TrapCase extends SlowCase {}