package Parser;

import SyntaxVisitor.ExpressionVisitor;

public class Power extends BinaryExpression {
    Expression base;
    Expression power;

    public Power(Expression lhs, Expression rhs) {
	super(lhs, rhs);
    }

    @Override
    public void accept(ExpressionVisitor v) {
	v.visitPower(this);
    }

    
    

}
