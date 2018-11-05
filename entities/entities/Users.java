package entities;

public class Users {

	private String user_id;
	private String location;
	private String age;
	private String password;

	public Users() {
		// TODO Auto-generated constructor stub
	}

	public Users(String user_id, String location, String age, String password) {
		super();
		this.user_id = user_id;
		this.location = location;
		this.age = age;
		this.password = password;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
