package com.revature.controllers;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.beans.Group;
import com.revature.messages.GroupMessage;
import com.revature.services.GroupsService;

@Controller("userController")
@RequestMapping("/group")
public class GroupController {
	@Autowired
	private GroupsService groupService;
	@GetMapping("/all")
	@ResponseBody
	public ResponseEntity<Collection<GroupMessage>> getAllGroupes() {
		return new ResponseEntity<>(groupService.getAllGroups(), HttpStatus.OK);
	}
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public ResponseEntity<GroupMessage> getGroupById(@PathVariable("id") int groupId){
		return new ResponseEntity<>(groupService.getGroupById(groupId), HttpStatus.OK);
	}
}
