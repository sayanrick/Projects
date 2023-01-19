package com.springboot.ams.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Messages {
	
	@Id
	@Column(name = "dmno", length = 3, nullable = false, unique = true)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Digits(integer = 3, fraction = 0, message = "{dmno.digits_check}")
	@Positive(message = "{dmno.positive_check}")
	private Integer dmno;

	@Column(name = "name", length = 25, nullable = false)
	@Size(min = 2, max = 25, message = "{name.size_check}")
	private String name;

	@Column(name = "description", length = 100, nullable = false)
	@Size(min = 5, max = 100, message = "{description.size_check}")
	private String description;
	
	@Column(name = "createdAt", updatable = false)
	private Timestamp createdAt = new Timestamp(System.currentTimeMillis());
}
