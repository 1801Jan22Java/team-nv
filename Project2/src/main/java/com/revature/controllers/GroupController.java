package com.revature.controllers;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.beans.Flashcard;
import com.revature.beans.Group;
import com.revature.messages.GroupAdded;
import com.revature.messages.GroupMessage;
import com.revature.messages.UserAdded;
import com.revature.services.GroupsService;
import com.revature.services.UsersService;

@Controller("groupController")
@RequestMapping("/group")
@CrossOrigin(origins="http://localhost:4200")
public class GroupController {
	@Autowired
	private GroupsService groupService;
	@Autowired
	private UsersService userService;
	@GetMapping("/all")
	@ResponseBody
	public ResponseEntity<Collection<GroupMessage>> getAllGroupes() {
		return new ResponseEntity<>(groupService.getAllGroups(), HttpStatus.OK);
	}
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public ResponseEntity<GroupMessage> getGroupById(@PathVariable("id") int groupId){
		return new ResponseEntity<>(groupService.getGroupById(groupId), HttpStatus.OK);
	}
	@RequestMapping(value="flashcard/{id}",method=RequestMethod.GET)
	public ResponseEntity<Collection<Flashcard>> getGroupsFlashcards(@PathVariable("id") int groupId){
		return new ResponseEntity<>(groupService.getgroupFlashcards(groupId), HttpStatus.OK);
	}
	@RequestMapping(value="pendingflashcard/{id}",method=RequestMethod.GET)
	public ResponseEntity<Collection<Flashcard>> getGroupsPendingFlashcards(@PathVariable("id") int groupId){
		return new ResponseEntity<>(groupService.getgroupPendingFlashcards(groupId), HttpStatus.OK);
	}
	@PostMapping("/addGroup")
	@ResponseBody
	public ResponseEntity<GroupAdded> addGroup(@RequestBody String groupName,@RequestBody String groupDescription,@RequestBody String leaderId){
		return new ResponseEntity<>(groupService.addGroup(new Group(groupName,groupDescription, userService.getUser(leaderId))), HttpStatus.OK);
	}
}

