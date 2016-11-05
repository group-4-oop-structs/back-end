package Parser;

import Syntax.TerminalExpression;

public class Power extends BinaryExpression {
    Expression base;
    Expression power;

    public Power(Expression lhs, Expression rhs) {
	super(lhs, rhs);
    }

    @Override
    public Expression getDerivative() {
	throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

}
