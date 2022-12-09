package com.ms.dto;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class MarksDto {

	//id validation
	@NotNull(message="{marks.mid.null_check}")
	@Digits(integer = 5, fraction = 0, message="{marks.mid.digits_check}")
	@Positive(message="{marks.mid.positive_check}")
	private int mid;
	
	@NotNull(message="{marks.eng.null_check}")
	@Digits(integer = 5, fraction = 0, message="{marks.eng.digits_check}")
	@Positive(message="{marks.eng.positive_check}")
	private int m_english;
	
	@NotNull(message="{marks.math.null_check}")
	@Digits(integer = 5, fraction = 0, message="{marks.math.digits_check}")
	@Positive(message="{marks.math.positive_check}")
	private int m_math;
	
	@NotNull(message="{marks.hindi.null_check}")
	@Digits(integer = 5, fraction = 0, message="{marks.hindi.digits_check}")
	@Positive(message="{marks.hindi.positive_check}")
	private int m_hindi;
	
	@NotNull(message="{marks.physics.null_check}")
	@Digits(integer = 5, fraction = 0, message="{marks.physics.digits_check}")
	@Positive(message="{marks.physics.positive_check}")
	private int m_physics;
	
	@NotNull(message="{marks.chemistry.null_check}")
	@Digits(integer = 5, fraction = 0, message="{marks.chemistry.digits_check}")
	@Positive(message="{marks.chemistry.positive_check}")
	private int m_chemistry;
	
	@NotNull(message="{marks.practical.null_check}")
	@Digits(integer = 5, fraction = 0, message="{marks.practical.digits_check}")
	@Positive(message="{marks.practical.positive_check}")
	private int m_practical;
	
}
