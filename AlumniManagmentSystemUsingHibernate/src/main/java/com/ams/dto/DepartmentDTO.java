package com.ams.dto;

import java.util.List;

import javax.persistence.OneToMany;

import com.ams.entity.Alumni;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class DepartmentDTO {		//data transfer object class	

	/**
	 * @param dname
	 * @param dhead
	 */
	public DepartmentDTO(
			@NotNull(message = "{dept.name.null_check}") @Size(min = 3, max = 20, message = "{dept.name.size_check}") String dname,
			@NotNull(message = "{dept.head.null_check}") @Size(min = 3, max = 30, message = "{dept.head.size_check}") String dhead) {
		this.dname = dname;
		this.dhead = dhead;
	}
	
	@NotNull(message="{dept.id.null_check}")
//	@Size(min=1, max=3, message="{dept.id.size_check}")
	@Digits(integer = 3, fraction = 0, message="{dept.id.digits_check}")
	@Positive(message="{dept.id.positive_check}")
	private Integer did;
	
	@NotNull(message="{dept.name.null_check}")
	@Size(min=3, max=20, message="{dept.name.size_check}")
	private String dname;
	
	@NotNull(message="{dept.head.null_check}")
	@Size(min=3, max=30, message="{dept.head.size_check}")
	private String dhead;
	
	@OneToMany(mappedBy="department")
	private List<Alumni> alumni;

}
