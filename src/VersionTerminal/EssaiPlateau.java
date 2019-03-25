package VersionTerminal;

public class EssaiPlateau {

	public static void main(String[] args) {
		Plateau p = new Plateau(8, 8);
		p.initialize();
		p.afficher();
		for (int i = 0; i < p.getPlateau().length; i++) {
			for (int j = 0; j < p.getPlateau()[i].length; j++) {
				if (p.getPlateau()[i][j].getCar() == 'M') {
					System.out.println(i + ", " + j);
				}
			}
		}
	}
}
