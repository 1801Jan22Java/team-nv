package main.java.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import beans.Users;
import main.java.util.*;

public class UsersDaoImpl {
	
	public String getFirstName(int userId){
		Session s = HibernateUtil.getSession();
		Query q = s.createQuery("from Users where id = :var");
		q.setParameter("var", userId);
		List<Users> person = q.list();
		s.close();
		return person.get(0).getFirstName();
	}
	
	public String getLastName(int userId){
		Session s = HibernateUtil.getSession();
		
		Query q = s.getNamedQuery("from Users where id =:var");
		q.setInteger("var", userId);
		List<Users> person = q.list();
		s.close();
		return person.get(0).getLastName();
	}
	
	public String getEmail(int userId){
		Session s = HibernateUtil.getSession();
		
		Query q = s.getNamedQuery("from Users where id =:var");
		q.setInteger("var", userId);
		List<Users> person = q.list();
		s.close();
		return person.get(0).getEmail();
	}
	
	public String getUsername(int userId){
		Session s = HibernateUtil.getSession();
		
		Query q = s.getNamedQuery("from Users where id =:var");
		q.setInteger("var", userId);
		List<Users> person = q.list();
		s.close();
		return person.get(0).getUsername();
	}
	
	public void setFirstName(int userId, String name){
		Session s = HibernateUtil.getSession();
		Query q = s.createQuery("from Users where user_id =:var");
		q.setParameter("var", userId);
		List<Users> person = q.list();
		System.out.println(person.get(0).getLastName());
		System.out.println(person.get(0).getEmail());
		Users new_person = new Users( name, person.get(0).getLastName(),person.get(0).getEmail());
		s.save(new_person);
		s.close();
		
	}
		
	

}
