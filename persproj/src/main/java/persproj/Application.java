package persproj;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import persproj.model.Person;

public class Application {

	public static void main(String[] args) {
		
		EntityManagerFactory fact = Persistence.createEntityManagerFactory("PersProj");
		EntityManager entityManager = fact.createEntityManager();
		List<Person> persons= (List<Person>) entityManager.createQuery("from Person").getResultList();
		for (Person p : persons) {
			System.out.println(p.toString());
		}
		
	}
}
