/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import Lexer.*;
import java.util.*;

public class TestLexer {
    public static void main(String[] args){
        ArrayList<Token> test;
        Lexer lexer = new Lexer();
        test = lexer.lex("x^4-4*x^3+3*x^2-(x+5)^2");
        for (int i = 0; i < test.size(); i++){
            System.out.println(test.get(i).toString());
        }
    }
}
