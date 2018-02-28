package main;

import org.hibernate.Session;
import org.hibernate.Transaction;

import beans.Group;
import beans.Progress;
import beans.Tag;
import beans.Users;
import dao.GroupDaoImpl;
import dao.UsersDaoImpl;
import util.HibernateUtil;


public class Driver {
	public static void init() {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		
		Tag tag1 = new Tag("Fractions");
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
		UsersDaoImpl gr = new UsersDaoImpl();
		System.out.println();
	}
	 public static void pleaseGodWork () {
	 }	       
}