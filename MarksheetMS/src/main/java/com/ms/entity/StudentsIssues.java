package com.ms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class StudentsIssues {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int iid;
	@Column(length = 150)
	private String issue;
}
