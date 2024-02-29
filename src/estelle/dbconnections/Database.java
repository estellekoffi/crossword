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

import estelle.models.GridModel;


public class Database {
	
	private Connection conn;
	private Statement state;
	
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
						data.getLong("numero_grille"), 
						data.getString("nom_grille"), 
						data.getLong("largeur"), 
						data.getLong("hauteur"), 
						data.getString("controle"))
				);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return retour;
		
	}

	public List getCrosswords(long numeroGrille) throws SQLException {
		
		ResultSet data = this.state.executeQuery("SELECT * FROM GRID");
		
		List<GridModel> retour = new ArrayList();
		
		while(data.next()) {
			
			retour.add(new GridModel(
					data.getLong("numero_grille"), 
					data.getString("nom_grille"), 
					data.getLong("largeur"), 
					data.getLong("hauteur"), 
					data.getString("controle"))
			);
		}
		
		return retour;
	}
}
