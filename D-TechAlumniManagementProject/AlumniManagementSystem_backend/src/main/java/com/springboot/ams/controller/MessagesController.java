package com.springboot.ams.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.ams.entity.Messages;
import com.springboot.ams.service.MessagesService;

@RestController
@CrossOrigin
public class MessagesController {

	@Autowired
	private MessagesService msgService;

	// create
	@PostMapping("/messages/addMessages")
	public ResponseEntity<Messages> addMessages(@Valid @RequestBody Messages msg) {

		return new ResponseEntity<Messages>(msgService.addMessages(msg), HttpStatus.CREATED);
	}
	
	// fetching all
	@GetMapping("/messages/fetchMessages")
	public ResponseEntity<List<Messages>> fetchMessages() {
		return new ResponseEntity<List<Messages>>(msgService.fetchMessages(), HttpStatus.OK);
	}
}
