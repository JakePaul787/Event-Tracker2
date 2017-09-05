package entities;

import javax.persistence.*;

@Entity
@Table(name="user_experience")
public class UserExperience {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="user_comment")
	private String userComment;
	
	@Column(name="got_munchies")
	private boolean gotMunchies;
	
	@Column(name="percent_thc")
	private double percentTHC;
	
	@Enumerated(EnumType.STRING)
	private Type type;

	@Enumerated(EnumType.STRING)
	@Column(name="method_of_use")
	private MethodOfUse methodOfUse;

	
	
	public UserExperience() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserComment() {
		return userComment;
	}

	public void setUserComment(String userComment) {
		this.userComment = userComment;
	}

	public boolean getGotMunchies() {
		return gotMunchies;
	}

	public void setGotMunchies(boolean gotMunchies) {
		this.gotMunchies = gotMunchies;
	}

	public double getPercentTHC() {
		return percentTHC;
	}

	public void setPercentTHC(double percentTHC) {
		this.percentTHC = percentTHC;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public MethodOfUse getMethodOfUse() {
		return methodOfUse;
	}

	public void setMethodOfUse(MethodOfUse methodOfUse) {
		this.methodOfUse = methodOfUse;
	}

	@Override
	public String toString() {
		return "UserExperience [id=" + id + ", userComment=" + userComment + ", gotMunchies=" + gotMunchies
				+ ", percentTHC=" + percentTHC + ", type=" + type + ", methodOfUse=" + methodOfUse + "]";
	}
	
	
	
}
