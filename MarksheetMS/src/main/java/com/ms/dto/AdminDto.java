package com.ms.dto;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdminDto {

	// username validation
	@NotNull(message = "{admin.username.null_Check}")
	@Digits(integer = 10, fraction = 0, message="{admin.roll.digits_check}")
	private int loginid;
	
	//password validation
	@NotNull(message="{admin.pass.null_Check}")
	@Size(min=5, max=10, message="{admin.pass.size_check}")
	private String password;
	
	//email validation
	@NotNull(message="{admin.email.null_Check}")
	@Size(min=10, max=30, message="{admin.email.size_check}")
	@Email(message = "{admin.email.pattern_check}")
	private String email;
	
	//name validation
	@NotNull(message="{admin.name.null_Check}")
	@Size(min=3, max=25, message="{admin.name.size_check}")
	private String aname;

}
