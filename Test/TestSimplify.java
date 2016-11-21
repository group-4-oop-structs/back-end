/*
 *  University of Central Florida
 *  COP 3330
 *  Author: Jonathan Gillis
 */
package Test;

import DataStructureElements.Expression;
import Lexer.Lexer;
import Lexer.Token;
import Parser.Parser;
import Utilities.Stringifier;
import java.util.ArrayList;

/**
 *
 * @author gillis
 */
public class TestSimplify {
    public static void main(String[] args){
	test("x+x");
	test("x+2*x");
	test("x*x");
	test("x*x^2");
	test("x^2*x");
	test("x^2*x^3");
	test("(x+1)+(x+1)^2");
    }
    
    static int testNum = 1;
    
    public static void test(String s){
	System.out.println("\nTest Case #" + testNum);
	System.out.println("Input: " + s);
	ArrayList<Token> test;
        Expression e = Parser.parseString(s);
        String testString = Stringifier.stringify(e);
        System.out.println(testString);
    }
}
