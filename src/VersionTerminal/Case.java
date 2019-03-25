package VersionTerminal;

public class Case {

	private Position position;
	private char car;
	private boolean estDecouvert;
	
	public Case(Position p, char c) {
		this.position = p;
		this.car = c;
		this.estDecouvert = false;
	}
	
	public Case(int x, int y, char c) {
		this(new Position(x, y), c);
	}
	
	public Position getPosition() {
		return position;
	}
	
	public char getCar() {
		return car;
	}
	
	public boolean getEstDecouvert() {
		return this.estDecouvert;
	}
	
	public void setCar(char car) {
		this.car = car;
	}
	
	public void setEstDecouvert(boolean estDecouvert) {
		this.estDecouvert = estDecouvert;
	}
}
