package com.revature.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Service;

import com.revature.beans.Flashcard;
import com.revature.beans.Group;
import com.revature.beans.Progress;
import com.revature.beans.Tag;
import com.revature.beans.Users;
import com.revature.dao.FlashcardDaoImpl;
import com.revature.dao.ProgressDaoImpl;
import com.revature.dao.TagDaoImpl;
import com.revature.dao.UsersDaoImpl;
import com.revature.messages.FlashcardAdded;
import com.revature.messages.GroupMessage;
import com.revature.messages.UserAdded;
import com.revature.messages.UserValidation;

@Service("userService")
public class UsersService {

static TagDaoImpl tdi = new TagDaoImpl();	
static UsersDaoImpl udi = new UsersDaoImpl();
static FlashcardDaoImpl fcdi = new FlashcardDaoImpl();
static ProgressDaoImpl pdi = new ProgressDaoImpl();
	
	public UserAdded addUser(String userId) {
		udi.addUser(new Users(userId));
		return new UserAdded(udi.getUser(userId) != null);
	}
	public FlashcardAdded addFlashcard(String userId, String question, String answer, String hint, int tagId) {
		udi.getUser(userId).getFlashcards().add(new Flashcard(question, answer, hint, tdi.getTag(tagId)));
		return new FlashcardAdded( true);
	}
	public Users getUser(String userId) {
		//udi.addUser(userId);
		return udi.getUser(userId);
	}
	public UserValidation validateUser(String userId){
		return new UserValidation(udi.getUser(userId)!=null);
	}
	public Collection<Flashcard> getUsersFlashcards(String userId)
	{
		return udi.getUsersFlashcards(userId);
	}
	public Collection<GroupMessage> getUsersGroups(String userId)
	{
		ArrayList<GroupMessage> usersGroups = new ArrayList<GroupMessage>();
		for(Group g :udi.getUsersGroups(userId))
		{
			usersGroups.add(new GroupMessage(g));
		}
		return usersGroups;
	}
	public Progress getProgress(int tagId, String userId) {
		return pdi.getProgress(tagId, userId);
	}
	public boolean addTag(String tag) {
		for(Tag t : tdi.getAllTags()) {
			if(t.getTagName().equals(tag))
			{
				return false;
			}
		}
		tdi.addTag(new Tag(tag));
		return true;
	}
}
