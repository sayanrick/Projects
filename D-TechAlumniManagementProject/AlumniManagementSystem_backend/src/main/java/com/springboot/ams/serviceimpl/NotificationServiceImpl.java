package com.springboot.ams.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.ams.entity.Notification;
import com.springboot.ams.repository.NotificationRepository;
import com.springboot.ams.service.NotificationService;

@Service
public class NotificationServiceImpl implements NotificationService {

	@Autowired
	private NotificationRepository noticeRepo;
	

	@Override
	public Notification addNotification(Notification notice) {
		return noticeRepo.save(notice);
	}

	@Override
	public List<Notification> fetchNotifications() {
		return noticeRepo.findAll();
	}

}
