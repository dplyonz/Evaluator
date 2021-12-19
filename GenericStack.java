package edu.ualbany.Project_3;

import java.util.ArrayList;

/**
 * Implementation of a Generic Stack.
 * @author Derren Lyons
 * @version 1.0
 */
public class GenericStack<E> implements GenericStackInterface<E> {
	
	private int maxitems = 50;
	
	private int top;
	
	private ArrayList<E> List;

	public GenericStack(){
		this.List = (new ArrayList<E>(this.maxitems));
		this.top = -1;
	}
	
	/**
	 * Adds an object to the stack.
	 * @param o The data to be added to the stack.
	 */
	public void push(E o) {
		this.List.add(o);
		this.top++;
	}

	/**
	 * Removes and returns the item most recently added to the stack.
	 * @return The item removed from the stack.
	 * @throws StackException
	 */
	public E pop() throws StackException {
		E object = this.List.get(top);
		this.List.remove(top);
		this.top--;
		return object;
	}

	/**
	 * Removes all items stored in the stack.
	 * @throws StackException
	 */
	public void popAll() throws StackException {
		this.List.clear();
		this.top = -1;
	}
	
	/**
	 * Returns the item at the end of the stack.
	 * @return The item at the end of the stack.
	 */
	public E peek(){
		E object = this.List.get(this.top);
		return object;
	}
	
	/**
	 * Checks if the stack is empty and returns 1 if empty 0 if not.
	 * @return A boolean value of 1 if empty 0 if not.
	 */
	public boolean isEmpty(){
		return this.List.size() == 0;
	}
	
	/**
	 * Gets the size of the stack.
	 * @return An integer value size of the stack.
	 */
	public int size(){
		return this.List.size();
	}
	
	/**
	 * Displays all the data in the stack.
	 */
	public void display(){
		for(int i =0;i< this.List.size();i++){
			E data = this.List.get(i);
			System.out.println(data);
		}
	}
	
}
