package estelle.dbconnections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Database {
	public static Connection connect() {
		try {
			String url = "jdbc:mysql://localhost:3306/base";
			String user = "estelle";
			String password = "estelle";
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url, user, password);
			return conn;
			
		}catch(ClassNotFoundException | SQLException e) {
			Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, e);
		}
		return null;
	}
}
