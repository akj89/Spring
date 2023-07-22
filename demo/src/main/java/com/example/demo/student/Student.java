package com.example.demo.student;

import java.time.LocalDate;
import java.time.Period;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;


@Entity @Table
public class Student {
	
	@Id
	
	@SequenceGenerator(
		name = "student_sequence",
		sequenceName = "student_sequence",
		allocationSize = 1
	)
	
	@GeneratedValue(
		strategy = GenerationType.SEQUENCE,
		generator = "student_sequence"
	)
	
	private long m_id;
	private String m_name;
	private LocalDate m_dob;
	private String m_emailId;
	@Transient
	private int m_age;
	
	public Student()
	{}
	
	public Student(long m_id, String m_name, LocalDate m_dob, String m_emailId) {
		super();
		this.m_id = m_id;
		this.m_name = m_name;
		this.m_dob = m_dob;
		this.m_emailId = m_emailId;
	}
	
	public Student( String m_name, LocalDate m_dob, String m_emailId) {
		this.m_name = m_name;
		this.m_dob = m_dob;
		this.m_emailId = m_emailId;
	}

	@Override
	public String toString() {
		return "Student [m_id=" + m_id + ", m_name=" + m_name + ", m_dob=" + m_dob + ", m_emailId=" + m_emailId
				+ ", m_age=" + m_age + "]";
	}

	public long getId() {
		return m_id;
	}

	public void setId(long m_id) {
		this.m_id = m_id;
	}

	public String getName() {
		return m_name;
	}

	public void setName(String m_name) {
		this.m_name = m_name;
	}

	public LocalDate getDob() {
		return m_dob;
	}

	public void setDob(LocalDate m_dob) {
		this.m_dob = m_dob;
	}

	public String getEmailId() {
		return m_emailId;
	}

	public void setEmailId(String m_emailId) {
		this.m_emailId = m_emailId;
	}

	public int getAge() {
		return Period.between(m_dob, LocalDate.now()).getYears();
	}

	public void setAge(int m_age) {
		this.m_age = m_age;
	}
	
	
}
