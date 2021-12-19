package edu.ualbany.Project_3;

/**
 * Specifications of the Generic Stack operations and what they do.
 * @author Derren Lyons
 * @version 1.0
 */
public interface GenericStackInterface<E> {

	/**
	 * Adds an object to the stack.
	 * @param o The data to be added to the stack.
	 */
	public void push(E o);
	
	/**
	 * Removes and returns the item most recently added to the stack.
	 * @return The item removed from the stack.
	 * @throws StackException
	 */
	public E pop() throws StackException;
	
	/**
	 * Removes all items stored in the stack.
	 * @throws StackException
	 */
	public void popAll() throws StackException;
	
	/**
	 * Returns the item at the end of the stack.
	 * @return The item at the end of the stack.
	 */
	public E peek();
	
	/**
	 * Checks if the stack is empty and returns 1 if empty 0 if not.
	 * @return A boolean value of 1 if empty 0 if not.
	 */
	public boolean isEmpty();
	
	/**
	 * Gets the size of the stack.
	 * @return An integer value size of the stack.
	 */
	public int size();
}
