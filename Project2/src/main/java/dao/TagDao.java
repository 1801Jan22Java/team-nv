package dao;

import java.util.List;

import beans.Progress;
import beans.Tag;

public interface TagDao {
	public List<Tag> getAllTags();
	
	public List<Tag> getProgressByEmployeeId(String EmploeeId);

	public Tag getProgressById(int id);

	public void addTag(Tag t);
	
	public void deleteTag(int tagId);
	
	public int changeTag(int tagId, String tagName);
}

