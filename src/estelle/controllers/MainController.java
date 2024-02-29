package estelle.controllers;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import estelle.dbconnections.Database;
import estelle.models.GridModel;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class MainController implements Initializable  {


    @FXML
    private ScrollPane gridListingScrollPane;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
        
        Database db = Database.getInstance();

		List<GridModel> grids = db.getGrids();
		
		for(GridModel grid: grids) {
			System.out.println(grid.numeroGrille());
		}
		
        
        VBox contentVBox = new VBox();
        

		HBox line = new HBox();
		line.getChildren().add(new Button("button"));
		line.getChildren().add(new Button("button"));
		line.getChildren().add(new Button("button"));
		line.getChildren().add(new Button("button"));
		
		contentVBox.getChildren().add(line);
		
      
		
		this.gridListingScrollPane.setContent(contentVBox);
		
	}


}
