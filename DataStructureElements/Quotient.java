/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructureElements;

import DataStructureElements.Visitor.DSEVisitor;
import java.util.ArrayList;

/**
 *
 * @author rthec
 */
public class Quotient extends Container{
    Expression numerator;
    Expression denominator;

    public Quotient(Expression numerator, Expression denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public Expression getNumerator() {
        return numerator;
    }

    public Expression getDenominator() {
        return denominator;
    }
    
    @Override
    public Expression getExpression() {
        return this;
    }

    @Override
    public Expression getDerivative() {
        Quotient q;
        Product p1;
        Product p2;
        Power denom;
        Sum num;
        ArrayList<Expression> sum = new ArrayList<>();
        ArrayList<Expression> product1 = new ArrayList<>();
        ArrayList<Expression> product2 = new ArrayList<>();
        
        product1.add(denominator);
        product1.add(numerator.getDerivative());
        p1 = new Product(product1);
        
        product2.add(numerator);
        product2.add(denominator.getDerivative());
        p2 = new Product(product2);
        
        sum.add(p1);
        sum.add(p2);
        num = new Sum(sum);
        
        denom = new Power(2, denominator);
        
        return new Quotient(num, denom);
    }

    @Override
    public Expression getIntegral() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void accept(DSEVisitor v) {
	v.visitQuotient(this);
    }
    
    public int getPEMDASLevel() {
	return 2;
    }
    
}
