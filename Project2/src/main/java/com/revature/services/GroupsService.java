package com.revature.services;

import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Service;

import com.revature.beans.*;
import com.revature.dao.GroupDaoImpl;
import com.revature.messages.GroupMessage;

@Service("groupService")
public class GroupsService {
	
	static GroupDaoImpl gdi = new GroupDaoImpl();
	
	public Collection<Group> getAllGroups(){
		return gdi.getAllGroups();
	}
	public GroupMessage getGroupById(int groupId){
		return new GroupMessage(gdi.getGroupById(groupId));
	}
}
