package persproj;

import java.util.List;

import persproj.jpaPersistence.DatabaseFacade;
import persproj.model.Person;

public class Application {

	public static void main(String[] args) {
		
		DatabaseFacade facade = new DatabaseFacade();

		List<Person> persons = facade.getAllPersons();
		
		for (Person p : persons) {
			System.out.println(p.toString());
		}
	}
}
