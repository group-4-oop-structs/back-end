/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructureElements;

import DataStructureElements.Visitor.Compare;
import DataStructureElements.Visitor.DSEVisitor;
import java.util.*;
import java.lang.Math;
public class Exponential extends Expression {
    Double base;
    Expression e;

    public Exponential(Double base, Expression e) {
        this.base = base;
        this.e = e;
    }

    public Double getBase() {
        return base;
    }
    
    @Override
    public Expression getExpression() {
        return e;
    }

    @Override
    public Expression getDerivative() {
        ArrayList<Expression> product = new ArrayList<>();
        product.add(new Constant(Math.log(this.base)));
        product.add(this);
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

    @Override
    public void accept(DSEVisitor v) {
	v.visitExponential(this);
    }

    @Override
    public int getPEMDASLevel() {
	return 3;
    }
    
    public boolean equals(Exponential o) {
	if(getBase() == o.getBase() && Compare.cmp(e, o.e) ==0)
	    return true;
	else
	    return false;
    }

    
} 
