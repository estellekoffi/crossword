package estelle.models;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class CrosswordSquare {
	
	private char solution;
	private StringProperty proposition;
	private String horizontalClue, verticalClue;
	private boolean black;
	
	
	public CrosswordSquare() {}
	
	public String getProposition() { return proposition.get(); }
	public StringProperty propositionProperty() { return proposition; }
	public void setProposition(String proposition) { proposition = (new SimpleStringProperty(proposition)).get(); }

	public char getSolution() {
		return solution;
	}

	public void setSolution(char solution) {
		this.solution = solution;
	}

	public String getHorizontalClue() {
		return horizontalClue;
	}

	public void setHorizontalClue(String horizontalClue) {
		this.horizontalClue = horizontalClue;
	}

	public String getVerticalClue() {
		return verticalClue;
	}

	public void setVerticalClue(String verticalClue) {
		this.verticalClue = verticalClue;
	}

	public boolean isBlack() {
		return black;
	}

	public void setBlack(boolean black) {
		this.black = black;
	}
	

}
