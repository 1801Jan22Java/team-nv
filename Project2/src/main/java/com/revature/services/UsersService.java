package com.revature.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Service;

import com.revature.beans.Flashcard;
import com.revature.beans.Group;
import com.revature.beans.Users;
import com.revature.dao.GroupDaoImpl;
import com.revature.dao.UsersDaoImpl;
import com.revature.messages.GroupMessage;
import com.revature.messages.UserAdded;
import com.revature.messages.UserValidation;

@Service("userService")
public class UsersService {
static UsersDaoImpl udi = new UsersDaoImpl();
	
	public UserAdded addUser(String userId) {
		udi.addUser(new Users(userId));
		return new UserAdded(udi.getUser(userId) != null);
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
	
}
