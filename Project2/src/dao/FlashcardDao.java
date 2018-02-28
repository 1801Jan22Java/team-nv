package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import beans.Flashcard;
import util.HibernateUtil;

public interface FlashcardDao {
	public String getQuestion(int flashCardId);
	
	public String getAnswer(int flashCardId);
	
	public String getHint(int flashCardId);
	
	

}
