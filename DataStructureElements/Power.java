/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructureElements;

import DataStructureElements.Visitor.DSEVisitor;
import java.util.*;

public class Power extends Expression{
    private double power;
    private Expression base;

    public Power(double power, Expression e) {
        this.power = power;
        this.base = e;
    }
    
    public double getPower() {
        return power;
    }

    @Override
    public Expression getExpression() {
        return base;
    }
    
    @Override
    public Expression getDerivative() {
        Product p;
        ArrayList<Expression> product = new ArrayList<>();
        
        if (power > 2){
            product.add(new Constant(power));
            product.add(new Power(power-1,base));
        }
        else {
            product.add(new Constant(power));
            product.add(base);
        }
        
        if (!(base instanceof Variable)){
            product.add(base.getDerivative());
        }
        
        p = new Product(product);
        
        return p;
    }

    @Override
    public Expression getIntegral() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void accept(DSEVisitor v) {
	v.visitPower(this);
    }

    @Override
    public int getPEMDASLevel() {
	return 3;
    }
}
