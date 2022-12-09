package com.ms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Students  {
    
	@Id
    @Column(length = 12,nullable = false)
	private int sroll;
	@Column(length = 10,nullable = false)
	private String password;
    @Column(length = 25,nullable = false)
	private String sname;
    @Column(length = 35,nullable = false)
	private String saddress;
    @Column(length = 12,nullable = false)
	private long scontact;
    @Column(length = 25,nullable = false)
	private String semail;
    @Column(length = 12,nullable = false)
    private String sDept;
  
    
    @OneToOne(targetEntity = Marks.class)
	@JoinColumn(name = "mid")
	private Marks marks;
    
    @OneToOne(targetEntity = StudentsIssues.class)
    @JoinColumn(name = "issueId")
    private StudentsIssues studentsissues;
       
}
