/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructureElements;

import java.util.*;

public class Sin extends UnaryExpression{
    Expression e;

    public Sin(Expression e) {
        this.e = e;
    }

    public Expression getExpression() {
        return e;
    }
    
        
    @Override
    public Expression getDerivative() {
        Cos c = new Cos(e);
        ArrayList<Expression> product = new ArrayList<>();
        
        if (e instanceof Variable){
            return c;
        }
        else {
            product.add(c);
            product.add(e.getDerivative());
            return new Product(product);
        }
    }

    @Override
    public Expression getIntegral() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
