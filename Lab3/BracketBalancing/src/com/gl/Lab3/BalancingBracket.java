package com.gl.Lab3;

import java.util.Scanner;
import java.util.Stack;

public class BalancingBracket {
	
	 public static void main(String[] args) {

	        Scanner sc=new Scanner(System.in);
	        BalancingBracket bb = new BalancingBracket();

	        System.out.println("Enter the expression:");
	        String exp = sc.nextLine();
	        boolean isBalanced = bb.checkBracket(exp);

	        if(isBalanced)
	            System.out.println("The entered String has Balanced Brackets");
	        else
	            System.out.println("The entered Strings do not contain Balanced Brackets");

	    }

	    public boolean checkBracket(String expression)
	    {
	        if(expression.length()%2!=0)
	        {
	            return false;
	        }
	        Stack<Character> bracketStack = new Stack<Character>();

	        for(int i=0; i<expression.length();i++)
	        {
	            char character = expression.charAt(i);

	            //Push into the stack if expression encounters the opening bracket
	            if(character =='{' || character =='[' || character =='(')
	            {
	                bracketStack.push(character);
	            }


	            else
	            {
	                char top = bracketStack.pop();

	                //Check if top matches popped character.
	                switch(character)
	                {
	                    case '}':
	                        if(top=='['||top=='(')
	                        {
	                            return false;
	                        }

	                        else
	                            return true;

	                    case ']':
	                        if(top=='{'||top=='(')
	                        {
	                            return false;
	                        }
	                        else
	                            return true;

	                    case ')':
	                        if(top=='['||top=='{')
	                        {
	                            return false;
	                        }
	                        else
	                            return true;

	                    default: return bracketStack.isEmpty();

	                }
	            }
	        }
	        return false;
	    }
}
