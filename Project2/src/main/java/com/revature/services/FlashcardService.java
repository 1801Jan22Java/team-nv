package com.revature.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Service;

import com.revature.beans.Flashcard;
import com.revature.beans.Group;
import com.revature.dao.FlashcardDaoImpl;
import com.revature.dao.GroupDaoImpl;
import com.revature.dao.UsersDaoImpl;
import com.revature.messages.GroupMessage;

@Service("flashcardService")
public class FlashcardService {
	static FlashcardDaoImpl fdi = new FlashcardDaoImpl();
	static UsersDaoImpl udi = new UsersDaoImpl();
	
	public Collection<Flashcard> getUsersFlashcards(String userId){
		return udi.getUsersFlashcards(userId);
	}
}
