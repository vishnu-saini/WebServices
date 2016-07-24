package org.vishnu.webservices.messenger.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.vishnu.webservices.messenger.model.User;
import org.vishnu.webservices.messenger.utils.HibernateUtil;

public class UserDAO {

	public User addUser(User user) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		session.close();
		return user;
	}
	
	public List<User> getAllUsers() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		List<User> allUsers =session.createCriteria(User.class).list();
		session.getTransaction().commit();
		session.close();
		return allUsers;
	}
	
	public User updateUser(User user) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		User user1 = (User) session.get(User.class, user.getId());
		user1.setFirstName(user.getFirstName());
		user1.setLastName(user.getLastName());
		user1.setUsername(user.getUsername());
		session.getTransaction().commit();
		session.close();
		return user1;
	}
	
	public boolean deleteUser(long id) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		User user = (User)session.load(User.class,id);
	    session.delete(user);
		session.getTransaction().commit();
		session.close();
		return true;
	}

	public User getUser(long id) {
		User user;
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		user = (User)session.get(User.class,id);
		session.getTransaction().commit();
		session.close();
		System.out.println(user.getFirstName());
		return user;
	}
}
