package data;

import java.util.Set;

import entities.*;

public interface eventDAO {
	 public Set<UserExperience> index();

	  public UserExperience show(int id);

	  public UserExperience create(String eventJson);

	  public UserExperience update(int id, String eventJson);

	  public Boolean destroy(int id);
}
