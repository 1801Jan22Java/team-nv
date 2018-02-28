package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import beans.Flashcard;
import util.HibernateUtil;

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
