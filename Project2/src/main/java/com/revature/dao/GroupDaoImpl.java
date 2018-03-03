package com.revature.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.beans.*;

import com.revature.util.HibernateUtil;

public class GroupDaoImpl implements GroupDao{
    
	@Override
	public String getGroupName(int groupId){	
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		UsersDaoImpl us = new UsersDaoImpl();
		Group group = (Group)s.get(Group.class, groupId);
		s.close();
		return group.getGroupName();
	}
	
	@Override
	public void setGroupName(int groupId, String name){
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		Group group = (Group)s.get(Group.class, groupId);
		group.setGroupName(name);
		s.update("Group" , group);
		tx.commit();
		s.close();		
	}
	
	@Override
	public Collection<Flashcard> getGroupFlashcards(int groupId) {
		Session s = HibernateUtil.getSession();
		Group currentGroup = (Group)s.get(Group.class, groupId);
		System.out.println(currentGroup);
		Collection<Flashcard>stuff = currentGroup.getFlashcards();
		s.close();
		return stuff;
	}

	@Override
	public void addGroup(Group g) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		s.save(g);
		tx.commit();
		s.close();
	}

	@Override
	public Collection<Users> getGroupsUsers(int groupId) {
		Session s = HibernateUtil.getSession();
		Group currentGroup = (Group)s.get(Group.class, groupId);
		System.out.println(currentGroup);
		Collection<Users>stuff = currentGroup.getUsers();
		s.close();
		return stuff;
	}

	@Override
	public Collection<Group> getAllGroups() {
		Session s = HibernateUtil.getSession();
		Collection<Group> allGroups = (Collection<Group>)s.createQuery("from Group").list();
		s.close();
		return allGroups;
	}

	@Override
	public Group getGroupById(int groupId) {
		Session s = HibernateUtil.getSession();
		Group group = (Group)s.get(Group.class, groupId);
		s.close();
		return group;
	}
}