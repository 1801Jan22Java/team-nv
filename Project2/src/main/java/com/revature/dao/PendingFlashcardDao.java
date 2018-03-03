package com.revature.dao;

import java.util.Collection;
import java.util.List;

import com.revature.beans.Flashcard;
import com.revature.beans.Group;

public interface PendingFlashcardDao {
	
	public void addPendingFlashcard(Flashcard flashcard, Group group);
	
	public void deletePendingFlashcard(int pendingFlashcardId);
	
	public Collection<Flashcard> getPendingFlashcards(int groupId);

}

