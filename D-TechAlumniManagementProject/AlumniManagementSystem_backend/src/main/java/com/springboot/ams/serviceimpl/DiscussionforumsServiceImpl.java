package com.springboot.ams.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.ams.entity.Discussionforums;
import com.springboot.ams.exception.EntityNotFoundException;
import com.springboot.ams.repository.DiscussionforumsRepository;
import com.springboot.ams.service.DiscussionforumsService;

@Service
public class DiscussionforumsServiceImpl implements DiscussionforumsService {

	@Autowired
	private DiscussionforumsRepository dfRepo;
	
	@Override
	public Discussionforums addDiscussion(Discussionforums df) {
		return dfRepo.save(df);
	}

	@Override
	public List<Discussionforums> fetchDiscussions() {
		return dfRepo.findAll();
	}

	@Override
	public Discussionforums fetchDiscussion(int dfno) {
		// TODO Auto-generated method stub
		return dfRepo.findById(dfno).orElseThrow(() -> new EntityNotFoundException("discussion is not exist"));
	}

	@Override
	public Discussionforums updateDiscussion(int dfno, Discussionforums newDiscussion) {
		// fetching df by id
		Discussionforums newDf = dfRepo.findById(dfno)
				.orElseThrow(() -> new EntityNotFoundException("discussion not exists"));

		// updating value
		newDf.setTopic(newDiscussion.getTopic());
		newDf.setDescription(newDiscussion.getDescription());
		
		// saving updated value
		dfRepo.save(newDf);
		// returning updated entity
		return newDf;
	}

	@Override
	public void deleteDiscussion(int dfno) {
		dfRepo.deleteById(dfno);
	}

}
