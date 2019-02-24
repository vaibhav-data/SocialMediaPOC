package com.vaibhav.server.main.user;

import java.util.List;

import javax.annotation.PostConstruct;

import org.jboss.logging.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.vaibhav.server.main.user.UserDAO;

@RestController
@Component
public class userController {
	
	@Autowired
	UserDAO usersDao;

	/**
	 * Contoller that return list of users to request source
	 * @return List<User>
	 */
	@GetMapping(path = "/users/")
	public List<User> getUsers(){
		return usersDao.getallUsers();
	}
	
	/**
	 * Contoller to add users to list
	 * @param user
	 * @return User
	 */
	@PostMapping(path = "/users/add")
	public void saveUser(@RequestBody User user) {
		usersDao.saveUser(user);
		
	}
	
	@GetMapping(path="/users/get/{id}")
		public User getUser(@PathVariable int id) {
			User retivedUser = usersDao.retriveUser(id);
			if(retivedUser==null||retivedUser.equals(null))
				throw new UserNotFoundException("id" + id);
			return retivedUser;
		}

}
