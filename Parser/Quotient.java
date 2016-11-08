/*
 *  University of Central Florida
 *  COP 3330
 *  Author: Jonathan Gillis
 */
package Parser;

import SyntaxVisitor.ExpressionVisitor;

/**
 *
 * @author gillis
 */
public class Quotient extends BinaryExpression{

    public Quotient(Expression lhs, Expression rhs) {
	super(lhs, rhs);
    }

    @Override
    public void accept(ExpressionVisitor v) {
	v.visitQuotient(this);
    }
  
    
}
