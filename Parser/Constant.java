package Parser;

import Parser.Expression;
import Syntax.TerminalExpression;

public class Constant extends TerminalExpression {
    double value;
    
    public Constant(double v){
        this.value = v;
    }
    
    
    @Override
    public Expression getDerivative(){
        return new Constant(0);
    }
}
