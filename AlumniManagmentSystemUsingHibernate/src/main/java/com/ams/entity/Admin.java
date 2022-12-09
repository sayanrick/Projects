package com.ams.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Admin {
	
	@Id
	@Column(name="admin_username", length= 15, nullable=false, unique=true)
	private String adusername;
	
	@Column(name = "admin_password", length = 10, nullable = false)
	private String adpassword;
	
	@Column(name = "admin_name", length = 30, nullable = false)
	private String adname;
	
	@Column(name = "admin_email", length = 25, nullable = false, unique = true)
	private String ademail;

	
}
