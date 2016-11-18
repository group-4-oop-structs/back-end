

import Parser.*;
import Lexer.*;
import java.util.ArrayList;
import SyntaxVisitor.*;

public class SyntaxDemo {
    public static void main(String[] args){        
	test("x+1"); 
	test("x*2");
	test("(x)");
//	test("(x+1)*(30*x)^4");
//	test("x^2");
//	test("x*x");
	test("()^3");
	
	
    }
    
    public static void test(String input){

	
	System.out.println("Input: " + input);
	System.out.println();
        Lexer lexer = new Lexer();
        ArrayList<Token> tokens = lexer.lex(input);
        System.out.println("Tokens:");
        System.out.println(tokens);
        Parser parser = new Parser();
	try {
	   Expression expression = parser.parse(tokens); 
	   System.out.println("The Expression is valid");
	   
	   System.out.println("The expression is: ");
	   Stringifier sb = new Stringifier();
	   expression.accept(sb);
	   System.out.println(sb.toString());
	   
	} catch ( SyntaxError e) {
	    System.out.println("The expression is not valid: " + e.getMessage());
	    e.printStackTrace();	   
	}   
	
	System.out.println("\n");
    }
    
    
}
