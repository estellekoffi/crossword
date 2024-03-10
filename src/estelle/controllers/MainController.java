package estelle.controllers;

import java.net.URL;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import estelle.dbconnections.Database;
import estelle.models.Clue;
import estelle.models.Crossword;
import estelle.models.GridModel;
import javafx.beans.property.StringProperty;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

public class MainController implements Initializable  {


    @FXML
    private ScrollPane gridListingScrollPane;
    
    @FXML
    private StackPane stackPane;
    
    @FXML
    private GridPane crosswordGridPane;
    
    @FXML
    private final ListView<Clue> horizontalClueListView = new ListView<>();

    @FXML
    private final ListView<Clue> verticalClueListView  = new ListView<>();;
    
    @FXML
    private ScrollPane horizontalClueScrollPane;
    
    @FXML
    private ScrollPane verticalClueScrollPane;

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
				TextField tf = new TextField();			
				// tf.setDisable(true);
		        // tf.setStyle("-fx-control-inner-background: #000000;");
				crosswordGridPane.add(tf, i, j);
				
			}
		}
		
		this.verticalClueListView.getItems().addAll(crossword.getVerticalClues());
		this.horizontalClueListView.getItems().addAll(crossword.getHorizontalClues());
		this.stackPane.getChildren().add(crosswordGridPane);
		this.verticalClueScrollPane.setContent(verticalClueListView);
		this.horizontalClueScrollPane.setContent(horizontalClueListView);
		

	}
	
	
	
	
	private class TextFieldClickHandler implements EventHandler<MouseEvent> {

		@Override
		public void handle(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
        
	}


}
