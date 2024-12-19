import java.util.*;
public class ProcessAlgebraicExpression {
	public static final int MAX_EXP=100;		// max length of expression
	/** 
	 * Decide whether the parentheses, brackets, 
	 * and braces in a string occurs in left/right pairs.
	 * @param ex a string to be checked
	 * @return True if the delimiters are paired correctly
	 */
	public boolean checkBalance(String ex) {
		// list of considering open parentheses
		Stack<Character> parenStack = new Stack<Character>(); 
		int charCount = ex.length();
		boolean isBalanced = true; // the absence of delimiters is balanced
		char nextCharacter = ' '; // the next character in expression
		for(int i = 0 ; isBalanced && i < charCount ; i++) {
			nextCharacter = ex.charAt(i);
			switch(nextCharacter) {
			case '(' : case '[': case '{':
				// push nextCharacter onto stack
				parenStack.push(nextCharacter);
				break;
			case ')': case ']': case '}' :
				// when we meet the right pair but there is no left pair in the stack
				if(parenStack.isEmpty()) isBalanced = false;
				// if the stack is not empty, the value of isBalanced is the
				// result of comparison between delimiters 
				// of the next character and the top of the stack
				else isBalanced = isPaired(parenStack.pop(), nextCharacter);
				break;
			}
		}
		//if the stack still has open delimiters after see all string, 
		// the delimiters are not paired correctly.
		if(!parenStack.isEmpty()) isBalanced = false;
		return isBalanced;
	}
	/**
	 * Decide whether open and close make a pair correctly.
	 * @param open one of open parentheses, brackets, or braces
	 * @param close one of close parentheses, brackets, or braces
	 * @return True if the given characters, open and close, form
	 * a pair of parentheses, brackets, or braces
	 */
	private boolean isPaired(char open, char close) {
		return (open == '(' && close == ')') ||
				(open == '[' && close == ']') ||
				(open == '{' && close == '}') ;
	}
	/**
	 * Convert an infix expression to an equivalent post-fix expression
	 * @param infix: infix expression
	 * @return post-fix expression equivalent to the infix expression
	 */
	public String[] infix2postfix(String[] infix) {
		Stack<String> operatorStack = new Stack<>();	// a new empty stack
		System.out.println(Arrays.toString(infix));
		String[] postfix = new String[infix.length]; // a new empty string
		int size = 0;
		try {
			for(int i = 0 ; i < infix.length ; i++) {
				String next = infix[i];	// next non character left to parse
				switch(next) {
				case "^":
					operatorStack.push(next);
					break;
				case "+": case "-": case "*": case "/":
					while(!operatorStack.isEmpty() && 
					      precedence(next) <= precedence(operatorStack.peek()))
							postfix[size++]=operatorStack.pop();
					operatorStack.push(next);
					break;
					case "(": case "{":case "[":
						operatorStack.push(next);
						break;
					case ")": case "}": case "]":
						String topOperator = operatorStack.pop();
						while("({[".indexOf(topOperator)<0) {						
							postfix[size++] = topOperator;
							topOperator = operatorStack.pop();
						}
						break;
					default:
						postfix[size++]=next;
						break;
				}
			}
		}catch (Exception e) {
			System.err.println(e.getMessage());			System.exit(-1);
		}
		while(!operatorStack.isEmpty()) 	postfix[size++]= operatorStack.pop();
		String[] result = new String[size];
		for(int i = 0 ; i < size ; i++)			result[i]=postfix[i];
		return result;
	}
	private int precedence(String op) throws Exception {
		switch(op) {
		case "+": case "-": 
			return 1;
		case "*": case "/": 
			return 2;
		case "^": 			
			return 3;			
		case "(": case "{": case "[":		
			return 0;
		default: 
			throw new Exception("Wrong operator in precedene: "+ op);
		}
	}
	/**
	 * The string2arrString method removes all whitespace characters from s 
	 * and converts String s intro String[] by dividing by each term.
	 * @param s String form expression
	 * @return String[] form expression without any whitespace character
	 */
	public String[] string2arrString(String s) {
		s = s.replaceAll(" |	|(^\\p{Z}+|\\p{Z}+$)", ""); // remove all blanks
		String[] temp = new String[MAX_EXP];
		int length = 0;
		temp[0]="";

		for(int i = 0 ; i < s.length() ; i++) {
			char ch = s.charAt(i);
			switch(ch) {
			case '(': case '{': case '[': 
				temp[length++] = ch+"";
				temp[length]="";
				break;
			case '+': case '-': case '*': case '/': case '^':
				temp[++length] = "" + ch;
				temp[++length] = "";
				break;
			case ')': case ']': case '}':
				temp[++length] = "" + ch;
				break;
			default:
				temp[length]+=ch; // we assume that any character except an operator and a delimiter is an operand
			}
		}
		//Compact the result
		String[] result =  new String[length+1];
		for(int i = 0 ; i <= length ; i++)
			result[i] = temp[i];
		return result;
	}
	public double evaluatePostfix(String[] exp) {
		Stack<String> stack = new Stack<String>();
		
		for (int i = 0; i < exp.length; i++) {
			String input = exp[i];
			if (isAnOperator(input)) {
				double y = Double.parseDouble(stack.pop());
				double x = Double.parseDouble(stack.pop());
				double z = evaluate(x, y, input);
				stack.push("" + z);
			} else stack.push(input);
		}
		return Double.parseDouble(stack.pop());
	}
	private boolean isAnOperator(String s) {
		return (s.length() == 1 && "+-*/^".indexOf(s) >= 0);
	}
	private double evaluate(double x, double y, String op) {
		double z = 0;
		if (op.equals("+")) z = x + y;
		else if (op.equals("-")) z = x - y;
		else if (op.equals("*")) z = x * y;
		else if (op.equals("^")) z = Math.pow(x, y);
		else if (op.equals("/")) z = x / y;
		else System.err.println(op+" is not an operator.");
		return z;
	}
	public double evaluateInfix(String infix) {
		if(checkBalance(infix)){
			String[] s = string2arrString(infix);
			s = infix2postfix(s);
			return evaluatePostfix(s);
		} else {
			System.err.println("Wrong delimiter.");
			return 0;
		}
	}

	public static void main(String[] arg) {
		ProcessAlgebraicExpression pae = new ProcessAlgebraicExpression();

		String s = "   a{b[c(d+e  /	2 - f ]+1}";
		System.out.println(Arrays.toString(pae.string2arrString(s)));
		if(pae.checkBalance(s))
			System.out.println("Well balanced");
		else System.out.println("balance is cracked");
		String infix1 = "(a+b) / (c -d)";
		String[] infix1_1 = pae.string2arrString(infix1);
		String infix2 = "a-{b/(c-d)*e+f}^g";
		String[] infix2_1 = pae.string2arrString(infix2);
		String infix3 = "11+29*3-45/5^ 2";  
		String[] infix3_1 = pae.string2arrString(infix3);
		System.out.println("infix3: "+ Arrays.toString(infix1_1));
		System.out.println("infix3: "+ Arrays.toString(infix2_1));
		System.out.println("infix3: "+ Arrays.toString(infix3_1));
		System.out.println("The result of [3*{5 + ( 15-7)/2-9} +1]^2 is " + pae.evaluateInfix("[3*{5 + ( 15-7)/2-9} +1]^2"));
	}
}