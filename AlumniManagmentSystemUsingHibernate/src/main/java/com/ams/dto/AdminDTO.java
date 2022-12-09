package com.ams.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdminDTO {		//data transfer object class	

	//username validation
	@NotNull(message="{admin.username.null_Check}")
	@Size(min=5, max=15, message="{admin.username.size_check}")
	private String adusername;
	
	//password validation
	@NotNull(message="{admin.pass.null_Check}")
	@Size(min=5, max=10, message="{admin.pass.size_check}")
	private String adpassword;
	
	//name validation
	@NotNull(message="{admin.name.null_Check}")
	@Size(min=3, max=30, message="{admin.name.size_check}")
	private String adname;
	
	//email validation
	@NotNull(message="{admin.email.null_Check}")
	@Size(min=11, max=25, message="{admin.email.size_check}")
	@Email(message = "{admin.email.pattern_check}")
	private String ademail;
	
}
