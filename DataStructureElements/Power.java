/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructureElements;

import java.util.*;

public class Power extends UnaryExpression{
    private double power;
    private Expression e;

    public Power(double power, Expression e) {
        this.power = power;
        this.e = e;
    }
    
    public double getPower() {
        return power;
    }

    @Override
    public Expression getExpression() {
        return e;
    }
    
    @Override
    public Expression getDerivative() {
        Product p;
        ArrayList<Expression> product = new ArrayList<>();
        
        if (power > 2){
            product.add(new Constant(power));
            product.add(new Power(power-1,e));
        }
        else {
            product.add(new Constant(power));
            product.add(e);
        }
        
        if (!(e instanceof Variable)){
            product.add(e.getDerivative());
        }
        
        p = new Product(product);
        
        return p;
    }

    @Override
    public Expression getIntegral() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
