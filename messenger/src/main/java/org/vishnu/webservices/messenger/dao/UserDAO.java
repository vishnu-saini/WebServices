package org.vishnu.webservices.messenger.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.vishnu.webservices.messenger.model.User;
import org.vishnu.webservices.messenger.utils.HibernateUtil;

public class UserDAO {

	public void addUser(User user) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		session.close();
	}

	public User getUser(String username) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();/* lets hope an id of 1 exists! */
		String queryString = "from User where username = :username";
		Query query = session.createQuery(queryString);
		query.setString("username", username);
		Object queryResult = query.uniqueResult();
		User user = (User) queryResult;
		session.getTransaction().commit();
		return user;
	}

	public void deleteUser(User user) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.delete(user);
		session.getTransaction().commit();
		session.close();
	}

	public void updateUser(User user) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		User user1 = session.get(User.class, user.getId());
		user1.setFirstName(user.getFirstName());
		user1.setLastName(user.getFirstName());
		user1.setUsername(user.getFirstName());
		session.getTransaction().commit();
		session.close();
	}

	public List<User> getAllUsers() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		List<User> allUsers = (List<User>) session.createQuery("from User").list();
		session.getTransaction().commit();
		return allUsers;
	}
}
