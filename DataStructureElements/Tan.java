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
public class Tan extends UnaryExpression{
    Expression e;

    public Tan(Expression e) {
        this.e = e;
    }

    public Expression getExpression() {
        return e;
    }
    
    @Override
    public Expression getDerivative() {
        Power p = new Power(2, new Sec(e));
        ArrayList<Expression> product = new ArrayList<>();
        
        if (e instanceof Variable){
            return p;
        }
        else{
            product.add(p);
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
	return "tan";
    }

    @Override
    public void accept(DSEVisitor v) {
	v.visitTan(this);
    }
    
}
