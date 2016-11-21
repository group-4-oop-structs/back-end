/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import DataStructureElements.*;
import Lexer.*;
import Parser.*;
import Utilities.*;
import java.util.*;

public class TestDerivative {
    
    public static void main(String[] args){
        ArrayList<Token> test;
        Lexer lexer = new Lexer();
        String testString;
        Expression e, d;
        Parser parser = new Parser();
        
        //Test Case 1
        System.out.println("Test Case 1");
        test = lexer.lex("3*x^4+x^3+x^2");        
        e = parser.parse(test);
        testString = Stringifier.stringify(e);
        System.out.println(testString);
        d = e.getDerivative();
        testString = Stringifier.stringify(d);
        System.out.println(testString);
        //Test Case 2
        System.out.println("Test Case 2");
        test = lexer.lex("6*x^4*x^5");
        e = parser.parse(test);
        testString = Stringifier.stringify(e);
        System.out.println(testString);
        d = e.getDerivative();
        testString = Stringifier.stringify(d);
        System.out.println(testString);
        //Test Case 3
        System.out.println("Test Case 3");
        test = lexer.lex("6*x^4*x^5*x^2");
        e = parser.parse(test);
        testString = Stringifier.stringify(e);
        System.out.println(testString);
        d = e.getDerivative();
        testString = Stringifier.stringify(d);
        System.out.println(testString);
        
       //Test Case 4
       System.out.println("Test Case 4");
        test = lexer.lex("(x^2-1)^5");
        e = parser.parse(test);
        testString = Stringifier.stringify(e);
        System.out.println(testString);
        d = e.getDerivative();
        testString = Stringifier.stringify(d);
        System.out.println(testString);
        
        //Test Case 5
        System.out.println("Test Case 5");
        test = lexer.lex("sin(x)");
        e = parser.parse(test);
        testString = Stringifier.stringify(e);
        System.out.println(testString);
        d = e.getDerivative();
        testString = Stringifier.stringify(d);
        System.out.println(testString);
        
        //Test Case 6
        System.out.println("Test Case 6");
        test = lexer.lex("sin(2*x)");
        e = parser.parse(test);
        testString = Stringifier.stringify(e);
        System.out.println(testString);
        d = e.getDerivative();
        testString = Stringifier.stringify(d);
        System.out.println(testString);
        
        //Test Case 7
        System.out.println("Test Case 7");
        test = lexer.lex("sin(x^2)");
        e = parser.parse(test);
        testString = Stringifier.stringify(e);
        System.out.println(testString);
        d = e.getDerivative();
        testString = Stringifier.stringify(d);
        System.out.println(testString);
        
        //Test Case 8
        System.out.println("Test Case 8");
        test = lexer.lex("sin(x)*x");
        e = parser.parse(test);
        testString = Stringifier.stringify(e);
        System.out.println(testString);
        d = e.getDerivative();
        testString = Stringifier.stringify(d);
        System.out.println(testString);
        
        //Test Case 9
        System.out.println("Test Case 9");
        test = lexer.lex("(sin(x))^2");
        e = parser.parse(test);
        testString = Stringifier.stringify(e);
        System.out.println(testString);
        d = e.getDerivative();
        testString = Stringifier.stringify(d);
        System.out.println(testString);
        
        //Test Case 10
        System.out.println("Test Case 10");
        test = lexer.lex("cos(2*x)");
        e = parser.parse(test);
        testString = Stringifier.stringify(e);
        System.out.println(testString);
        d = e.getDerivative();
        testString = Stringifier.stringify(d);
        System.out.println(testString);
        
        //Test Case 11
        System.out.println("Test Case 11");
        test = lexer.lex("cos(x^2)");
        e = parser.parse(test);
        testString = Stringifier.stringify(e);
        System.out.println(testString);
        d = e.getDerivative();
        testString = Stringifier.stringify(d);
        System.out.println(testString);
        
        //Test Case 12
        System.out.println("Test Case 12");
        test = lexer.lex("cos(x)*x");
        e = parser.parse(test);
        testString = Stringifier.stringify(e);
        System.out.println(testString);
        d = e.getDerivative();
        testString = Stringifier.stringify(d);
        System.out.println(testString);
        
        //Test Case 13
        System.out.println("Test Case 13");
        test = lexer.lex("(cos(x))^2");
        e = parser.parse(test);
        testString = Stringifier.stringify(e);
        System.out.println(testString);
        d = e.getDerivative();
        testString = Stringifier.stringify(d);
        System.out.println(testString);
        
        //Test Case 14
        System.out.println("Test Case 14");
        test = lexer.lex("2^x");
        e = parser.parse(test);
        testString = Stringifier.stringify(e);
        System.out.println(testString);
        d = e.getDerivative();
        testString = Stringifier.stringify(d);
        System.out.println(testString);
        
        //Test Case 15
        System.out.println("Test Case 15");
        test = lexer.lex("2^(5*x-1)");
        e = parser.parse(test);
        testString = Stringifier.stringify(e);
        System.out.println(testString);
        d = e.getDerivative();
        testString = Stringifier.stringify(d);
        System.out.println(testString);
        
        //Test Case 16
        System.out.println("Test Case 16");
        test = lexer.lex("2^(sin x)");
        e = parser.parse(test);
        testString = Stringifier.stringify(e);
        System.out.println(testString);
        d = e.getDerivative();
        testString = Stringifier.stringify(d);
        System.out.println(testString);
        
        //Test Case 17
        System.out.println("Test Case 17");
        test = lexer.lex("2^(sin x * cos x)");
        e = parser.parse(test);
        testString = Stringifier.stringify(e);
        System.out.println(testString);
        d = e.getDerivative();
        testString = Stringifier.stringify(d);
        System.out.println(testString);
        
        //Test Case 18
        System.out.println("Test Case 18");
        test = lexer.lex("cos(2^(x^2))");
        e = parser.parse(test);
        testString = Stringifier.stringify(e);
        System.out.println(testString);
        d = e.getDerivative();
        testString = Stringifier.stringify(d);
        System.out.println(testString);
    }
    
}
