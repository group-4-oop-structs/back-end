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

    public Expression getE() {
        return e;
    }
    
    @Override
    public Expression getDerivative() {
        Expression d1;
        Expression d2;
        ArrayList<Factor> f = new ArrayList<>();
        
        if (e instanceof Variable){
            if (power == 2){
                return new Term(2, new Variable());
            }
            Power p = new Power(this.power-1, this.e);
            return new Term(this.power, p);
        }
        else {
            d1 = e.getDerivative();
            f.add(new Factor(d1));
            if (power == 2){
                d2 = new Term(2, this.e);
            }
            else {
                d2 = new Term(this.power, new Power(this.power-1, this.e));
            }
            f.add(new Factor(d2));
            return new Product(f);
        }
    }
    
}
