package main;

import org.hibernate.Session;
import org.hibernate.Transaction;

import beans.Group;
import beans.Progress;
import beans.Tag;
import beans.Users;
import util.HibernateUtil;

public class Driver {
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
}
