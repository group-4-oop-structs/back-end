/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructureElements;

import DataStructureElements.Visitor.DSEVisitor;
import java.util.ArrayList;

/**
 *
 * @author rthec
 */
public class Csc extends UnaryExpression{
    Expression e;    

    public Csc(Expression e) {
        this.e = e;
    }

    public Expression getExpression() {
        return e;
    }
    
    @Override
    public Expression getDerivative() {
        ArrayList<Expression> product = new ArrayList<>();
        product.add(new Constant(-1));
        product.add(new Csc(e));
        product.add(new Cot(e));
        if (e instanceof Variable){
            return new Product(product);
        }
        else {
            product.add(e.getDerivative());
            return new Product(product);
        }
    }

    @Override
    public Expression getIntegral() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getName() {
	return "csc";
    }

    @Override
    public void accept(DSEVisitor v) {
	v.visitCSC(this);
    }
    
}
