package com.revature.dao;
import java.util.Collection;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.beans.*;
import com.revature.util.HibernateUtil;
public class UsersDaoImpl implements UsersDao{

	@Override
	public Users getUser(String UserId) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		
		Users u = (Users)s.get(Users.class, UserId);
		tx.commit();
		s.close();
		return u;
	}

	@Override
	public void addUser(String userId) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		
		Users u = new Users(userId);
		s.save(u);
		tx.commit();
		s.close();
	}

	@Override
	public void addUser(Users u) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		
		s.save(u);
		tx.commit();
		s.close();
	}

	@Override
	public Collection<Flashcard> getUsersFlashcards(String userId) {
		Session s = HibernateUtil.getSession();
		Users currentGroup = (Users)s.get(Users.class, userId);
		System.out.println(currentGroup);
		Collection<Flashcard>stuff = currentGroup.getFlashcards();
		s.close();
		return stuff;
	}

	@Override
	public Collection<Group> getUsersGroups(String userId) {
		Session s = HibernateUtil.getSession();
		Users currentGroup = (Users)s.get(Users.class, userId);
		System.out.println(currentGroup);
		Collection<Group>stuff = currentGroup.getGroups();
		s.close();
		return stuff;
	} 
}