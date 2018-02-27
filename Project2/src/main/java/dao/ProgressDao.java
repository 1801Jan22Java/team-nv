package dao;

import java.util.List;

import beans.Progress;

public interface ProgressDao {
	public List<Progress> getAllProgress();
	
	public List<Progress> getProgressByEmployeeId(String EmploeeId);

	public Progress getProgressById(int id);

	public void addProgress(Progress p);
	
	public void deleteProgress(int progressId);
}
