/*
 *  University of Central Florida
 *  COP 3330
 *  Author: Jonathan Gillis
 */
package Simplification;

import Parser.Constant;
import Parser.Difference;
import Parser.Expression;
import Parser.Power;
import Parser.Product;
import Parser.Quotient;
import Parser.Sum;
import Parser.Variable;
import SyntaxVisitor.ExpressionVisitor;

/**
 *
 * @author gillis
 */
public class IdentityProperty implements ExpressionVisitor{

    enum Operation {
	PRODUCT, SUM, POWER_BASE, POWER_EXP;
    }
    
    Operation parentop;
    Expression result;
    
    @Override
    public void visitConstant(Constant expr) {
	throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void visitVariable(Variable expr) {
	throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void visitPower(Power expr) {
	throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void visitSum(Sum expr) {
	throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void visitDifference(Difference expr) {
	throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void visitProduct(Product expr) {
	throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void visitQuotient(Quotient expr) {
	throw new UnsupportedOperationException("Not supported yet.");
    }
        
}


class SumIdentity extends IdentityProperty {
    
}