package com.revature.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.beans.Flashcard;
import com.revature.beans.Group;
import com.revature.beans.PendingFlashcard;
import com.revature.beans.Tag;
import com.revature.beans.Users;
import com.revature.util.HibernateUtil;

public class PendingFlashcardDaoImpl implements PendingFlashcardDao{

	@Override
	public Collection<Flashcard> getPendingFlashcards(int groupId) {
		Session s = HibernateUtil.getSession();
		Query q = s.createQuery("select flashcard from PendingFlashcard where groups = :param1");
		q.setParameter("param1",groupId);
		Group currentGroup = (Group)s.get(Group.class, groupId);
		Collection<Flashcard> pendingFlashcards = q.list();
				//currentGroup.getPendingFlashcards();
		return pendingFlashcards;
	}

	@Override
	public void addPendingFlashcard(Flashcard flashcard, Group group) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		PendingFlashcard pf = new PendingFlashcard(flashcard, group);
		s.save(pf);
		tx.commit();
		s.close();
		List<Flashcard> pendingFlashcards = new ArrayList<Flashcard>();
	}

	@Override
	public void deletePendingFlashcard(int pendingFlashcardId) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		PendingFlashcard fp = (PendingFlashcard)s.get(PendingFlashcard.class, pendingFlashcardId);
		s.delete(fp);
		tx.commit();
		s.close();
		List<Flashcard> pendingFlashcards = new ArrayList<Flashcard>();
	}
}
