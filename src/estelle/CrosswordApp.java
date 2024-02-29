package estelle;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CrosswordApp extends Application {
	
	public static void main(String[] args) {
		System.out.println("CrossWordApp is running... ");
		launch(args);
	}

	
	@Override
	public void start(Stage stage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("/estelle/views/Grid.fxml"));
		
		Scene scene = new Scene(root, 600, 400);
		stage.setScene(scene);
		stage.setResizable(false);
		stage.setTitle("Crossword game - select one");
		stage.show();
		

	}

}
