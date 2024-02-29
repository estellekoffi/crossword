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

public class FirstController implements Initializable {
	
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
			Button btn = new Button(grid.getName());
			btn.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					db.setCurrentGrid(grid);
					playCrosswordGame(event, grid);
				}
			});
			line.getChildren().add(btn);
			
			
			if(i == 3) {
				contentVBox.getChildren().add(line);
				line = new HBox();
				i = 0;
			}
			i++;
		}
		
		this.gridListingScrollPane.setContent(contentVBox);
		
	}
	
	private void playCrosswordGame(ActionEvent event, GridModel grid) {
		Parent root;
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/estelle/views/Crossword.fxml"));
		try {
			root = loader.load();
			MainController controller = loader.getController();
			// Passage de la grille selectionnée au controleur principale et de l'evenement d'origine pour
			// pouvoir recuperer le stage source.
			// controller.sendData(grid);
			// Lancement de la scene principale permettant de jouer aux mots croisés
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
