package Parser;

import SyntaxVisitor.ExpressionVisitor;

public class Variable implements Expression{

    Variable() {
    }

    @Override
    public void accept(ExpressionVisitor v) {
	v.visitVariable(this);
    }
    
    
}
