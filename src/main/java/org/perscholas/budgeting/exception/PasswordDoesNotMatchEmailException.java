package org.perscholas.budgeting.exception;
/*PasswordDoesNotMatchEmailException class is an exception for 
 * when entered password and email of the user do not match those in the database*/
@SuppressWarnings("serial")
public class PasswordDoesNotMatchEmailException extends Exception {
	
	/* constructor */
	public PasswordDoesNotMatchEmailException(String errorMessage)
	{
		super(errorMessage);
	}

}
