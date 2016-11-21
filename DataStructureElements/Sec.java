/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructureElements;

import java.util.ArrayList;
import DataStructureElements.Visitor.DSEVisitor;

/**
 *
 * @author rthec
 */
public class Sec extends UnaryExpression{
    Expression e;

    public Sec(Expression e) {
        this.e = e;
    }

    public Expression getExpression() {
        return e;
    }
    
    @Override
    public Expression getDerivative() {
        ArrayList<Expression> product = new ArrayList<>();
        product.add(new Sec(e));
        product.add(new Tan(e));
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
	return "sec";
    }

    @Override
    public void accept(DSEVisitor v) {
	v.visitSec(this);
    }
    
}
