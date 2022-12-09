package com.springcrud.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Customer {	
	@Id
	private int uid;
	
	@Column(length = 30, nullable = false)
	@NotBlank(message = "please enter first name")
	private String ufname;
	
	@Column(length = 30, nullable = false)
	@NotBlank(message = "please enter last name")
	private String ulname;
	
	@Column(length = 30, nullable = false, unique = true)
	@NotBlank(message = "please enter email id")
	@Email
	private String uemail;
	
	@Column(length = 11, nullable = false, unique = true)
	@NotNull(message = "please enter phone number")
	private long uphone;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "customer", cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<Bookings> bookinglist;
}

