package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import beans.Progress;
import beans.Tag;
import util.HibernateUtil;

public interface ProgressDao {
	public List<Progress> getAllProgress();
	
	//public List<Progress> getProgressByEmployeeId(String EmploeeId);

	public Progress getProgressById(int id);

	public void addProgress(Progress p);
	
	public void deleteProgress(int progressId);
	
	public void changeProgressNumCorrect(int progressId, int numCorrect);
	public void changeProgressTag(int progressId, Tag tag);
	public void changeProgressTotal(int progressId, int total);
	
}
