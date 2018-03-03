package com.revature.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.beans.Flashcard;
import com.revature.beans.Group;
import com.revature.beans.Users;
import com.revature.util.HibernateUtil;

public interface GroupDao {
public void addGroup(Group g);
	
	public Collection<Group> getAllGroups();
	
	public String getGroupName(int groupId);
	
	public void setGroupName(int groupId, String name);	
	
	public Collection<Flashcard> getGroupFlashcards(int groupId);
	
	public Collection<Users> getGroupsUsers(int groupId);
	
	public Group getGroupById(int groupId);

}