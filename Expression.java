package edu.ualbany.Project_3;

import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Class to express an infix arithmetic expression.
 * @author Derren Lyons
 * @version 1.0
 */
public class Expression {
	
	private String infix;
	
	/**
	 * Default constructor for Expression class.
	 */
	public Expression(){
		this.infix = null;
	}
	
	/**
	 * Second constructor that takes a specific infix string.
	 * @param exp The infix string to be used.
	 */
	public Expression(String exp){
		this.infix = exp;
	}
	
	/**
	 * Gets the infix expression.
	 * @return The string object representing the infix expression.
	 */
	public String getInfix(){
		return this.infix;
	}
	
	/**
	 * Sets the infix expression.
	 * @param exp The infix string to be used.
	 */
	public void setInfix(String exp){
		this.infix = exp;
	}
	
	/**
	 * Converts this infix expression to postfix.
	 * @return The postfix expression as a list of tokens.
	 */
	public ArrayList<String> convert(){
		//create stack for 
		GenericStack<String> stack = new GenericStack<String>();
		
		//split infix into list of tokens
		StringTokenizer s = new StringTokenizer(this.infix,")(+_*/ ",true);
		ArrayList<String> tokens = new ArrayList<String>();
		while(s.hasMoreTokens()){
			tokens.add(s.nextToken());
		}
				
		//create list of postfix tokens
		ArrayList<String> postfix = new ArrayList<String>();
		
		for(int i = 0; i<tokens.size();i++){
			//if operand
			if(tokens.get(i).matches("\\d\\d\\d|\\d\\d|\\d")){
				postfix.add(tokens.get(i));
			}
			//push "("
			if(tokens.get(i).equals("(")){
				stack.push(tokens.get(i));
			}
			//if operator
			if((tokens.get(i).equals("+"))||tokens.get(i).equals("-")||tokens.get(i).equals("*")||tokens.get(i).equals("/")){
				if(stack.isEmpty()){
					stack.push(tokens.get(i));
				}
				else if(!stack.isEmpty()){
					if((tokens.get(i).equals("+")||tokens.get(i).equals("-")) && (stack.peek().equals("+")||stack.peek().equals("-")||stack.peek().equals("*")||stack.peek().equals("-"))){
						postfix.add(stack.pop());
					}
					if((tokens.get(i).equals("*")||tokens.get(i).equals("/")) && (stack.peek().equals("*") || stack.peek().equals("/"))){
						postfix.add(stack.pop());
					}
					stack.push(tokens.get(i));
				}
			}
			//pop until "(" is reached
			if(tokens.get(i).equals(")")){
				while(!stack.isEmpty() && !stack.peek().equals("(")){
					postfix.add(stack.pop());
				}
				if(!stack.isEmpty() && stack.peek().equals("(")){
					stack.pop();
				}
			}
			
		}
		//pop remainder of stack
		while(!stack.isEmpty()){
			postfix.add(stack.pop());
		}
		
		return postfix;
	}
	
	/**
	 * Evaluates the expression.
	 * @return The result of the expression.
	 */
	public int evaluate(){
		GenericStack<Integer> stack = new GenericStack<Integer>();
		ArrayList<String> postfixexp = new ArrayList<String>();
		postfixexp = this.convert();
		
		for(int i =0; i<postfixexp.size();i++){
			//if operand
			if(postfixexp.get(i).matches("\\d\\d\\d|\\d\\d|\\d")){
				stack.push(Integer.parseInt(postfixexp.get(i)));
			}
			if(postfixexp.get(i).equals("+")){
				int a = stack.pop();
				int b = stack.pop();
				int c = a + b;
				stack.push(c);
			}
			if(postfixexp.get(i).equals("-")){
				int a = stack.pop();
				int b = stack.pop();
				int c = a - b;
				stack.push(c);
			}
			if(postfixexp.get(i).equals("*")){
				int a = stack.pop();
				int b = stack.pop();
				int c = a * b;
				stack.push(c);
			}
			if(postfixexp.get(i).equals("/")){
				int a = stack.pop();
				int b = stack.pop();
				int c = b / a;
				stack.push(c);
			}
		}
		return stack.pop();
	}
	
}
