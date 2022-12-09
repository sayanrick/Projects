package com.ams.dto;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.ams.entity.Department;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AlumniDTO {	//data transfer object class

//	/**
//	 * @param alroll
//	 * @param alpassword
//	 * @param alname
//	 * @param aladdress
//	 * @param alphone
//	 * @param alemail
//	 * @param alpassyear
//	 */
//	public AlumniDTO(
//			@NotNull(message = "{alm.roll.null_Check}") @Digits(integer = 10, fraction = 0, message = "{alm.roll.digits_check}") @Positive(message = "{alm.roll.positive_check}") Long alroll,
//			@NotNull(message = "{alm.pass.null_Check}") @Size(min = 5, max = 10, message = "{alm.pass.size_check}") String alpassword,
//			@NotNull(message = "{alm.name.null_Check}") @Size(min = 3, max = 20, message = "{alm.name.size_check}") String alname,
//			@NotNull(message = "{alm.address.null_Check}") @Size(min = 8, max = 30, message = "{alm.address.size_check}") String aladdress,
//			@NotNull(message = "{alm.phone.null_Check}") @Digits(integer = 10, fraction = 0, message = "{alm.phone.digits_check}") @Positive(message = "{alm.phone.positive_check}") Long alphone,
//			@NotNull(message = "{alm.email.null_Check}") @Size(min = 11, max = 25, message = "{alm.email.size_check}") @Email(message = "{alm.email.pattern_check}") String alemail,
//			@NotNull(message = "{alm.yop.null_Check}") @Digits(integer = 4, fraction = 0, message = "{alm.yop.digits_check}") @Positive(message = "{alm.yop.positive_check}") Integer alpassyear) {
//		this.alroll = alroll;
//		this.alpassword = alpassword;
//		this.alname = alname;
//		this.aladdress = aladdress;
//		this.alphone = alphone;
//		this.alemail = alemail;
//		this.alpassyear = alpassyear;
//	}

	//roll no validation
	@NotNull(message="{alm.roll.null_Check}")
//	@Size(min=10, max=10, message="{alm.roll.size_check}")
	@Digits(integer = 10, fraction = 0, message="{alm.roll.digits_check}")
	@Positive(message="{alm.roll.positive_check}")
	private Long alroll;

	//password validation
	@NotNull(message="{alm.pass.null_Check}")
	@Size(min=5, max=10, message="{alm.pass.size_check}")
	private String alpassword;

	//name validation
	@NotNull(message="{alm.name.null_Check}")
	@Size(min=3, max=20, message="{alm.name.size_check}")
	private String alname;

	//address validation
	@NotNull(message="{alm.address.null_Check}")
	@Size(min=8, max=30, message="{alm.address.size_check}")
	private String aladdress;

	//phone validation
	@NotNull(message="{alm.phone.null_Check}")
//	@Size(min=10, max=10, message="{alm.phone.size_check}")
	@Digits(integer = 10, fraction = 0, message="{alm.phone.digits_check}")
	@Positive(message="{alm.phone.positive_check}")
	private Long alphone;

	//email validation
	@NotNull(message="{alm.email.null_Check}")
	@Size(min=11, max=25, message="{alm.email.size_check}")
	@Email(message = "{alm.email.pattern_check}")
	private String alemail;

	//YOP validation
	@NotNull(message="{alm.yop.null_Check}")
//	@Size(max=4, message="{alm.yop.size_check}")
	@Digits(integer = 4, fraction = 0, message="{alm.yop.digits_check}")
	@Positive(message="{alm.yop.positive_check}")
	private Integer alpassyear;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "dept_id")
	private Department department;
}
