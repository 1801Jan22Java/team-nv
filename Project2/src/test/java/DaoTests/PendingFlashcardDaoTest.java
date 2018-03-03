package DaoTests;

import static org.junit.Assert.assertNotNull;

import java.util.Collection;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.revature.beans.*;
import com.revature.dao.PendingFlashcardDaoImpl;
import com.revature.util.HibernateUtil;

public class PendingFlashcardDaoTest {
	
	static PendingFlashcardDaoImpl pfcd = new PendingFlashcardDaoImpl();
	
	@Test
	public void addGroupTest() {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		Group g = new Group("Group name","Desctiption",(Users)s.get(Users.class, "temp1"));
		Tag tag = new Tag("goupTest");
		Flashcard fc = new Flashcard("q","h","a",tag);
		PendingFlashcard pfc = new PendingFlashcard(fc,g);
		s.persist(tag);
		s.persist(fc);
		s.persist(g);
		s.persist(pfc);
		int groupId = g.getId();
		Collection<Flashcard> temp = pfcd.getPendingFlashcards(groupId);
		System.out.println(temp);
		//assertNotNull(temp);
		s.close();
	}
}
