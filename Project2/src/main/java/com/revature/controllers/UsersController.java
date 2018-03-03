package com.revature.controllers;

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

import com.revature.messages.GroupMessage;
import com.revature.messages.UserAdded;
import com.revature.messages.UserValidation;
import com.revature.services.GroupsService;
import com.revature.services.UsersService;

@Controller("groupController")
@RequestMapping("/user")
public class UsersController {
	@Autowired
	private UsersService userService;
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public ResponseEntity<UserValidation> getGroupById(@PathVariable("id") String userId){
		return new ResponseEntity<>(userService.validateUser(userId), HttpStatus.OK);
	}
	@PostMapping("/addUser")
	@ResponseBody
	public ResponseEntity<UserAdded> addGroup(@RequestBody String userId){
		return new ResponseEntity<>(userService.addUser(userId), HttpStatus.OK);
	}
}
