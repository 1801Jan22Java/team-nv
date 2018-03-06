package com.revature.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.beans.*;

import java.util.List;

import com.revature.util.HibernateUtil;

public class ProgressDaoImpl implements ProgressDao{

	public List<Progress> getAllProgress() {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.getTransaction();
		Query q = s.createQuery("from Progress");
		List<Progress> p = q.list();
		s.close();
		return p;

	}

	//public List<Progress> getProgressByEmployeeId(String EmploeeId) {

	//}

	public Progress getProgressById(int id) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.getTransaction();
		Progress p =(Progress)s.get(Progress.class, id);
		s.close();
		return p;
		
	}

	public void addProgress(Progress p) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.getTransaction();
		s.save(p);
		tx.commit();
		s.close();
	}

	public void deleteProgress(int progressId) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.getTransaction();
		Progress p = (Progress)s.get(Progress.class, progressId);
		s.delete(p);
		tx.commit();
		s.close();
		
	}

	public void changeProgressNumCorrect(int progressId, int numCorrect) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.getTransaction();
		Progress p = (Progress) s.get(Progress.class, progressId);
		p.setNumCorrect(numCorrect);
		s.update("Progress",p);
		tx.commit();
		s.close();
		
		
	}
	public void changeProgressTag(int progressId, Tag tag) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.getTransaction();
		Progress p = (Progress) s.get(Progress.class, progressId);
		p.setTag(tag);
		s.update("Progress",p);
		tx.commit();
		s.close();
		
		
	}
	public void changeProgressTotal(int progressId, int total) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.getTransaction();
		Progress p = (Progress) s.get(Progress.class, progressId);
		p.setTotal(total);
		s.update("Progress",p);
		tx.commit();
		s.close();
		
		
	}

	@Override
	public Progress getProgress(int tagId, String userId) {
		Session s =HibernateUtil.getSession();
		Progress progress = null;
		Query q =s.createQuery("from Progress where User_Id =:param1");
		q.setParameter("param1", userId);
		Tag tag = (Tag)s.get(Tag.class, tagId);
		System.out.println(q.list());
		List<Progress> usersProgresses = q.list();
		for(Progress p: usersProgresses) {
			if(p.getTag()==tag) {
				System.out.println(p.getNumCorrect());
				progress = p;
			}
		}
		s.close();
		return progress;
	}
}