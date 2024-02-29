package estelle.models;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class CrosswordSquare {
	
	private char solution;
	private StringProperty proposition;
	private int horizontalClue, verticalClue;
	private boolean black;
	
	public CrosswordSquare() {
		this.black = true;
	}
	
	public CrosswordSquare(char solution) {
		this.solution = solution;
		this.black = false;
	}
	
	public CrosswordSquare(char solution, int horString, int verString) {
		this.solution = solution;
		this.horizontalClue = horString;
		this.verticalClue = verString;
		this.black = false;
	}
	
	public String getProposition() { return proposition.get(); }
	public StringProperty propositionProperty() { return proposition; }
	public void setProposition(String proposition) { proposition = (new SimpleStringProperty(proposition)).get(); }

	public char getSolution() {
		return solution;
	}

	public void setSolution(char solution) {
		this.solution = solution;
	}

	public int getHorizontalClue() {
		return horizontalClue;
	}

	public void setHorizontalClue(int horizontalClue) {
		this.horizontalClue = horizontalClue;
	}

	public int getVerticalClue() {
		return verticalClue;
	}

	public void setVerticalClue(int verticalClue) {
		this.verticalClue = verticalClue;
	}

	public boolean isBlack() {
		return black;
	}

	public void setBlack(boolean black) {
		this.black = black;
	}
	

}
