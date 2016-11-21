/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructureElements;

import java.util.*;

public class Power extends UnaryExpression{
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
        return e;
    }
    
    @Override
    public Expression getDerivative() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Expression getIntegral() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
