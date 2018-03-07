package com.revature.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;

import com.revature.beans.*;
import com.revature.dao.GroupDaoImpl;
import com.revature.dao.PendingFlashcardDaoImpl;
import com.revature.dao.ProgressDaoImpl;
import com.revature.messages.FlashcardAdded;
import com.revature.messages.GroupAdded;
import com.revature.messages.GroupAddedUser;
import com.revature.messages.GroupMessage;
import com.revature.messages.UserAdded;
import com.revature.util.HibernateUtil;

@Service("groupService")
public class GroupsService {
	
	static GroupDaoImpl gdi = new GroupDaoImpl();
	static PendingFlashcardDaoImpl pfcdi = new PendingFlashcardDaoImpl();
	
	public GroupAdded addGroup(Group g) {
		gdi.addGroup(g); 
		return new GroupAdded(gdi.getGroupById(g.getId())!=null);
	}
	public Collection<GroupMessage> getAllGroups(){
		List<GroupMessage> groupMessages = new ArrayList<GroupMessage>();
		for(Group g : gdi.getAllGroups())
		{
			groupMessages.add(new GroupMessage(g));
		}
		return groupMessages;
	}
	public GroupMessage getGroupById(int groupId){
		return new GroupMessage(gdi.getGroupById(groupId));
	}
	public Collection<Flashcard> getgroupFlashcards(int groupId)
	{
		Collection<Flashcard> flashcards = new ArrayList<Flashcard>();
		Session s = HibernateUtil.getSession();
		Collection<Flashcard> lazyFlashcards = gdi.getGroupFlashcards(groupId);
		for(Flashcard f:lazyFlashcards)
		{
			flashcards.add(new Flashcard(f.getAnswer(),f.getQuestion(),f.getHint(),f.getTag()));
		}
		s.close();
		return flashcards;
	}
	public Collection<Flashcard> getgroupPendingFlashcards(int groupId)
	{
		Collection<Flashcard> flashcards = pfcdi.getPendingFlashcards(groupId);
		return flashcards;
	}
	public FlashcardAdded addGroupFlashcard(Flashcard f, int groupId) {
		gdi.addFlashcard(f, groupId);
		return new FlashcardAdded(f!=null);
	}
	public GroupAddedUser addGroupUser(int groupId, String userId) {	
		return new GroupAddedUser(gdi.addGroupUser(groupId, userId));
	}
}

