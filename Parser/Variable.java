package Parser;

import SyntaxVisitor.ExpressionVisitor;

public class Variable implements Expression{

    String name = "x";
    Variable() {
    }

    @Override
    public void accept(ExpressionVisitor v) {
	v.visitVariable(this);
    }
    
    
}
