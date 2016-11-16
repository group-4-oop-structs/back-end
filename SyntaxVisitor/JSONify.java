/*
 *  University of Central Florida
 *  COP 3330
 *  Author: Jonathan Gillis
 */
package SyntaxVisitor;

import Parser.Constant;
import Parser.Difference;
import Parser.Power;
import Parser.Product;
import Parser.Quotient;
import Parser.Sum;
import Parser.Variable;

/**
 *
 * @author gillis
 */
public class JSONify implements ExpressionVisitor {

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
