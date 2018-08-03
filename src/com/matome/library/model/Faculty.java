package com.matome.library.model;

import javax.persistence.Entity;

@Entity
public class Faculty extends User  {

	private static final long serialVersionUID = 1L;
	private String facultyName;
	
	public String getFacultyName() {
		return this.facultyName;
	}
	
	public void setFacultyName(String facultyName) {
		this.facultyName = facultyName;
	}
}
