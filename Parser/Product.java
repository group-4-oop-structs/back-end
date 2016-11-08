package Parser;

import SyntaxVisitor.ExpressionVisitor;

public class Product extends BinaryExpression{

    public Product(Expression lhs, Expression rhs){
	super(lhs,rhs);
    }

    @Override
    public void accept(ExpressionVisitor v) {
	v.visitProduct(this);
    }

    
    
}
