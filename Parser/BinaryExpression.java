package Parser;

import Parser.Expression;

abstract public class BinaryExpression extends Expression{       
    private final Expression left, right;
    
    public Expression getRight() {
        return right;
    }

    public Expression getLeft() {
        return left;
    }
    
    BinaryExpression(Expression lhs, Expression rhs){
	this.left = lhs;
	this.right = rhs;
    }
}
