package interfaces;

import java.util.ArrayList;

import entities.Users;

public interface IUsers {
	boolean UyeSilme(int user_id);
	
	boolean UyeOlma(Users entity);
	
	int UserID();

	ArrayList<Users> UyeListeleme();

}
