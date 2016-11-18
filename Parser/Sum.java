package Parser;

import SyntaxVisitor.ExpressionVisitor;

public class Sum extends BinaryExpression{

    public Sum(Expression lhs, Expression rhs){
	super(lhs,rhs);
    }

    @Override
    public void accept(ExpressionVisitor v) {
	v.visitSum(this);
    }
}
