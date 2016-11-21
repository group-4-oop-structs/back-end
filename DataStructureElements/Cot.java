/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructureElements;

import java.util.ArrayList;

/**
 *
 * @author rthec
 */
public class Cot extends UnaryExpression{
    Expression e;

    public Cot(Expression e) {
        this.e = e;
    }

    public Expression getExpression() {
        return e;
    }
    
    @Override
    public Expression getDerivative() {
        Power p = new Power(2, new Csc(e));
        ArrayList<Expression> product = new ArrayList<>();
        product.add(new Constant(-1));
        product.add(p);
        if (e instanceof Variable){
            return new Product(product);
        }
        else{
            product.add(e.getDerivative());
            return new Product(product);
        }
    }

    @Override
    public Expression getIntegral() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
