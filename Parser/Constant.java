package Parser;

import Parser.Expression;
import SyntaxVisitor.ExpressionVisitor;

public class Constant implements Expression {
    double value;
    
    public Constant(double v){
        this.value = v;
    }

    public double getValue(){
	return this.value;
    }
    
    @Override
    public void accept(ExpressionVisitor v) {
	v.visitConstant(this);
    }
    
    
}
