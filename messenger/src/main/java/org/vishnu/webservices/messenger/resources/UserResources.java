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

@Path("/user")
public class UserResources {
    @GET
    @Path("/{username}/fname/{firstName}/lname/{lastName}")
    @Produces(MediaType.APPLICATION_XML)
    public User setUser(@PathParam("username") String username,@PathParam("firstName") String firstName,@PathParam("lastName") String lastName) {
    	User user=new User();
    	user.setCreated(new Date());
    	user.setUsername(username);
    	user.setFirstName(firstName);
    	user.setLastName(lastName);
    	UserDAO userDAO=new UserDAO();
    	userDAO.addUser(user);
        return user;
    }
    
    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> getAllUsers() {
    	UserDAO userDAO=new UserDAO();
        return userDAO.getAllUsers();
    }
    
    @GET
    @Path("/{username}")
    @Produces(MediaType.APPLICATION_JSON)
    public User getUser(@PathParam("username") String username) {
    	UserDAO userDAO=new UserDAO();
        return userDAO.getUser(username);
    }
}
