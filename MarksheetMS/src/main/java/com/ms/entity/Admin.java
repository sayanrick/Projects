package com.ms.entity;


import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Admin  {
	
	@Id
	@Column(length = 10,nullable = false)
	private int loginid;
	@Column(length = 10,nullable = false)
	private String password;
	@Column(length = 30,nullable = false)
	private String email;
	@Column(length = 30,nullable = false)
	private String aname;	
}
