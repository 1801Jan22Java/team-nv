package dao;

import java.util.ArrayList;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import beans.Group;
import util.HibernateUtil;

public class GroupDaoImpl {
	public String getGroupName(int groupId){	
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		UsersDaoImpl us = new UsersDaoImpl();
		Group group = (Group)s.get(Group.class, groupId);
		s.close();
		return group.getGroupName();
	}
	
	
	public void setGroupName(int groupId, String name){
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		UsersDaoImpl us = new UsersDaoImpl();
		Group group = (Group)s.get(Group.class, 1);
		group.setGroupName(name);
		s.update("Group" , group);
		tx.commit();
		s.close();		
	}		
	
	public ArrayList<Integer> getGroupFlashcardID(int groupId) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();		
		//Query q = s.createQuery("SELECT p FROM Group id JOIN fetch p.groups c WHERE c.id = :var");
		Query q = s.createSQLQuery("SELECT * FROM GROUPS_FLASHCARD WHERE GROUP_ID ="+groupId).addScalar("FLASHCARD_ID");
		//q.setParameter("var", userId);
		ArrayList<Integer> stuff = new ArrayList();
		for(int i = 0; i<q.list().size();i++) {
		 stuff.add( Integer.parseInt(q.list().get(0).toString()));
		}
		//System.out.println(value);
		s.close();
		return stuff;
	}
}
