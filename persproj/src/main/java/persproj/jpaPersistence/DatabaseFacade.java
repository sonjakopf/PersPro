package persproj.jpaPersistence;

import java.util.List;

import persproj.model.Person;

public class DatabaseFacade {

	public List<Person> getAllPersons() {
		return new PersonBroker().getAll();
	}
	
	public void insertPerson(Person value) {
		new PersonBroker().insert(value);
	}
	
	public Person getPersonByPersno(String persno) {
		return new PersonBroker().getPersonByPersNo(persno);
	}
	
}
