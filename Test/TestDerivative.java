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
        test = lexer.lex("3*x^4+x^3+x^2");
        Parser parser = new Parser();
        Expression e = parser.parse(test);
        testString = Stringifier.stringify(e);
        System.out.println(testString);
        Expression d = e.getDerivative();
        testString = Stringifier.stringify(d);
        System.out.println(testString);
    }
    
}
