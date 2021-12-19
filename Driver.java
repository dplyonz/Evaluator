package edu.ualbany.Project_3;
import java.io.FileNotFoundException;
import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;



public class Driver {

	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner scanner = new Scanner(new File("Expressions.txt"));
		
		while(scanner.hasNextLine()){
			//get next infix expression
			String infixExp = scanner.nextLine();
			Expression Exp = new Expression(infixExp);
			
			//create list for postfix expression and int for evaluation
			ArrayList<String> list = new ArrayList<String>();
			int eval;
			
			//commence conversion from infix to postfix and display results
			System.out.println("Current infix expression is: "+infixExp+" ... now expressing its postfix form as list of tokens: ");
			list = Exp.convert();
			for(int i =0; i<list.size();i++){
				System.out.println(list.get(i));
			}
			
			//evaluate expression and display results
			System.out.print("Evaluation of expression: ");
			eval = Exp.evaluate();
			System.out.println(eval);
			System.out.println("----------------------------------------------------------------------------------------");
		}
		
		scanner.close();

	}
	}

