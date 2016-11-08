

import Parser.*;
import Lexer.*;
import java.util.ArrayList;
import SyntaxVisitor.*;

public class SyntaxDemo {
    public static void main(String[] args){        
        String test = "x+1";
        
        Lexer lexer = new Lexer();
        ArrayList<Token> tokens = lexer.lex(test);
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
	    System.out.println("The expression is not valid" + e.getMessage());
	    e.printStackTrace();	   
	}
        
        
        
    }
}
