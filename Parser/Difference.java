package Parser;

import SyntaxVisitor.ExpressionVisitor;

public class Difference extends BinaryExpression{   

    public Difference(Expression lhs, Expression rhs) {
	super(lhs, rhs);
    } 

    @Override
    public void accept(ExpressionVisitor v) {
	v.visitDifference(this);
    }
    
    
}
