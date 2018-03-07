package com.revature.controllers;

import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.beans.Flashcard;
import com.revature.beans.Group;
import com.revature.beans.Progress;
import com.revature.messages.FlashcardAdded;
import com.revature.messages.GroupMessage;
import com.revature.messages.ProgressAdded;
import com.revature.messages.TagAdded;
import com.revature.messages.UserAdded;
import com.revature.messages.UserValidation;
import com.revature.services.GroupsService;
import com.revature.services.UsersService;

@Controller("userController")
@RequestMapping("/user")
@CrossOrigin(origins="http://localhost:4200")
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
	@RequestMapping(value="progress/{id}",method=RequestMethod.GET)
	public ResponseEntity<Collection<Progress>> getUserProgresses(@PathVariable("id") String userId){
		return new ResponseEntity<>(userService.getUsersProgresses(userId), HttpStatus.OK);
	}
	@RequestMapping(value="progress",method=RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Progress> getUserProgress(@RequestBody String jsonString){
		JSONObject json = new JSONObject(jsonString);
		String tagName = json.getString("tagName");
		String userId = json.getString("UserId");
		return new ResponseEntity<>(userService.getProgress(tagName, userId), HttpStatus.OK);
	}
	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
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
	@RequestMapping(value = "/addFlashcard", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<FlashcardAdded> addFlashcard(@RequestBody String jsonString){
		JSONObject json = new JSONObject(jsonString);
		String userId = json.getString("userId");
		String question= json.getString("question");
		String answer = json.getString("answer");
		String hint = json.getString("hint");
		int tagId = json.getInt("tagId");
		userService.addFlashcard(userId, question, answer, hint, tagId);
		return new ResponseEntity<>(new FlashcardAdded(true), HttpStatus.OK);
	}
	@RequestMapping(value = "/addTag", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<TagAdded> addTag(@RequestBody String jsonString){
		JSONObject json = new JSONObject(jsonString);
		String tag = json.getString("tag");
		return new ResponseEntity<>(new TagAdded(userService.addTag(tag)), HttpStatus.OK);
	}
	@RequestMapping(value = "/addProgress", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<ProgressAdded> addProgress(@RequestBody String jsonString){
		JSONObject json = new JSONObject(jsonString);
		int tagId = json.getInt("tagId");
		String userId = json.getString("userId");
		return new ResponseEntity<>(new ProgressAdded(userService.addProgress(userId, tagId)), HttpStatus.OK);
	}
}
