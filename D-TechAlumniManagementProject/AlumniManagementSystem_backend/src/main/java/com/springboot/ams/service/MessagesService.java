package com.springboot.ams.service;

import java.util.List;

import com.springboot.ams.entity.Messages;

public interface MessagesService {

	// creating
	Messages addMessages(Messages msgs);

	// fetching 
	List<Messages> fetchMessages();
}
