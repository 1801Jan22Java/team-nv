package dao;

import java.util.List;

import beans.Progress;
import beans.Tag;

public interface TagDao {
	public List<Tag> getAllTags();
	
	public List<Progress> getProgressByEmployeeId(String EmploeeId);

	public Progress getProgressById(int id);

	public void addProgress(Progress p);
	
	public void deleteProgress(int progressId);
}

