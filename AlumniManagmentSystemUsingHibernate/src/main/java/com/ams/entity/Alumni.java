package com.ams.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Alumni {


	@Id
	@Column(name="alumni_roll", length=10, nullable=false, unique=true)
	private Long alroll;

	@Column(name="alumni_password", length = 10, nullable = false)
	private String alpassword;

	@Column(name="alumni_name", length = 20, nullable = false)
	private String alname;

	@Column(name="alumni_address", length = 30, nullable = false)
	private String aladdress;

	@Column(name="alumni_phone", length = 10, nullable = false)
	private Long alphone;

	@Column(name="alumni_email", length = 25, nullable = false, unique = true)
	private String alemail;

	@Column(name="alumni_passyear", length = 4, nullable = false)
	private Integer alpassyear;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "dept_id")
	private Department department;
}
