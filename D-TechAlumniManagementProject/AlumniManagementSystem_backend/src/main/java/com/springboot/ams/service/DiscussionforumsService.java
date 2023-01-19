package com.springboot.ams.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springboot.ams.entity.Discussionforums;

@Service
public interface DiscussionforumsService {

	
	// creating
	Discussionforums addDiscussion(Discussionforums df);
	
	// fetching all
	List<Discussionforums> fetchDiscussions();
	
	// fetching
	Discussionforums fetchDiscussion(int dfno);
	
	// update
	Discussionforums updateDiscussion(int dfno, Discussionforums newDiscussion);
	
	// delete
	void deleteDiscussion(int dfno);
}
