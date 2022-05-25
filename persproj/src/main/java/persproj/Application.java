package persproj;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Application {

	public static void main(String[] args) {
		
		// Dies ist eine Testapplikation um zu veranschaulichen, wie wir eine Verbindung zur Datenbank herstellen.
		
		Connection c = null;
		
		// 1. Herstellen der Verbindung
		try {
			
			c = DriverManager.getConnection(
					"jdbc:postgresql://elmo.hostingcenter.uclv.net:5432/DB_NAME",
					"USERNAME", "PASSWORD");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	
		try {
			
			// 2. Erstellen & Ausführen des Statements
			Statement stmt = c.createStatement();
			
			ResultSet rs = stmt.executeQuery("select * from person");
			
			// 3. Durchlaufen des Resultsets & Konsolenausgabe aller Nachnamen
			while (rs.next()) {
				System.out.println(rs.getString("lname"));
		}

		} catch (SQLException e) {
			e.printStackTrace();
		} 		
	}
		
}
