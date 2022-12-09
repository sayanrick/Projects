package com.ams.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Department {

	@Id
	@Column(name="dept_id", length=3, nullable=false, unique=true)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int did;
	
	@Column(name="dept_name", length = 20, nullable = false)
	private String dname;
	
	@Column(name="dept_head", length = 30, nullable = false)
	private String dhead;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="department")
	private List<Alumni> alumni;
	
}
