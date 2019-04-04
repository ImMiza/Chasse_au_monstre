package cam.utils.personnages;

public class Chasseur extends Personnage{
	
	private boolean etourdi;
	
	public Chasseur(Position p, String nom) {
		super(p, nom);
	}

	public Chasseur(int x, int y, String nom) {
		this(new Position(x, y), nom);
	}

	public boolean isEtourdi() {
		return etourdi;
	}

	public void setEtourdi(boolean etourdi) {
		this.etourdi = etourdi;
	}
}
