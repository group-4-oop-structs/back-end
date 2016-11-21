/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructureElements;

import java.util.*;

public class Product extends Container{
    private ArrayList<Expression> holder = new ArrayList<>();

    public Product(ArrayList<Expression> holder) {
        this.holder = holder;
    }
    
    public ArrayList<Expression> getList() {
        return holder;
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
    
}
