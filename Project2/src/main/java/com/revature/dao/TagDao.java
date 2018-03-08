package com.revature.dao;

import java.util.List;

import com.revature.beans.Progress;
import com.revature.beans.Tag;

public interface TagDao {
	public List<Tag> getAllTags();

	public void addTag(Tag t);
	
	public Tag getTag(int tagId);
	
	public void deleteTag(int tagId);
	
	public int changeTag(int tagId, String tagName);
	
	public Tag getTag(String tagName);
}

