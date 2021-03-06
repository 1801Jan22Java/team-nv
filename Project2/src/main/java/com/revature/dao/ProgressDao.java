package com.revature.dao;

import java.util.List;

import com.revature.beans.Progress;
import com.revature.beans.Tag;

public interface ProgressDao {
public List<Progress> getAllProgress();
	
	//public List<Progress> getProgressByEmployeeId(String EmploeeId);

	public Progress getProgressById(int id);

	public void addProgress(Progress p);
	public void deleteProgress(int progressId);
	public boolean updateProgress(Progress p, boolean isCorrect);
	public void changeProgressNumCorrect(int progressId, int numCorrect);
	public void changeProgressTag(int progressId, Tag tag);
	public void changeProgressTotal(int progressId, int total);
	public Progress getProgress(int tagId, String userId);
	public Progress getProgress(String tagName, String userId);
	public List<Progress> getProgressByUserId(String userId);
}

