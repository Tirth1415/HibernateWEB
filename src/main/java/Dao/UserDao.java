package Dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import Connection.DBConnection;
import Model.User;

public class UserDao {
	Session session = null;
	Transaction tx = null;
	List<User> list = null;

	public void insertUser(User u) {
		session = new DBConnection().getSession();
		tx = session.beginTransaction();

		session.save(u);

		tx.commit();
		session.close();
		System.out.println("Account Registered Suceesfully.");
	}

	public User userLogin(User u) {
		User u1 = null;
		session = new DBConnection().getSession();
		tx = session.beginTransaction();

		Query q = session.createQuery("from User u where u.Email=:Email and u.Password=:Password");
		q.setParameter("Email", u.getEmail());
		q.setParameter("Password", u.getPassword());

		list = q.list();
		u1 = list.get(0);

		tx.commit();
		session.close();

		return u1;

	}

}
