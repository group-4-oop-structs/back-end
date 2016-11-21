/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructureElements;

import java.util.*;

public class Sum extends Container{
    private ArrayList<Expression> holder = new ArrayList<>();
    
    public Sum(ArrayList<Expression> holder){
        this.holder = holder;        
    }

    public ArrayList<Expression> getSum() {
        return holder;
    }
    
    @Override
    public Expression getDerivative() {
       Sum s;
       ArrayList<Expression> holderD = new ArrayList<>();
       
       for (int i = 0; i < holder.size(); i++){
           holderD.add(holder.get(i).getDerivative());
       }
       
       s = new Sum(holderD);
       
       return s;
    }

    @Override
    public Expression getIntegral() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Expression getExpression() {
        return this; //To change body of generated methods, choose Tools | Templates.
    }
    
}
