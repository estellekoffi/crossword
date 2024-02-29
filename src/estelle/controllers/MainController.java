package estelle.controllers;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.util.List;
import java.util.ResourceBundle;

import estelle.dbconnections.Database;
import estelle.models.Clue;
import estelle.models.Crossword;
import estelle.models.GridModel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainController implements Initializable  {


    @FXML
    private ScrollPane gridListingScrollPane;
    
    @FXML
    private GridPane crosswordGridPane;
    
    @FXML
    private ListView<?> horizontalClueListView;

    @FXML
    private ListView<?> verticalClueListView;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
        
		Database db = Database.getInstance();
		GridModel grid = db.getCurrentGrid();
		
		// Recuperation du jeu de mot croisé selectionné
		ResultSet result = db.getCrosswordResultSet(grid);
		Crossword crossword = new Crossword(grid.getId(), grid.getName(), grid.getHeight(), grid.getWidth());
		crossword.createPuzzle(result);
				
		this.crosswordGridPane = new GridPane();
		for(int i = 0; i < crossword.getWidth(); i++) {
			for(int j = 0; j < crossword.getHeight(); j++) {
				crosswordGridPane.add(new TextField(), i, j);
			}
		}
				
		verticalClueListView = new ListView<>(crossword.getVerticalClues());
		horizontalClueListView = new ListView<>(crossword.getHorizontalClues());
	
				
		// (Crossword crossword: crosswords) {
		//	System.out.println(crossword.definition());
		// }

		// this.gridListingScrollPane.setContent(contentVBox);
		
	}
	

}
