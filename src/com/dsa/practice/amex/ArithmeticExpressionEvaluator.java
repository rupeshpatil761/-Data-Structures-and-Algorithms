package com.dsa.practice.amex;

import java.util.Stack;

public class ArithmeticExpressionEvaluator {

    public static void main(String[] args) {
        //String expression = "12+2*3/4-1";
    	String expression = "12+3-2";
        
        double result = evaluateExpression(expression);
        System.out.println(result); // Output: 1.5
    }
    
    private static double evaluateExpression(String expression) {

    	// can we have decimal numbers ? yes
    	// can we have number greater than 9 ? yes
    	// operator precedence should be followed? yes
    	// can we other than digits and operators in string? no
    	
    	Stack<Double> numberStack = new Stack();
    	Stack<Character> operatorsStack = new Stack();
    	
    	// plan is to add numbers in numberstack until operator finds
    	// if operators stack is not empty, check the precedence of current operator and stacks first operator
    	// if current operator precedence is lower or equal .. perform operation
    	// finally check if still operator stack is empty or not? perform operations accordingly
    	
    	int n = expression.length();
    	for(int i=0; i<n;i++) {
    		char currentChar = expression.charAt(i);
    		
    		if(Character.isDigit(currentChar)) {
    			// need to consider that number can be decimal no also
    			StringBuilder tempStr = new StringBuilder();
    			int j = i;
    			while(j < n) {
    				if(Character.isDigit(expression.charAt(j)) || expression.charAt(j) == '.') {
    					tempStr.append(expression.charAt(j));
    				} else {
    					break;
    				}
    				j++;
    			}
    			i = j-1;
    			numberStack.push(Double.valueOf(tempStr.toString()));
    		} else if(isOperatorNew(currentChar)) {
    			if(!operatorsStack.isEmpty() && (precedenceNew(currentChar) <= precedenceNew(operatorsStack.peek()))) {
    				char operator = operatorsStack.pop();
    				double calc = performArithmeticOperation(operator, numberStack.pop(), numberStack.pop());
    				numberStack.push(calc);
    			}
    			operatorsStack.push(currentChar);
    		} else {
    			continue;
    		}
    	}
    	//System.out.println("numberStack: "+numberStack);
    	//System.out.println("operatorsStack: "+operatorsStack);
    	
    	while(!operatorsStack.isEmpty()) {
    		double calc = performArithmeticOperation(operatorsStack.pop(), numberStack.pop(), numberStack.pop());
			numberStack.push(calc);
    	}
    	
    	System.out.println("numberStack: "+numberStack);
    	System.out.println("operatorsStack: "+operatorsStack);
    	
    	return numberStack.pop();
    }
    
    private static double performArithmeticOperation(char operator, Double b, Double a) {
    	switch(operator) {
    		case '+':
    			return a + b;
    		case '-':
    			return a - b;
    		case '*':
    			return a * b;
    		case '/':
    			return a / b;
    	}
		return 0;
	}

	private static int precedenceNew(char operator) {
    	switch (operator) { 
    		case '+':
    		case '-':
    			return 1;
    		case '*':
    		case '/':
    			return 2;
    	}
    	return -1;
	}

	private static boolean isOperatorNew(char ch) {
    	return ch=='-' || ch=='+' || ch=='/' || ch=='*'; 
    	
    }
}

