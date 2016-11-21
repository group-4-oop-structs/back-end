/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import DataStructureElements.*;
import Utilities.*;
import Lexer.Lexer;
import Lexer.Token;
import java.util.ArrayList;
import Parser.*;

public class TestIntegeral {
    public static void main(String[] args){
        ArrayList<Token> test;
        Lexer lexer = new Lexer();
        String testString;
        test = lexer.lex("x^2+x^5+x^7");
        Parser parser = new Parser();
        Expression e = parser.parse(test);
        testString = Stringifier.stringify(e);
        System.out.println(testString);
        Expression i = e.getIntegral();
        testString = Stringifier.stringify(i);
        System.out.println(testString);
    }
}
