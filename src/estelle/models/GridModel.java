package estelle.models;

public class GridModel{

	private int id;
	private int height, width;
	private CrosswordSquare[][] cells;
	private String name;
	
	public GridModel(int id, String name, int height, int width) {
		this.id = id;
		this.name = name;
		this.height = height;
		this.width = width;
		this.cells = new CrosswordSquare[height][width];
	}
	
	public int getId() { return id; }
	public int getHeight() { return height; }
	public int getWidth() { return width; }
	public String getName() { return name; }
	
	public boolean correctCoords(int row, int column) { return true; }
	
	public CrosswordSquare getCell(int row, int column) {
		return cells[row][column];
	}
	
	public void setCell(int row, int column, CrosswordSquare cellValue) {
		 cells[row][column] = cellValue;
	}
	
}
