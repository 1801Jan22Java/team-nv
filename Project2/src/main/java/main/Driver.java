package main;

<<<<<<< HEAD

import org.hibernate.Session;
import org.hibernate.Transaction;

import beans.Flashcard;
=======
import org.hibernate.Session;
import org.hibernate.Transaction;

import beans.Group;
import beans.Progress;
>>>>>>> 6da80ad7df5cf6ffceb735883e1c64acff6ceeb5
import beans.Tag;
import beans.Users;
import util.HibernateUtil;

public class Driver {
<<<<<<< HEAD

	public static void main(String[] args) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		
		Users u = new Users("test");
		Tag tag1 = new Tag("testing");
		Flashcard f1 = new Flashcard ("1","2","3",tag1);
		
		s.persist(u);
		s.persist(tag1);
		s.persist(f1);
		u.getFlashcards().add(f1);
		
		
		tx.commit();
		s.close();
		
		Session s2 = HibernateUtil.getSession();
		Transaction tx2 = s2.beginTransaction();
		
		Users u2 = (Users) s2.get(Users.class, "test");
		System.out.println(u2.getFlashcards());
		
		tx2.commit();
		s2.close();

	}

=======
	public static void init() {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		
		Tag tag1 = new Tag(0,"Fractions");
		Progress p1 = new Progress(0,0,0,tag1);
		
		//s.persist(user);
		//s.persist(whale);
		
		s.persist(tag1);
		s.save(p1);
		
		tx.commit();
		s.close();
		pleaseGodWork();
	}
	public static void main(String[] args) {
		init();
	}
	 public static void pleaseGodWork () {
	        Session s = HibernateUtil.getSession();
	        Transaction tx = s.beginTransaction();
	        
	        Users person = new Users();
	        person.setFirstName("leroy");
	        person.setLastName("Jenkins");
	        
	        
	        Group g = new Group();        
	        g.setGroupName("Biology");
	        
	        
	        person.setUsers(g);        
	        g.setUsers(person);
	        //s.save(person);
	        s.save(g);
	        s.save(person);
	        
	        
	        /*
	        for(User things : people.getGroup()) {
	            
	            s.save(things.getId());
	        }
	        for(User things : person.getPeople()) {
	            s.save(things.getId());
	        }
	        */
	        
	        tx.commit();
	        s.close();
	    }
>>>>>>> 6da80ad7df5cf6ffceb735883e1c64acff6ceeb5
}
