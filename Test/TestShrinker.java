/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import DataStructureElements.Expression;
import Lexer.Lexer;
import Lexer.Token;
import Parser.Parser;
import Utilities.ShrinkTree;
import Utilities.Stringifier;
import java.util.ArrayList;

/**
 *
 * @author rthec
 */
public class TestShrinker {
    
    public static void main(String[] args){
        ArrayList<Token> test;
        Lexer lexer = new Lexer();
        String testString;
        //test case 1
        System.out.println("Test Case 1");
        test = lexer.lex("3+(3+(x+1))");
        Parser parser = new Parser();
        Expression e = parser.parse(test);
        e = ShrinkTree.shrink(e);
        testString = Stringifier.stringify(e);
        System.out.println(testString);
        
        //test case 2
        System.out.println("Test Case 2");
        test = lexer.lex("3*(3*(x+1))");
        e = parser.parse(test);
        e = ShrinkTree.shrink(e);
        testString = Stringifier.stringify(e);
        System.out.println(testString);
    }
    
}
