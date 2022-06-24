package persproj.jpaPersistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public abstract class BaseBroker<T> {
	
	protected static EntityManagerFactory factory = Persistence.createEntityManagerFactory("PersProj");

	public abstract List<T> getAll();
	
	public void insert(T value) {
		EntityManager entityManager = factory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(value);
		entityManager.getTransaction().commit();
		entityManager.close();
	}
	
	// für update und delete gibt es hier weitere Methoden die analog zu insert auch schon im BaseBroker implementiert werden können
}
