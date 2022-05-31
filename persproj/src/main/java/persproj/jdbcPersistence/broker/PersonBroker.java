package persproj.jdbcPersistence.broker;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import persproj.model.Person;

public class PersonBroker extends BaseBroker<Person>{
	
	public List<Person> getAll() throws SQLException {
		
		List<Person> persons = new ArrayList<Person>();
		Connection c = getConnection();
		
		try {
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery("select * from person");
			
			while (rs.next()) {
				Person p = new Person();
				
				p.setPersNo(rs.getInt("persno"));
				p.setFname(rs.getString("fname"));
				p.setLname(rs.getString("lname"));
				p.setfDate(rs.getDate("fdate").toLocalDate());
				p.setlDate(rs.getDate("ldate") != null ? rs.getDate("ldate").toLocalDate() : null);
				// ... und so weiter
				
				persons.add(p);
			}
		} finally {
			c.close();
		}
		return persons;
	}

	@Override
	public void insert(Person value) throws SQLException {
		Connection c = null;
		try {
			c = getConnection();
			PreparedStatement statement = c.prepareStatement("insert into person "
					+ "(persno, fname, lname, department, salary, fdate, ldate, gender) "
					+ "values (?, ?, ?, ?, ?, ?, ?, ?)");
			
			statement.setInt(1, value.getPersNo());
			statement.setString(2, value.getFname());
			statement.setString(3, value.getLname());
			statement.setObject(4, (value.getDepartment() != null ? value.getDepartment().getDeptNo() : null), Types.INTEGER);
			statement.setBigDecimal(5, value.getSalary());
			statement.setObject(6, value.getfDate() != null ? Date.valueOf(value.getfDate()) : null, Types.DATE);
			statement.setObject(7, value.getlDate() != null ? Date.valueOf(value.getlDate()) : null, Types.DATE);
			statement.setString(8, String.valueOf(value.getGender()));
		
			statement.execute();			
		} finally {
			c.close();
		}
	}

}
