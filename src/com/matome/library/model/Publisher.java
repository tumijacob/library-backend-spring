package com.matome.library.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Publisher implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long publisherId;
	private String publicationName;
	private String publisherAddress;
	private int publisherNumber;
	private int yearOfPublication;

	@ManyToOne
	private Librarian librarian_id;

	public long getPublisherId() {
		return publisherId;
	}

	public void setPublisherId(long publisherId) {
		this.publisherId = publisherId;
	}

	public String getPublicationName() {
		return publicationName;
	}

	public void setPublicationName(String publicationName) {
		this.publicationName = publicationName;
	}

	public String getPublisherAddress() {
		return publisherAddress;
	}

	public void setPublisherAddress(String publisherAddress) {
		this.publisherAddress = publisherAddress;
	}

	public int getPublisherNumber() {
		return publisherNumber;
	}

	public void setPublisherNumber(int publisherNumber) {
		this.publisherNumber = publisherNumber;
	}

	public Librarian getLibrarian_id() {
		return librarian_id;
	}

	public void setLibrarian_id(Librarian librarian_id) {
		this.librarian_id = librarian_id;
	}

	public int getYearOfPublication() {
		return yearOfPublication;
	}

	public void setYearOfPublication(int yearOfPublication) {
		this.yearOfPublication = yearOfPublication;
	}
}
