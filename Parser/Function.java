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
abstract public class Function extends UnaryExpression{
    public Function( Expression in){
	super(in);
    }
    
    public String getName() {
	return name;
    }
}
