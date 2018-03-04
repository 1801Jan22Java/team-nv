package DaoTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.Collection;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.revature.beans.Flashcard;
import com.revature.beans.Group;
import com.revature.beans.Tag;
import com.revature.beans.Users;
import com.revature.dao.UsersDaoImpl;
import com.revature.util.HibernateUtil;

public class UsersDaoTest {
	/*
	public static UsersDaoImpl userDao = new UsersDaoImpl();
	
	@Test
	public void addUserTest() {
		Users u = new Users("temp");
		userDao.addUser(u);
		DataBaseDriver.create();
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		s.load(Users.class, "temp");
		String temp = u.getId();
		tx.commit();
		s.close();
		assertNotNull(temp);
	}
	//@Test
	public void getUserTest() {
		DataBaseDriver.create();
		userDao.addUser(new Users("temp"));
		Users temp = userDao.getUser("temp");
		DataBaseDriver.destroy();
		System.out.println(temp.getId());
		assertNotNull(temp);
		DataBaseDriver.destroy();
	}
	//@Test
	public void getGroupFlashcard() {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		Users u = new Users("temp");
		Tag tag = new Tag("goupTest");
		Flashcard fc = new Flashcard("q","h","a",tag);
		s.persist(tag);
		s.persist(fc);
		s.persist(u);
		u.getFlashcards().add(fc);
		String userId = "temp";
		System.out.println(userId);
		tx.commit();
		s.close();
		Collection<Flashcard>test = userDao.getUsersFlashcards(userId);
		assertNotNull(test);
	}*/
}
