package estelle.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import estelle.dbconnections.Database;
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
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainController implements Initializable  {


    @FXML
    private ScrollPane gridListingScrollPane;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
        
        Database db = Database.getInstance();

		List<GridModel> grids = db.getGrids();
		
        
        VBox contentVBox = new VBox();
        

		HBox line = new HBox();
		
		int i = 0;
		for(GridModel grid: grids) {
			Button btn = new Button(grid.nomGrille());
			
			btn.setOnAction(new EventHandler<ActionEvent>() {
				
				@Override
				public void handle(ActionEvent event) {
					playCrossword(event, grid.numeroGrille());
				}
			});
			line.getChildren().add(btn);
			
			i++;
			if(i == 3) {
				contentVBox.getChildren().add(line);
				line = new HBox();
				i = 0;
			}
		}
		
		this.gridListingScrollPane.setContent(contentVBox);
		
	}
	
	public void playCrossword(ActionEvent event, long numeroGrille) {
		

		Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource("/estelle/views/Crossword.fxml"));
			Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}


}
