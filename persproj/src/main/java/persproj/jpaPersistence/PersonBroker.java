package persproj.jpaPersistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import persproj.model.Person;


// andere Broker funktionieren analog dazu, Abstraktion im package jdbc
public class PersonBroker extends BaseBroker<Person>{
	
	public Person getPersonByPersNo(String persno) {
		EntityManager entityManager = factory.createEntityManager();
		Person p = entityManager.find(Person.class, persno);
		
		return p;
	}

	@Override
	public List<Person> getAll() {
		EntityManager entityManager = factory.createEntityManager();
		List<Person> persons = entityManager.createQuery("from Person").getResultList();
		
		return persons;
	}
	
	// insert ist bereits im BaseBroker implementiert
	
}