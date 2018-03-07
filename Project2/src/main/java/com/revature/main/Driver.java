package com.revature.main;


import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.beans.Flashcard;
import com.revature.beans.Group;
import com.revature.beans.PendingFlashcard;
import com.revature.beans.Tag;
import com.revature.beans.Users;

import com.revature.util.HibernateUtil;

import DaoTests.DataBaseDriver;

public class Driver {
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
		destroy();
	}

}

