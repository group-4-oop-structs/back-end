/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructureElements;

import java.util.*;

public class Term extends Element{
    private double coefficient;
    private Expression e;

    public Term(double coefficient, Expression e){
        this.coefficient = coefficient;
        this.e = e;
    }
    
    public double getCoefficient() {
        return coefficient;
    }

    public Expression getExpression() {
        return e;
    }    

    public void setCoefficient(double coefficient) {
        this.coefficient = coefficient;
    }
    
    @Override
    public Expression getDerivative() {
        Term t = new Term(1,e.getDerivative());
        return new Term(t.getCoefficient() * this.coefficient, t.getExpression());
    }    
}
