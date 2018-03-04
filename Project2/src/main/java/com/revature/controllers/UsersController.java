package com.revature.controllers;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.beans.Flashcard;
import com.revature.beans.Group;
import com.revature.messages.GroupMessage;
import com.revature.messages.UserAdded;
import com.revature.messages.UserValidation;
import com.revature.services.GroupsService;
import com.revature.services.UsersService;

@Controller("userController")
@RequestMapping("/user")
public class UsersController {
	@Autowired
	private UsersService userService;
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public ResponseEntity<UserValidation> getUserById(@PathVariable("id") String userId){
		return new ResponseEntity<>(userService.validateUser(userId), HttpStatus.OK);
	}
	@RequestMapping(value="flashcard/{id}",method=RequestMethod.GET)
	public ResponseEntity<Collection<Flashcard>> getUserFlashcards(@PathVariable("id") String userId){
		return new ResponseEntity<>(userService.getUsersFlashcards(userId), HttpStatus.OK);
	}
	@RequestMapping(value="group/{id}",method=RequestMethod.GET)
	public ResponseEntity<Collection<GroupMessage>> getUserGroups(@PathVariable("id") String userId){
		return new ResponseEntity<>(userService.getUsersGroups(userId), HttpStatus.OK);
	}
	@PostMapping("/addUser")
	@ResponseBody
	public ResponseEntity<UserAdded> addUser(@RequestBody String userId){
		if(userService.validateUser(userId).getIsValidated()) {
			return new ResponseEntity<>(null, HttpStatus.OK);
		}
		else {
			System.out.println(userId);
			return new ResponseEntity<>(userService.addUser(userId), HttpStatus.OK);
		}
		
	}
	
}
