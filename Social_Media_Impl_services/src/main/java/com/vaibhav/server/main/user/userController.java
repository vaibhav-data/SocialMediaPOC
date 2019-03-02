package com.vaibhav.server.main.user;

import java.net.URI;
import java.util.List;

import javax.annotation.PostConstruct;

import org.jboss.logging.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.vaibhav.server.main.exceptions.CentralizedExceptionHandler;
import com.vaibhav.server.main.exceptions.ExceptionBean;
import com.vaibhav.server.main.user.UserDAO;

@RestController
@Component
public class userController {

	@Autowired
	UserDAO usersDao;

	/**
	 * Contoller that return list of users to request source
	 * 
	 * @return List<User>
	 */
	@GetMapping(path = "/users/")
	public List<User> getUsers() {
		return usersDao.getallUsers();
	}

	/**
	 * Contoller to add users to list
	 * 
	 * @param user
	 * @return User
	 */
	@PostMapping(path = "/users/")
	public ResponseEntity<Object> saveUser(@RequestBody User user) {
		User savedUser = usersDao.saveUser(user);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId())
				.toUri();
		return ResponseEntity.created(location).build();

	}

	@GetMapping(path = "/user/{id}")
	public User getUser(@PathVariable int id) {
		User retivedUser = usersDao.retriveUser(id);
		if (retivedUser == null)
			throw new UserNotFoundException("id" + id);
		return retivedUser;
	}

	@DeleteMapping(path = "/user/{id}")
	public void deleteUser(@PathVariable int id) {
		User deletedUser = usersDao.deleteUser(id);
		if (deletedUser == null)
			throw new UserNotFoundException("id" + id);
	}

}
