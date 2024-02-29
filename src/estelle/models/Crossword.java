package estelle.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Crossword extends GridModel {
	

	// private long numeroMot,
	// private String definition,
	// private int horizontal,
	// private long ligne,
	// private long colonne,
	// private String solution,
	// private long numeroGrille
	
	// private int id;
	// private int height, width;
	// private CrosswordSquare[][] cells;
	// private String name;
	
	private ObservableList<Clue> verticalClues;
	private ObservableList<Clue> horizontalClues;
	
	public Crossword(int id, String name, int height, int width) {
		super(id, name, height, width);
		this.horizontalClues = FXCollections.observableArrayList();
		this.verticalClues = FXCollections.observableArrayList();
	}

	public ObservableList<Clue> getVerticalClues() { return verticalClues; }
	public ObservableList<Clue> getHorizontalClues() { return horizontalClues; }
	
	public void createPuzzle(ResultSet data) {
		try {
			while(data.next()) {
				Clue x = new Clue(
						data.getString("definition"), 
						data.getInt("ligne"), 
						data.getInt("colonne"), 
						data.getInt("horizontal")
				);
				if(x.isHorizontal())
					this.horizontalClues.add(x);
				else
					this.verticalClues.add(x);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
