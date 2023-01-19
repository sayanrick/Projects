package com.springboot.ams.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.ams.entity.Messages;
import com.springboot.ams.repository.MessagesRepository;
import com.springboot.ams.service.MessagesService;

@Service
public class MessagesServiceImpl implements MessagesService {

	@Autowired
	private MessagesRepository msgRepo;
	
	@Override
	public Messages addMessages(Messages msgs) {
		return msgRepo.save(msgs);
	}

	@Override
	public List<Messages> fetchMessages() {
		// TODO Auto-generated method stub
		return msgRepo.findAll();
	}

}
