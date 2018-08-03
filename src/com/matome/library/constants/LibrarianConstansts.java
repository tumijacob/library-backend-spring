package com.matome.library.constants;

public class LibrarianConstansts {
	
	public static final String NAME_GET_ALL_LIBRARIANS =
			"librarian.getAllLibrarians";
	public static final String QUERY_GET_ALL_LIBRARIANS = 
			 "SELECT l "
		   + "FROM Librarian l ";
	public static final String NAME_FIND_LIBRARIAN_BY_ID =
			 "librarian.findLibrarianById";
	public static final String QUERY_FIND_LIBRARIAN_BY_ID =
	         "SELECT l "
			 + "FROM Librarian l "
			 + "WHERE l.librarianId = : librarianId ";
	public static final String NAME_FIND_LIBRARIAN_BY_NAME =
			  "librarian.findLibrarianByName";
	public static final String QUERY_FIND_LIBRARIAN_BY_NAME =
			  "SELECT l "
			  + "FROM Librarian l "
			  + "WHERE l.librarianName = :librarianName ";
			

}
