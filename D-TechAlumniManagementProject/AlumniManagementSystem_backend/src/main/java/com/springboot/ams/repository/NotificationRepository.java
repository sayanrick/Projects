package com.springboot.ams.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.ams.entity.Notification;

public interface NotificationRepository extends JpaRepository<Notification ,Integer> {

}
