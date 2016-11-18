package Parser;

import SyntaxVisitor.ExpressionVisitor;

public interface Expression {
    
    public abstract void accept(ExpressionVisitor v);
}

