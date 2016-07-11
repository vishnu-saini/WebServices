package org.vishnu.webservices.messenger.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.vishnu.webservices.messenger.model.Post;
import org.vishnu.webservices.messenger.model.User;
import org.vishnu.webservices.messenger.utils.HibernateUtil;

public class PostDAO {

	public void addPost(Post post) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(post);
		session.getTransaction().commit();
		session.close();
	}

	public List<Post> getAllPosts() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		List<Post> allPosts = (List<Post>) session.createQuery("from Post").list();
		session.getTransaction().commit();
		return allPosts;
	}

	public Post getPost(long id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Post post = (Post) session.get(Post.class, id);
		session.getTransaction().commit();
		return post;
	}

	public List<Post> getPostByUser(String username) {

	}

	public void deletePost(long id) {

	}

	public void updatePost(Post post) {

	}

}
