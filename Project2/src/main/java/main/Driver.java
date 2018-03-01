package main;


import org.hibernate.Session;
import org.hibernate.Transaction;

import beans.Flashcard;
import beans.Group;
import beans.PendingFlashcard;
import beans.Tag;
import beans.Users;
import util.HibernateUtil;

public class Driver {

	public static void main(String[] args) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		
		Users u = new Users("test");
		Users u2 = new Users("test2");
		Tag tag1 = new Tag("testing");
		Flashcard f1 = new Flashcard ("1","2","3",tag1);
		Group g1 = new Group("Test Group", u);
		s.persist(g1);
		s.persist(f1);
		System.out.println(f1.getFlashcardId()+"wat");
		PendingFlashcard pf1 = new PendingFlashcard(f1.getFlashcardId(),g1.getId());
		s.persist(u);
		s.persist(u2);
		s.persist(tag1);
		s.save(pf1);
		u.getFlashcards().add(f1);
		
		
		//tx.commit();
		//s.close();
		
		//Session s2 = HibernateUtil.getSession();
		//Transaction tx2 = s2.beginTransaction();
		
		//Users u2 = (Users) s2.get(Users.class, "test");
		//System.out.println(u2.getFlashcards());
		
		//tx2.commit();
		//s2.close();

	}

}
