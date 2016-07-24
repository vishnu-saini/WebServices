package org.vishnu.webservices.messenger.resources;

import java.util.Date;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.vishnu.webservices.messenger.dao.PostDAO;
import org.vishnu.webservices.messenger.dao.UserDAO;
import org.vishnu.webservices.messenger.model.Post;
import org.vishnu.webservices.messenger.model.User;

@Path("/user")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UserResources {

    @POST
    public User addUser(User user) {
    	user.setCreated(new Date());
    	UserDAO userDAO=new UserDAO();
    	return userDAO.addUser(user);
    }
    
    @GET
    public List<User> getAllUsers() {
    	UserDAO userDAO=new UserDAO();
    	List<User> list=userDAO.getAllUsers();
        return list;
    }
    
    @PUT
    @Path("/{userid}")
    public User getUser(@PathParam("userid") long id,User user) {
    	UserDAO userDAO=new UserDAO();
    	System.out.println(user.getFirstName()+user.getLastName()+user.getUsername());
    	user.setId(id);
        return userDAO.updateUser(user);
    }
    
    @DELETE
    @Path("/{userid}")
    public void deleteUser(@PathParam("userid") long id) {
    	System.out.println(id);
    	UserDAO userDAO=new UserDAO();
        userDAO.deleteUser(id);
    }
    
    @GET
    @Path("/{userid}")
    public User getUser(@PathParam("userid") long id) {
    	System.out.println(id);
    	UserDAO userDAO=new UserDAO();
        return userDAO.getUser(id);
    }
    /*
    @GET
    @Path("/{username}/post/{message}")
    @Produces(MediaType.APPLICATION_JSON)
    public Post addPost(@PathParam("username") String username,@PathParam("message") String message) {
    	Post post=new Post();
    	PostDAO postDAO=new PostDAO();
    	UserDAO userDAO=new UserDAO();
    	post.setCreated(new Date());
    	post.setMessage(message);
    	post.setUser(userDAO.getUser(username));
    	return postDAO.addPost(post);
    }
    
    @GET
    @Path("/{username}/post/postId/{postId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Post getPostById(@PathParam("username") String username,@PathParam("postId") long postId) {
    	PostDAO postDAO=new PostDAO();
    	return postDAO.getPost(postId);
    }*/
}
