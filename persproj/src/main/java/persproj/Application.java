package persproj;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import persproj.jdbcPersistence.DatabaseFacade;
import persproj.model.Department;
import persproj.model.Person;

public class Application {

	public static void main(String[] args) {
		
		// Instanzieren der Fassade
		DatabaseFacade facade = new DatabaseFacade();
		
		// Laden der Personen aus der DB
		List<Person> persons;
		
		try {
			persons = facade.getAllPersons();
			
			for (Person p : persons) {
				System.out.println(p.toString());
			}
			
		} catch (PersProPersistenceException e) {
			// Ausgabe der geladenen Personen
			System.out.println(e.getMessage());
		}
		
		// Erstellen einer neuen Person
		Person person = new Person();
		person.setfDate(LocalDate.now());
		person.setFname("Franziska");
		person.setLname("Zudrell");
		person.setGender('w');
		person.setPersNo(1234);
		person.setSalary(BigDecimal.valueOf(50000));
		Department d = new Department();
		d.setDeptNo(1000);
		person.setDepartment(d);
		
		try {
			// Einfügen in die Datenbank
			facade.insertPerson(person);
		} catch (PersProPersistenceException e) {
			// Ausgabe der geladenen Personen
			System.out.println(e.getMessage());
		}
		
		// Laden der Personen aus der DB - diesmal sollte Franziska Zudrell dabei sein
		try {
			persons = facade.getAllPersons();
			
			for (Person p : persons) {
				System.out.println(p.toString());
			}
			
		} catch (PersProPersistenceException e) {
			// Ausgabe der geladenen Personen
			System.out.println(e.getMessage());
		}
		
	}
}
