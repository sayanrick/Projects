package com.springboot.ams.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.ams.entity.Discussionforums;
import com.springboot.ams.service.DiscussionforumsService;

@RestController
@CrossOrigin
public class DiscussionforumsController {

	@Autowired
	private DiscussionforumsService dfService;
	
	// create
	@PostMapping("/discussionforums/addDiscussion")
	public ResponseEntity<Discussionforums> addDiscussion(@Valid @RequestBody Discussionforums df) {

		return new ResponseEntity<Discussionforums>(dfService.addDiscussion(df), HttpStatus.CREATED);
	}
	
	// fetching all
	@GetMapping("/discussionforums/fetchDiscussions")
	public ResponseEntity<List<Discussionforums>> fetchDiscussions() {
		return new ResponseEntity<List<Discussionforums>>(dfService.fetchDiscussions(), HttpStatus.OK);
	}

	// fetching
	@GetMapping("/discussionforums/fetchDiscussion/{dfno}")
	public ResponseEntity<Discussionforums> fetchDiscussion(@PathVariable int dfno) {
		return new ResponseEntity<Discussionforums>(dfService.fetchDiscussion(dfno), HttpStatus.OK);
	}
	
	// update
	@PutMapping("/discussionforums/updateDiscussion/{dfno}")
	public ResponseEntity<Discussionforums> updateDiscussion(@PathVariable int dfno, @RequestBody Discussionforums df) {
		return new ResponseEntity<Discussionforums>(dfService.updateDiscussion(dfno, df), HttpStatus.OK);
	}
	
	// delete 
	@DeleteMapping("/discussionforums/deleteDiscussion/{dfno}")
	public ResponseEntity<HttpStatus> deleteDiscussion(@PathVariable int dfno) {
		dfService.deleteDiscussion(dfno);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}
	
}
