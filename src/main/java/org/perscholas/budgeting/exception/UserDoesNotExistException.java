package org.perscholas.budgeting.exception;

/*UserDoesNotExistException class is an exception for when user does not exist in the database*/
@SuppressWarnings("serial")
public class UserDoesNotExistException extends Exception{
	
	/* constructor */
	public UserDoesNotExistException(String errorMessage)
	{
		super(errorMessage);
	}
	
	

}
