package Syntax;

import java.util.ArrayList;

public class SyntaxDemo {
    public static void main(String[] args){
        ArrayList<Token> tokens;
        
        String test = "(x-4)*(x^2+2*(x+5*x^3))";
        
        Lexer lexer = Lexer.getInstance();
        tokens = lexer.lex(test);
        
        System.out.println(tokens);
        
        ExpressionTree tree = new ExpressionTree();
        
        Parser parser = Parser.getInstance();
        System.out.println("Valid Expression? " + parser.parse(tokens));
        
        
        
    }
}
