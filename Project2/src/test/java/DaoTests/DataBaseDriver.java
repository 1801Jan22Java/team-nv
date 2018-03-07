package DaoTests;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.beans.*;
import com.revature.util.HibernateUtil;

public class DataBaseDriver 
{
	
	public static void create() {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		List<Flashcard> pendingFlashcards = new ArrayList<Flashcard>();
		//Create the Users
		Users u1 = new Users("userTest1");
		Users u2 = new Users("userTest2");
		Users u3 = new Users("userTest3");
		Users u4 = new Users("userTest4");
		Users u5 = new Users("userTest5");
		s.persist(u1);
		s.persist(u2);
		s.persist(u3);
		s.persist(u4);
		s.persist(u5);
		//Create Tags
		Tag tag1 = new Tag("jokes");
		Tag tag2 = new Tag("fractions");
		Tag tag3 = new Tag("biology");
		Tag tag4 = new Tag("division");
		Tag tag5 = new Tag("paradox");
		s.persist(tag1);
		s.persist(tag2);
		s.persist(tag3);
		s.persist(tag4);
		s.persist(tag5);
		//Create Flashcards
		Flashcard f1 = new Flashcard("What does the fox say?", "Ring Ding Ding and such", "don't let you memes be dreams",tag1);
		Flashcard f2 = new Flashcard("1/2 * 1/4", "1/8", "multiply across",tag2);
		Flashcard f3 = new Flashcard("What is the study of birds called?", "Ornothology", "birds yo",tag3);
		Flashcard f4 = new Flashcard("123/0", "undefined", "never do this",tag4);
		Flashcard f5 = new Flashcard("can you burn toast?", "no", "what about bread?",tag5);
		s.persist(f1);
		s.persist(f2);
		s.persist(f3);
		s.persist(f4);
		s.persist(f5);
		//Create Groups
		Group g1 = new Group("Totology Club", "We meet where the Totology Club meets",u1);
		Group g2 = new Group("Meme group", "how can you kill that which has no life?",u2);
		Group g3 = new Group("Crab people", "talk like crab, tast like human",u3);
		Group g4 = new Group("Clubsandwhich", "tastes better than the crab peopl group",u4);
		Group g5 = new Group("The meming of life", "42 doge coins",u5);
		s.persist(g1);
		s.persist(g2);
		s.persist(g3);
		s.persist(g4);
		s.persist(g5);
		//Create Pending Flashcards
		PendingFlashcard pfc1 = new PendingFlashcard(f1,g1);
		PendingFlashcard pfc2 = new PendingFlashcard(f2,g2);
		PendingFlashcard pfc3 = new PendingFlashcard(f3,g3);
		PendingFlashcard pfc4 = new PendingFlashcard(f4,g4);
		PendingFlashcard pfc5 = new PendingFlashcard(f5,g5);
		s.persist(pfc1);
		s.persist(pfc2);
		s.persist(pfc3);
		s.persist(pfc4);
		s.persist(pfc5);
		//Create Progresses
		Progress p1 = new Progress(tag1, u1);
		Progress p2 = new Progress(tag2, u2);
		Progress p3 = new Progress(tag3, u3);
		Progress p4 = new Progress(tag4, u4);
		Progress p5 = new Progress(tag5, u5);
		s.persist(p1);
		s.persist(p2);
		s.persist(p3);
		s.persist(p4);
		s.persist(p5);
		//Add Groups to Users
		u1.getGroups().add(g1);
		u1.getGroups().add(g2);
		u1.getGroups().add(g3);
		u1.getGroups().add(g4);
		u1.getGroups().add(g5);
		//Add Flashcards to Users
		u1.getFlashcards().add(f1);
		u2.getFlashcards().add(f2);
		u3.getFlashcards().add(f3);
		u4.getFlashcards().add(f4);
		//Add Flashcards to groups
		g1.getFlashcards().add(f1);
		g2.getFlashcards().add(f2);
		g3.getFlashcards().add(f3);
		g4.getFlashcards().add(f4);
		g5.getFlashcards().add(f5);
		//end
		tx.commit();
		s.close();
	}
	public static void destroy() {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();		
		s.createSQLQuery("DROP TABLE GROUP_FLASHCARDS").executeUpdate();
		s.createSQLQuery("DROP TABLE PENDING_FLASHCARDS").executeUpdate();
		s.createSQLQuery("DROP TABLE PROGRESS").executeUpdate();	
		s.createSQLQuery("DROP TABLE USERS_FLASHCARDS").executeUpdate();
		s.createSQLQuery("DROP TABLE USERS_TAGS").executeUpdate();
		s.createSQLQuery("DROP TABLE FLASHCARD").executeUpdate();
		s.createSQLQuery("DROP TABLE USERS_GROUPS").executeUpdate();
		s.createSQLQuery("DROP TABLE TAG").executeUpdate();
		s.createSQLQuery("DROP TABLE GROUP_TABLE").executeUpdate();
		s.createSQLQuery("DROP TABLE USERS").executeUpdate();
		tx.commit();
		s.close();
	}
	public static void main(String[] args) {
		create();
		//destroy();
	}
}
