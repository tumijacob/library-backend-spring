package com.matome.library.services;

import java.util.Date;

import javax.persistence.NoResultException;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matome.library.model.Book;
import com.matome.library.model.Faculty;
import com.matome.library.model.Librarian;
import com.matome.library.model.Student;
import com.matome.library.model.User;

@Service
public class UserService {

	@Autowired
	private BookService bookService;
	@Autowired
	private LibrarianService librarianService;
	@Autowired
	private StudentService studentService;
	@Autowired
	private FacultyService facultyService;
	@Autowired
	private UserService userService;

	DateTime dateTime = new DateTime(new Date());

	public <T> void issueBooks(T entity, long bookId, long librarianId) {
		Book book = bookService.getBookById(bookId);
		Librarian librarian = librarianService.getLibrarianById(librarianId);
		Student student = new Student();
		Faculty faculty = new Faculty();

		if (book == null || librarian == null) {
			throw new NoResultException();
		}
		DateTime returndate = dateTime.plusDays(7);
		Date returnBookDate = returndate.toDate();
		book.setStatus("UNAVAILABLE");
		book.setReturnDate(returnBookDate);
		book.setLibrarian(librarian);
		bookService.updateBookDetails(book);

		if (entity instanceof Student) {
			student.setLibrarian(librarian);
			student.setBook(book);
			student.setId(((Student) entity).getId());
			student.setStudentName(((Student) entity).getStudentName());
			studentService.updateStudent(student.getId(), student);
		} else {
			faculty.setLibrarian(librarian);
			faculty.setBook(book);
			faculty.setId(((Faculty) entity).getId());
			faculty.setFacultyName(((Faculty) entity).getFacultyName());
			facultyService.updateFaculty(faculty.getId(), faculty);
			
		}

	}
	
	public User findUserByUsername(String username) {
		return userService.findUserByUsername(username); 
				
	}	

	public <T> void returnBooks(T user, long bookId) {
		Book book = bookService.getBookById(bookId);
		DateTime bookReturnDate = new DateTime(book.getReturnDate());

		if (user instanceof Student) {
			Student student = studentService.getStudentById(((Student) user).getId());
			if (student == null) {
				throw new NoResultException();
			}
			double amountFined = getAmountFined(bookReturnDate);
			student.setAmountFined(amountFined);	
			book.setStatus("AVAILABLE");
			bookService.updateBookDetails(book);
			studentService.updateStudent(student.getId(), student);
		} else {
			Faculty faculty = facultyService.getFacultyById(((Faculty) user).getId());
			if (faculty == null) {
				throw new NoResultException();
			}
			double amountFined = getAmountFined(bookReturnDate);
			faculty.setAmountFined(amountFined);
			book.setStatus("AVAILABLE");
			bookService.updateBookDetails(book);
			facultyService.updateFaculty(faculty.getId(), faculty);
		}
	}

	private double getAmountFined(DateTime bookReturnDate) {
		Double amountFined = 0.0;
		DateTime returnedDate = new DateTime(new Date());

		if (bookReturnDate.equals(returnedDate)) {
			amountFined = 0.0;
		}
		if (returnedDate.equals(bookReturnDate.plus(7))) {
			amountFined = 200.00;
		}
		if (returnedDate.isAfter(bookReturnDate.plus(7)) && returnedDate.isBefore(bookReturnDate.plus(14))) {
			amountFined = 400.00;
		}
		if (returnedDate.isAfter(bookReturnDate.plus(14)) && returnedDate.isBefore(bookReturnDate.plus(30))) {
			amountFined = 800.00;
		} else {
			amountFined = 2000.00;
		}
		return amountFined;
	}
	
	public <T> void payFine(double amount, T user, Date payFineDate) {
		if (user instanceof Student) {
			Student student = studentService.getStudentById(((Student) user).getId());
			
			if (student == null) {
			   throw new NoResultException();
			}
			
			if (student.getAmountFined() == amount) {
				student.setPayFineDate(payFineDate);
				student.setAmountFined(0.0);
				studentService.updateStudent(((Student) user).getId(), student);
			}
		}
		
		if (user instanceof Faculty) {
		  Faculty faculty = facultyService.getFacultyById(((Faculty) user).getId());
		  if (faculty == null) {
			  throw new NoResultException();
		  }
		  if (faculty.getAmountFined() == amount) {
			  faculty.setAmountFined(0.0);
			  faculty.setPayFineDate(payFineDate);
			  facultyService.updateFaculty(((Faculty) user).getId(), faculty);
		  }
		}
			
	}
}
