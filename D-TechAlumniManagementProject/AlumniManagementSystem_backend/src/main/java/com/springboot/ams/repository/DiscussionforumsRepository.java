package com.springboot.ams.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.ams.entity.Discussionforums;

@Repository
public interface DiscussionforumsRepository extends JpaRepository<Discussionforums, Integer> {

}
