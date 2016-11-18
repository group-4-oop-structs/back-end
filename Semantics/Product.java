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
public class Product extends Expression2 {
    final Expression2[] factors;
    @Override
    public void accept() {
	throw new UnsupportedOperationException("Not supported yet.");
    }
    
    Product(Expression2[] args){
	super(args);
	this.factors = args;
    }
}
