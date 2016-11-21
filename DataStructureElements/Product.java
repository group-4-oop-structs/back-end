/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructureElements;

import DataStructureElements.Visitor.DSEVisitor;
import java.util.*;

public class Product extends Container{
    private final ArrayList<Expression> holder;

    public Product(ArrayList<Expression> holder) {
        this.holder = (ArrayList<Expression>) holder.clone();
    }
    
    public ArrayList<Expression> getList() {
        return (ArrayList<Expression>) holder.clone();
    }   
    
    @Override
    public Expression getDerivative() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Expression getIntegral() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Expression getExpression() {
        return this; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void accept(DSEVisitor v) {
	v.visitProduct(this);
    }

    @Override
    public int getPEMDASLevel() {
	return 2;
    }
    
}
