/*
 *  University of Central Florida
 *  COP 3330
 *  Author: Jonathan Gillis
 */
package Semantics;

import Lexer.Lexer;

/**
 *
 * @author gillis
 */
public class Summation extends Expression2 {
    final Expression2[] terms;

    
    Summation(Expression2[] args){
	super(args);
	this.terms = args;
    }
    
    @Override
    public void accept() {
	throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public static Expression2 parse(Lexer l){
	throw new UnsupportedOperationException();
    }
}
