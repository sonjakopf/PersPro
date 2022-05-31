package persproj.jdbcPersistence.broker;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public abstract class BaseBroker<T> {
	
	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection(
				"jdbc:postgresql://elmo.hostingcenter.uclv.net:5432/DB_Name",
				"USER", "PASSWORD");
	}
	
	public abstract List<T> getAll() throws SQLException;
	
	public abstract void insert(T value) throws SQLException;

}
