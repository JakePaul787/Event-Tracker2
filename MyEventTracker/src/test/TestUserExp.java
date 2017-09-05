package test;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import entities.UserExperience;

public class TestUserExp {
	
	private EntityManagerFactory emf;
	private EntityManager em;

	@Before
	public void setUp() throws Exception {
		emf = Persistence.createEntityManagerFactory("MyEventTracker");
		em = emf.createEntityManager();
	}

	@After
	public void tearDown() throws Exception {
		em.close();
		emf.close();
	}
	@Test
	public void doesUserExpHaveAllFields() {
	UserExperience ux = em.find(UserExperience.class, 1);
	System.out.println(ux);
	assertNotNull(ux);

	}

}
