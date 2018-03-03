package com.revature.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.beans.*;

import com.revature.util.HibernateUtil;

public class FlashcardDaoImpl {
	public String getQuestion(int flashCardId){
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		Flashcard card = (Flashcard)s.get(Flashcard.class, flashCardId);
		s.close();
		return card.getQuestion();
	}
	
	public String getAnswer(int flashCardId){
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		Flashcard card = (Flashcard)s.get(Flashcard.class, flashCardId);
		s.close();
		return card.getAnswer();
	}
	
	public String getHint(int flashCardId){
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		Flashcard card = (Flashcard)s.get(Flashcard.class, flashCardId);
		s.close();
		return card.getHint();
	}
}