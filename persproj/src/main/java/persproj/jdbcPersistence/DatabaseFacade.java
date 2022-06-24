package persproj.jdbcPersistence;

import java.sql.SQLException;
import java.util.List;

import persproj.exception.PersProPersistenceException;
import persproj.jdbcPersistence.broker.PersonBroker;
import persproj.model.Person;

public class DatabaseFacade {
	
	public List<Person> getAllPersons() throws PersProPersistenceException {
		// TO DO : An Broker delegieren
		PersonBroker pb = new PersonBroker();
		try {
			return pb.getAll();
		} catch (SQLException e) {
			e.printStackTrace(); // idealerweise schreiben wir das in ein Logfile
			throw new PersProPersistenceException("Personen konnten nicht aus der Datenbank geladen werden.");
		}
	}
	
	public void insertPerson(Person value) throws PersProPersistenceException {
		PersonBroker pb  = new PersonBroker();
		try {
			pb.insert(value);
		} catch (SQLException e) {
			e.printStackTrace(); // idealerweise schreiben wir das in ein Logfile
			throw new PersProPersistenceException("Person konnte nicht in die Datenbank eingefügt werden: " + value.toString());
		}
	}
}
