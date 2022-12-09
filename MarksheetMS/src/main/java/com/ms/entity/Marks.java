package com.ms.entity;




import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@Entity
public class Marks {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int mid;
	@Column(length = 3,nullable = false)
	private int m_english;
	@Column(length = 3,nullable = false)
	private int m_math;
	@Column(length = 3,nullable = false)
	private int m_hindi;
	@Column(length = 3,nullable = false)
	private int m_physics;
	@Column(length = 3,nullable = false)
	private int m_chemistry;
	@Column(length = 3,nullable = false)
	private int m_practical;
		
}
