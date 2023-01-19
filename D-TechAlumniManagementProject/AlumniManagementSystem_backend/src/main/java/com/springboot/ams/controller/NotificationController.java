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

import com.springboot.ams.entity.Notification;
import com.springboot.ams.service.NotificationService;

@RestController
@CrossOrigin
public class NotificationController {

	@Autowired
	private NotificationService noticeService;

	// create
	@PostMapping("/notification/addNotification")
	public ResponseEntity<Notification> addNotification(@Valid @RequestBody  Notification notice) {

		return new ResponseEntity<Notification>(noticeService.addNotification(notice), HttpStatus.CREATED);
	}
	
	// fetching all
	@GetMapping("/notification/fetchNotifications")
	public ResponseEntity<List<Notification>> fetchNotifications() {
		return new ResponseEntity<List<Notification>>(noticeService.fetchNotifications(), HttpStatus.OK);
	}
}
