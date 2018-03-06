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
		Users u = new Users("temp6");
		userDao.addUser(u);
		//DataBaseDriver.create();
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		s.load(Users.class, "temp6");
		String temp = u.getId();
		tx.commit();
		s.close();
		assertNotNull(temp);
	}
	@Test
	public void getUserTest() {
		//DataBaseDriver.create();
		//userDao.addUser(new Users("temp"));
		Users temp = userDao.getUser("temp66");
		//DataBaseDriver.destroy();
		//System.out.println(temp.getId());
		assertNotNull(temp);
	}
	@Test
	public void getUserFlashcard() {
		Collection<Flashcard>test = userDao.getUsersFlashcards("userTest1");
		assertNotNull(test);
	}*/
}
