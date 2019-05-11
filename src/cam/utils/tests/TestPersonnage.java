package cam.utils.tests;

import cam.utils.personnages.Chasseur;
import cam.utils.personnages.Monstre;
import cam.utils.personnages.Personnage;

/**
 * Classe de test des classes Personnages, Monstre et Chasseur
 * @author Boukhebza Allan
 */
public class TestPersonnage {

	public static void main(String[] args) {
		Personnage p1 = new Personnage(0, 0, "Personnage 1");
		Monstre p2 = new Monstre(5, 5, "Monstre");
		Chasseur p3 = new Chasseur(2, 9, "Chasseur");
		
		System.out.println(p1.getNom());
		System.out.println(p2.getNom());
		System.out.println(p3.getNom());
		
		System.out.println("======");
		
		System.out.println(p1.getNom() + " : " + p1.getPosition().toString());
		System.out.println(p2.getNom() + " : " + p2.getPosition().toString());
		System.out.println(p3.getNom() + " : " + p3.getPosition().toString());
	
		System.out.println("===MONSTRE===");
		
		System.out.println("Deplacement Horizontal max : " + p2.getDeplacementHorizontal());
		System.out.println("Deplacement Vertical max : " + p2.getDeplacementVertical());
		System.out.println("Deplacement Diagonal max : " + p2.getDeplacementDiagonal());
		System.out.println("bloque : " + p2.isBloque());
		p2.setBloque(true);
		System.out.println("bloque : " + p2.isBloque());
		
		System.out.println("===CHASSEUR===");
		System.out.println("Etourdi : " + p3.isEtourdi());
		p3.setEtourdi(true);
		System.out.println("Etourdi : " + p3.isEtourdi());
	}
}
