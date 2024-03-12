package estelle.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Crossword extends GridModel {
	
	
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
			
			int horizontal = 0;
			int vertical = 0;
			ArrayList<Integer> existingRows = new ArrayList<>();
			ArrayList<Integer> existingColumns = new ArrayList<>();
			while(data.next()) {
				// Creation de l'indice courant
				Clue x = new Clue(
						data.getString("definition"), 
						data.getInt("ligne"), 
						data.getInt("colonne"), 
						data.getInt("horizontal")
				);
				
				// Reponse -> horizontal ? reponse correspondant à $ligne : reponse correspondant à $colonne 
				String answer = data.getString("solution");
				
				if(x.isHorizontal()) { // Afficher sur la ligne
					this.horizontalClues.add(x);
					int index = 0;
					for(int i = x.getColumn() - 1; i < x.getColumn() + answer.length() - 1; i++) {
						try {
							setCell(x.getRow() - 1, i, new CrosswordSquare(answer.charAt(index++)));
						} catch(Exception e) {
							System.out.println("horizontal" + e.getMessage());
						}
					}
					if(!existingRows.contains(horizontal)) {
						existingRows.add(horizontal);
						horizontal++;
					}
					
				} else { // afficher sur la colonne
					this.verticalClues.add(x);
					int index = 0;
					for(int j = x.getRow() - 1; j < x.getRow() + answer.length() - 1; j++) {
						try {
							setCell(j, x.getColumn() - 1, new CrosswordSquare(answer.charAt(index++)));
						} catch(Exception e) {
							System.out.println("vertical" + e.getMessage());
						}
					}
					if(!existingColumns.contains(vertical)) {
						existingRows.add(vertical);
						vertical++;
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		for(int i = 0; i < this.verticalClues.size(); i++) {
			for(int j = 0; j < this.horizontalClues.size(); j++) {
				// this.setCell(i, j, new CrosswordSquare('A', i, j, false));
			}
		}
		
		this.horizontalClues.size();
		
		
	}

}
