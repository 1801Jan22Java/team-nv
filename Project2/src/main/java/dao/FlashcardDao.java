package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import beans.Flashcard;
import util.HibernateUtil;

public interface FlashcardDao {
    public String getQuestion(int flashCardId);    
    public String getAnswer(int flashCardId);    
    public String getHint(int flashCardId);    
    public void setQuestion(int userId, String name);    
    public void setAnswer(int userId, String name);    
    public void setHint(int userId, String name);

}