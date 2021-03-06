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
import com.revature.dao.TagDaoImpl;
import com.revature.dao.UsersDaoImpl;
import com.revature.messages.FlashcardAdded;
import com.revature.messages.GroupAdded;
import com.revature.messages.GroupAddedUser;
import com.revature.messages.GroupMessage;
import com.revature.messages.UserAdded;
import com.revature.util.HibernateUtil;

@Service("groupService")
public class GroupsService {
	
	static UsersDaoImpl udi = new UsersDaoImpl();
	static TagDaoImpl tdi = new TagDaoImpl();
	static GroupDaoImpl gdi = new GroupDaoImpl();
	static PendingFlashcardDaoImpl pfcdi = new PendingFlashcardDaoImpl();
	
	public UserAdded addUser(int groupId, String userId) {
		gdi.addGroupUser(groupId, userId);
		return new UserAdded(true);
	}
	
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
		if(gdi.getGroupById(groupId)!=null)
		{
			return new GroupMessage(gdi.getGroupById(groupId));
		}
		else {
			return null;
		}
	}
	public Collection<Flashcard> getgroupFlashcards(int groupId)
	{
		Collection<Flashcard> lazyFlashcards = gdi.getGroupFlashcards(groupId);
		return lazyFlashcards;
	}
	public Collection<Flashcard> getgroupPendingFlashcards(int groupId)
	{
		Collection<Flashcard> flashcards = pfcdi.getPendingFlashcards(groupId);
		return flashcards;
	}
	public FlashcardAdded addGroupFlashcard(String question,String answer,String hint,String tagName, int groupId) {
		Tag tag = tdi.getTag(tagName);
		if(tag == null) {
			tag = new Tag(tagName);
			tdi.addTag(tag);
		}
		Flashcard f = new Flashcard(question, answer, hint, tag);
		gdi.addFlashcard(f, groupId);
		return new FlashcardAdded(f!=null);
	}
	public GroupAddedUser addGroupUser(int groupId, String userId) {	
		Collection<Group> groupsUsers = udi.getUsersGroups(userId);
		System.out.println(groupsUsers);
		for(Group g: groupsUsers)
			{
				if(g.getId()==groupId)
				{
					return new GroupAddedUser(false);
				}
			}
		return new GroupAddedUser(gdi.addGroupUser(groupId, userId));
	}
	public static void main(String[] args) {
		GroupsService gs = new GroupsService();
		gs.addGroupUser(30, "userTest5");
	}
}

