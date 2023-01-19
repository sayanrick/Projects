package com.springboot.ams.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Notification {
	
	@Id
	@Column(name = "notice_no", length = 3, nullable = false, unique = true)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int notice_no;
	
	@Column(name = "heading", length = 25, nullable = false)
	@Size(min = 2, max = 25, message = "{name.size_check}")
	private String heading;
	
	@NotNull
	@Column(name = "description", length = 100, nullable = false)
	@Size(min = 5, max = 100, message = "{description.size_check}")
	private String description;
	
	@Column(name = "createdAt", updatable = false)
	private Timestamp createdAt = new Timestamp(System.currentTimeMillis());

}
