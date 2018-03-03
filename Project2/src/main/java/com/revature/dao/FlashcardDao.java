package com.revature.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.beans.Flashcard;

import com.revature.util.HibernateUtil;

public interface FlashcardDao {
	public String getQuestion(int flashCardId);
	
	public String getAnswer(int flashCardId);
	
	public String getHint(int flashCardId);
	
	

}