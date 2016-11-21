/*
 *  University of Central Florida
 *  COP 3330
 *  Author: Jonathan Gillis
 */
package Test;

import DataStructureElements.Expression;
import Lexer.Token;
import Parser.Parser;
import static Test.TestSimplify.testNum;
import Utilities.Integrate;
import Utilities.ShrinkTree;
import Utilities.Stringifier;
import java.util.ArrayList;

/**
 *
 * @author gillis
 */
public class TestIntegral {
    
    public static void main(String[] args){
	String[] test_vals = {
	    "x",
	    "x^2",
	    "3*x",
	    "x+3",
//	    "1",
	    "2",
	    "x+1",
	    "1+x"
	};
	
	for(String s : test_vals){
	    test(s);
	}
	
    }
    static int testNum =0;
        public static void test(String s){
	System.out.println("\nTest Case #" + ++testNum);
	System.out.println("Input:             " + s);
	ArrayList<Token> test;
        Expression e = Parser.parseString(s);
	Expression integral = ShrinkTree.shrink(Integrate.integrate(e));
        String testString = Stringifier.stringify(e);
        System.out.printf("Parsed Expression: %s\n", testString);
	System.out.printf("Integral:          %s\n", Stringifier.stringify(integral));
    }
}
