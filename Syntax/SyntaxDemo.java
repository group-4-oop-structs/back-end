package Syntax;

import java.util.ArrayList;

public class SyntaxDemo {
    public static void main(String[] args){        
        String test = "x+1";
        
        Lexer lexer = Lexer.getInstance();
        ArrayList<Token> tokens = lexer.lex(test);
        System.out.println("Tokens:");
        System.out.println(tokens);
        
        ExpressionTree tree = new ExpressionTree();
        
        Parser parser = Parser.getInstance();
        System.out.println("Valid Expression? " + parser.parse(tokens));
        
        
        
    }
}
