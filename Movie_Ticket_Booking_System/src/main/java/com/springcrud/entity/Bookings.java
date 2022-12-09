package com.springcrud.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;
@Entity
@Data
@Table(name="booking_details")
public class Bookings {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int bid;
	@Column(length = 30, nullable = false)
	@NotBlank(message = "Movie name cannot be blank")
	private String movieName;
	@Column(length = 10, nullable = false)
	@NotBlank(message = "Movie date cannot be blank")
	private String movieDate;
	@Column(length = 3, nullable = false)
	@NotNull(message = "Movie date cannot be blank")
	private int movieTime;
	@Column(length = 5, nullable = false)
	@NotNull(message = "No of person Cannot be blank")
	private int noOfPerson;
	@Column(length = 30, nullable = false)
	@NotNull(message = "Price Cannot be blank")
	private double totalPrice;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="customerid", referencedColumnName = "uid")
	@JsonBackReference
	private Customer customer;

}

