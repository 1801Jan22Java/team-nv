package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import beans.Progress;
import beans.Tag;
import util.HibernateUtil;

public class ProgressDaoImpl {

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
}
