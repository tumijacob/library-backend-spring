package com.matome.library.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import com.matome.library.model.User;

@Entity
public class Student extends User implements Serializable {
	private static final long serialVersionUID = 1L;

	private String studentName;
	
	public String getStudentName() {
		return this.studentName;
	}
	
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
}
