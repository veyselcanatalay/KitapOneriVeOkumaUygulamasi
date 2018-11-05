package bll;

import java.util.ArrayList;

import dalabstract.IUsersRepository;
import entities.Users;
import interfaces.IUsers;

public class UsersManager implements IUsers {

	IUsersRepository userRepository;
	
	public UsersManager(IUsersRepository usersRepository) {
		// TODO Auto-generated constructor stub
		super();
		this.userRepository = usersRepository;
	}
	@Override
	public boolean UyeSilme(int user_id) {
		// TODO Auto-generated method stub
		return userRepository.UyeSilme(user_id);
	}

	@Override
	public ArrayList<Users> UyeListeleme() {
		// TODO Auto-generated method stub
		return userRepository.UyeListeleme();
	}
	@Override
	public boolean UyeOlma(Users entity) {
		// TODO Auto-generated method stub
		return userRepository.UyeOlma(entity);
	}
	@Override
	public int UserID() {
		// TODO Auto-generated method stub
		return userRepository.UserID();
	}

}
