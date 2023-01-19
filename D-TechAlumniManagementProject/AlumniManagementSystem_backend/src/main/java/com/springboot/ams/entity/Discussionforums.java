package com.springboot.ams.entity;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Discussionforums {
	
	@Id
	@Column(name = "dfno", length = 3, nullable = false, unique = true)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int dfno;

	@Column(name = "topic", length = 25, nullable = false)
	@Size(min = 2, max = 25, message = "{topic.size_check}")
	private String topic;

	@Column(name = "description", length = 100, nullable = false)
	@Size(min = 5, max = 100, message = "{description.size_check}")
	private String description;
	
	@Column(name = "createdBy", length = 20, nullable = false)
	@Size(min = 5, max = 20, message = "{createdBy.size_check}")
	private String createdBy;
	
	@Column(name = "createdAt", updatable = false)
	private Timestamp createdAt = new Timestamp(System.currentTimeMillis());

	@JoinColumn(name = "message_id")
	@OneToMany(cascade = CascadeType.ALL)
	private List<Messages> messages;

}
