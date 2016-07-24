package org.vishnu.webservices.messenger.resources;

import java.util.Date;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.vishnu.webservices.messenger.dao.UserDAO;
import org.vishnu.webservices.messenger.model.User;

/*@Path("/user/{username}/post")*/
public class PostResources {

	/*@GET
	@Path("/{postid}/fname/{firstName}/lname/{lastName}")
	@Produces(MediaType.APPLICATION_XML)
	public User setUser(@PathParam("username") String username,
			@PathParam("firstName") String firstName,
			@PathParam("lastName") String lastName) {
		User user = new User();
		user.setCreated(new Date());
		user.setUsername(username);
		user.setFirstName(firstName);
		user.setLastName(lastName);
		UserDAO userDAO = new UserDAO();
		userDAO.addUser(user);
		return user;
	}

	@GET
	@Path("/users")
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> getAllUsers() {
		UserDAO userDAO = new UserDAO();
		List<User> list = userDAO.getAllUsers();
		System.out.println(list.size());
		for (User user : list) {
			System.out.println(user.getFirstName());
		}
		return list;
	}

	@GET
	@Path("/{username}")
	@Produces(MediaType.APPLICATION_JSON)
	public User getUser(@PathParam("username") String username) {
		UserDAO userDAO = new UserDAO();
		return userDAO.getUser(username);
	}
*/
}
