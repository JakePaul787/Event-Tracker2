package data;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.ObjectMapper;

import entities.UserExperience;

@Transactional
public class EventDAOImpl implements eventDAO {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Set<UserExperience> index() {
		String query = "SELECT u FROM UserExperience u";
		List<UserExperience> eventList = em.createQuery(query, UserExperience.class).getResultList();
		Set<UserExperience> eventSet = new HashSet<UserExperience>(eventList);
		return eventSet;
	}

	@Override
	public UserExperience show(int id) {
		String query = "SELECT u FROM UserExperience u WHERE u.id = :id";
		UserExperience event = em.createQuery(query, UserExperience.class).setParameter("id", id).getResultList().get(0);
		return event;
	}

	@Override
	public UserExperience create(String eventJson) {
		UserExperience u = null;
		ObjectMapper om = new ObjectMapper();
		System.out.println("in the create Method");
		try {
			u = om.readValue(eventJson, UserExperience.class);
			em.persist(u);
			em.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return u;
	}

	@Override
	public UserExperience update(int id, String eventJson) {
		UserExperience managed = em.find(UserExperience.class, id);
		UserExperience u1 = null;
		ObjectMapper om = new ObjectMapper();

		try {
			u1 = om.readValue(eventJson, UserExperience.class);
			managed.setGotMunchies(u1.getGotMunchies());
			managed.setMethodOfUse(u1.getMethodOfUse());
			managed.setPercentTHC(u1.getPercentTHC());
			managed.setType(u1.getType());
			managed.setUserComment(u1.getUserComment());
			
		} catch (Exception e) {
			e.printStackTrace();		
		}
		
		return managed;
	}

	@Override
	public Boolean destroy(int id) {
		UserExperience u = em.find(UserExperience.class, id);
		
		try {
			em.remove(u);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
