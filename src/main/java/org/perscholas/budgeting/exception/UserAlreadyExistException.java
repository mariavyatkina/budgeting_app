package org.perscholas.budgeting.exception;

/*UserAlreadyExistException class is an exception for when user already exists in the database*/
@SuppressWarnings("serial")
public class UserAlreadyExistException extends Exception {
	
	/* constructor */
	 public UserAlreadyExistException(String errorMessage) {
	        super(errorMessage);
	    }

}
