package estelle.dbconnections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import estelle.models.Clue;
import estelle.models.Crossword;
import estelle.models.GridModel;
import estelle.models.GridModel;


public class Database {
	
	private Connection conn;
	private Statement state;
	
	private GridModel currentGrid;
	
	public void setCurrentGrid(GridModel _current) {
		this.currentGrid = _current;
	}
	
	public GridModel getCurrentGrid() {
		return this.currentGrid;
	}
	
	
	private static Database _instance;
	
	private Database() { this.conn = getConnection(); }
	
	public static Database getInstance() {
        if (_instance == null) _instance = new Database();
        return _instance;
    }
	
	private Connection getConnection() {
		Connection conn = null;
		try {
			String url = "jdbc:mysql://localhost:3306/crossword";
			String user = "serber";
			String password = "password";
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, password);
			
		} catch(ClassNotFoundException | SQLException e) {
			Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, e);
		}
		return conn;
	}
	
	private void createState() throws Exception {
		if(this.conn == null) throw new Exception("Error to connect to database");
		this.state = this.conn.createStatement();
	}
	
	private void closeState() {
		try { this.state.close(); }
		catch (SQLException e) { e.printStackTrace(); }
	}
	
	public List<GridModel> getGrids() {
		
		ResultSet data;
		List<GridModel> retour = new ArrayList();
		
		try {
			createState();
			data = this.state.executeQuery("SELECT * FROM GRID");
			while(data.next()) {
				retour.add(new GridModel(
						data.getInt("numero_grille"), 
						data.getString("nom_grille"), 
						data.getInt("hauteur"), 
						data.getInt("largeur"))
				);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return retour;
		
	}

	public ResultSet getCrosswordResultSet(GridModel gridModel) {
		
		try {
			createState();
			return this.state.executeQuery("SELECT * FROM CROSSWORD WHERE numero_grille = '" + gridModel.getId() + "'");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
