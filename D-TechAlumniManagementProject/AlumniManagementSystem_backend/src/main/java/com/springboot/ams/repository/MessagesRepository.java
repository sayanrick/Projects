package com.springboot.ams.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.ams.entity.Messages;

public interface MessagesRepository extends JpaRepository<Messages ,Integer> {

}
