package estelle.controllers;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GridController extends Application{


	@Override
	public void start(Stage stage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("/estelle/views/Grid.fxml"));
		
		Scene scene = new Scene(root, 600, 400);
		stage.setScene(scene);
		stage.setTitle("Crossword game - select one");
		stage.show();
		

	}

}
