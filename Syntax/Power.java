package Syntax;

public class Power extends TerminalExpression {
    Expression base;
    double power;
    
    public Power(double p){
        this.power = p;
    }
    
    public void setBase(Expression b){
        this.base = b;
    }
    
    @Override
    public Expression getDerivative(){
        return this;
    }
}
