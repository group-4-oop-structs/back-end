package Syntax;

import Parser.Expression;

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
