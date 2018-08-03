package com.matome.library.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import com.matome.library.constants.LibrarianConstansts;

@NamedQueries({
	@NamedQuery(
	name = LibrarianConstansts.NAME_GET_ALL_LIBRARIANS,
	query = LibrarianConstansts.QUERY_GET_ALL_LIBRARIANS
	)
})
@Entity
public class Librarian implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long librarianId;
	private String librarianName;

	public long getLibrarianId() {
		return librarianId;
	}

	public void setLibrarianId(long librarianId) {
		this.librarianId = librarianId;
	}

	public String getLibrarianName() {
		return librarianName;
	}

	public void setLibrarianName(String librarianName) {
		this.librarianName = librarianName;
	}
}
