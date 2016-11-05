package Parser;

public class Difference extends BinaryExpression{   

    public Difference(Expression lhs, Expression rhs) {
	super(lhs, rhs);
    }

    @Override
    public Expression getDerivative() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
