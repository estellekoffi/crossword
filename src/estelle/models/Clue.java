package estelle.models;

public class Clue {
	
	private String clue;
	private int row, column;
	private boolean horizontal = true;
	
	public Clue(String clue, int row, int column, boolean horizontal) {
		this.clue = clue;
		this.row = row;
		this.column = column;
		this.horizontal = horizontal;
	}
	
	public Clue(String clue, int row, int column, int horizontal) {
		this.clue = clue;
		this.row = row;
		this.column = column;
		this.horizontal = horizontal == 1 ? true : false;
	}
	
	public String getClue( ) {
		return clue;
	}

	public int getRow() {
		return row;
	}
	
	public int getColumn() {
		return column;
	}
	
	public boolean isHorizontal() { return horizontal; }
	
	@Override
	public String toString() {
		return String.format("%s (%s, %s)", getClue(), getRow(), getColumn());
	}
}
