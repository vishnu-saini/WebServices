package org.vishnu.webservices.messenger.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.vishnu.webservices.messenger.model.Post;
import org.vishnu.webservices.messenger.model.User;
import org.vishnu.webservices.messenger.utils.HibernateUtil;

import com.sun.org.apache.regexp.internal.recompile;

public class PostDAO {

	public Post addPost(Post post) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(post);
		session.getTransaction().commit();
		session.close();
		return post;
	}

	public Post getPost(long postId) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Post post =  (Post) session.get(Post.class, postId);
		session.getTransaction().commit();
		session.close();
		return post;
	}

	public void deletePost(Post post) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.delete(post);
		session.getTransaction().commit();
		session.close();
	}

	public void updatePost(Post post) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Post post1 = (Post) session.get(Post.class, post.getId());
		post1.setMessage(post.getMessage());
		session.getTransaction().commit();
		session.close();
	}

/*	public List<User> getAllPostOfUser() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		String queryString = "from Post where username = :username";
		Query query = session.createQuery(queryString);
		query.setString("username", username);
		Object queryResult = query.uniqueResult();
		User user = (User) queryResult;
		session.getTransaction().commit();
		session.close();
		return user;
	}*/
}
