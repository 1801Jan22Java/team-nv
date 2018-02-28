package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import beans.*;
import util.HibernateUtil;

public class FlashcardDaoImpl implements FlashcardDao {
    
	public void addFlashcard(String question, String answer, String hint, Tag tag) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		
		Flashcard f = new Flashcard(question, answer, hint, tag);
		s.save(f);
		
		tx.commit();
		s.close();
	}
	public void deleteFlashcard(String flashcardId) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		
		s.delete(s.get(Flashcard.class, flashcardId));
		
		tx.commit();
		s.close();
	}
    public String getQuestion(int flashcardId){
        Session s = HibernateUtil.getSession();
        Transaction tx = s.beginTransaction();
        Flashcard card = (Flashcard)s.get(Flashcard.class, flashcardId);
        s.close();
        return card.getQuestion();
    }
    
    public String getAnswer(int flashcardId){
        Session s = HibernateUtil.getSession();
        Transaction tx = s.beginTransaction();
        Flashcard card = (Flashcard)s.get(Flashcard.class, flashcardId);
        s.close();
        return card.getAnswer();
    }
    
    public String getHint(int flashcardId){
        Session s = HibernateUtil.getSession();
        Transaction tx = s.beginTransaction();
        Flashcard card = (Flashcard)s.get(Flashcard.class, flashcardId);
        s.close();
        return card.getHint();
    }
    
    public void setQuestion(int userId, String name){
        Session s = HibernateUtil.getSession();
        Transaction tx = s.beginTransaction();
        FlashcardDaoImpl fl = new FlashcardDaoImpl();
        Flashcard card = (Flashcard)s.get(Flashcard.class, userId);
        card.setQuestion(name);
        s.update("FlashCard" , card);
        tx.commit();
        s.close();        
    }
    
    public void setAnswer(int userId, String name){
        Session s = HibernateUtil.getSession();
        Transaction tx = s.beginTransaction();
        FlashcardDaoImpl fl = new FlashcardDaoImpl();
        Flashcard card = (Flashcard)s.get(Flashcard.class, userId);
        card.setAnswer(name);
        s.update("FlashCard" , card);
        tx.commit();
        s.close();        
    }
    
    public void setHint(int userId, String name){
        Session s = HibernateUtil.getSession();
        Transaction tx = s.beginTransaction();
        FlashcardDaoImpl fl = new FlashcardDaoImpl();
        Flashcard card = (Flashcard)s.get(Flashcard.class, userId);
        card.setHint(name);
        s.update("FlashCard" , card);
        tx.commit();
        s.close();        
    }
    

}