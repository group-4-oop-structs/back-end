/*
 *  University of Central Florida
 *  COP 3330
 *  Author: Jonathan Gillis
 */
package Test;

import Lexer.Lexer;
import Parser.*;
import SyntaxVisitor.Evaluate;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author gillis
 */
public class TestEvaluate {
    
    public static void main(String[] args) throws SyntaxError{
	String input = "3*x^2+-5*x+3";
	
	System.out.println(input);

	Lexer lex = new Lexer();
	Parser p = new Parser();
	
	Expression tree = p.parse(lex.lex(input));
	
	Evaluate eval = new Evaluate(tree);
	List<Double> values= new ArrayList<Double>();
	for(double d = -10000.0; d<= 10000.0; d+= 0.01){
	    Double y = eval.at(d);
//	    System.out.printf("(%.2f,%.2f)\n", d, y);
	    values.add(y);
	}
	System.out.println("Done");
	    
    }
}
