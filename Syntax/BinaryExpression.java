package Syntax;

abstract public class BinaryExpression extends Expression{       
    private Expression left, right;
    
    public Expression getRight() {
        return right;
    }

    public Expression getLeft() {
        return left;
    }
    
    public void setLeft(Expression l){
        this.left = l;
    }
    
    public void setRight(Expression r){
        this.right = r;
    }
}
