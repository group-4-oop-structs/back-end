/*
 *  University of Central Florida
 *  COP 3330
 *  Author: Jonathan Gillis
 */
package Test;

import Parser.Expression;
import Parser.Parser;
import Parser.SyntaxError;
import SyntaxVisitor.Differentiate;
import SyntaxVisitor.Stringifier;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gillis
 */
public class TestDerivitive {
    public static void main(String[] args){
	test("x*x");
	test("x*(x+1)");
    }
    
    public static void test(String inp){
	
	try {
	    Expression input = Parser.parseString(inp);
	    Expression ddx = Differentiate.differentiate(input);
	    Stringifier in = new Stringifier(), out = new Stringifier();
	    input.accept(in);
	    ddx.accept(out);
	    System.out.printf("The derivative of\n%s\nis\n%s\n", in.toString(), out.toString());
	} catch (SyntaxError ex) {
	    Logger.getLogger(TestDerivitive.class.getName()).log(Level.SEVERE, null, ex);
	}
	
	
    }
}
