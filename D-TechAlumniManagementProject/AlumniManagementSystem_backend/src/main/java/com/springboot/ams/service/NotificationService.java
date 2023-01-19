package com.springboot.ams.service;

import java.util.List;

import com.springboot.ams.entity.Notification;

public interface NotificationService {

	// creating
	Notification addNotification(Notification notice);

	// fetching 
	List<Notification> fetchNotifications();
}
