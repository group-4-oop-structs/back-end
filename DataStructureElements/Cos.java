/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructureElements;

import java.util.*;

/**
 *
 * @author rthec
 */
public class Cos extends UnaryExpression{
    Expression e;

    public Cos(Expression e) {
        this.e = e;
    }

    @Override
    public Expression getExpression() {
        return e;
    }
    
        
    @Override
    public Expression getDerivative() {
        Sin s = new Sin(e);
        ArrayList<Expression> product = new ArrayList<>();
        product.add(new Constant(-1));
        product.add(s);
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
    
}
