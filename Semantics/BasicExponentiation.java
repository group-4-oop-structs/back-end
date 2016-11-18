/*
 *  University of Central Florida
 *  COP 3330
 *  Author: Jonathan Gillis
 */
package Semantics;

import Parser.Variable;

/**
 *
 * @author gillis
 */
public class BasicExponentiation extends Expression2 {

    final Expression2 base, exponent;
    @Override
    public void accept() {
	throw new UnsupportedOperationException("Not supported yet.");
    }

    public BasicExponentiation(Expression2[] args) {
	super(args);
	this.base = args[0];
	this.exponent = args[1];
    }
    
    public static BasicExponentiation make(Expression2 b, Expression2 e){
	Expression2[] arr = new Expression2[2];
	arr[0] = b;
	arr[1] = e;
	return new BasicExponentiation(arr);
    }
    
    
}
