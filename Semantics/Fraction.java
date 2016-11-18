/*
 *  University of Central Florida
 *  COP 3330
 *  Author: Jonathan Gillis
 */
package Semantics;

/**
 *
 * @author gillis
 */
public class Fraction extends Expression2 {
    Expression2 left, right;

    @Override
    public void accept() {
	throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public Fraction(Expression2[] args){
	super(args);
	left = args[0];
	right = args[1];
    }
}
