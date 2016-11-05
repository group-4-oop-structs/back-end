/*
 *  University of Central Florida
 *  COP 3330
 *  Author: Jonathan Gillis
 */
package Parser;

/**
 *
 * @author gillis
 */
public class Quotient extends BinaryExpression{

    public Quotient(Expression lhs, Expression rhs) {
	super(lhs, rhs);
    }

    @Override
    public Expression getDerivative() {
	throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
