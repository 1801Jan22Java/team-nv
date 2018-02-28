package dao;

import java.util.ArrayList;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import beans.Group;
import util.HibernateUtil;

public interface GroupDao {
	public String getGroupName(int groupId);
	
	
	public void setGroupName(int groupId, String name);	
	
	public ArrayList<Integer> getGroupFlashcardID(int groupId);

}
