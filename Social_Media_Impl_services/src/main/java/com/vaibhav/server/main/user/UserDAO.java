package com.vaibhav.server.main.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.vaibhav.server.main.user.User;

/**
 * @author Vaibhav
 *
 */
@Component
public class UserDAO {
	private static List<User> users = new ArrayList<>();
	private static int userCount = 3;

	public static List<User> getUsers() {
		return users;
	}

	public static int getUserCount() {
		return userCount;
	}

	static {
		users.add(new User("vaibhav", 1, new Date()));
		users.add(new User("jayesh", 2, new Date()));
		users.add(new User("vaibhav", 3, new Date()));
	}

	/**
	 * sends list of all users to controller
	 * 
	 * @return List<User>
	 */
	public List<User> getallUsers() {
		return users;
	}

	/**
	 * finds if user exits in list and send it to controller if user not found send
	 * null
	 * 
	 * @param id
	 * @return User
	 */
	public User retriveUser(int id) {
		for (User user : users) {
			if (user.getId() == id) {
				return user;
			}
		}
		return null;
	}
	
	/**
	 * save user to list
	 * 
	 * @param user
	 * @return User
	 */
	public User saveUser(User user) {
		if (user.getId() == null) {
			user.setId(++userCount);
			users.add(user);
			return user;
		} else {
			users.add(user);
		}
		return user;
	}

}
