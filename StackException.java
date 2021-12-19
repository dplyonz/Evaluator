package edu.ualbany.Project_3;

/**
 * Defines subclass of java.lang.RuntimeException
 * @author Derren Lyons
 * @version 1.0
 */
public class StackException extends java.lang.RuntimeException {
	
	/**
	 * Defines an exception to be thrown if there is an attempt pop from an empty stack.
	 * @param message A message that defines why the exception is being thrown.
	 */
	public StackException(String message){
		super(message);
	}

}
