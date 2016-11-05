package Parser;

public abstract class Expression {
    private Expression parent;
    
    public void setParent(Expression e){
        this.parent = e;
    }
    
    public Expression getParent(){
        return this.parent;
    }
    abstract public Expression getDerivative();
}
