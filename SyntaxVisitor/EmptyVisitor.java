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
public class EmptyVisitor implements ExpressionVisitor {

    @Override
    public void visitConstant(Constant expr) {

    }

    @Override
    public void visitVariable(Variable expr) {
    }

    @Override
    public void visitPower(Power expr) {
    }

    @Override
    public void visitSum(Sum expr) {
    }

    @Override
    public void visitDifference(Difference expr) {
    }

    @Override
    public void visitProduct(Product expr) {
    }

    @Override
    public void visitQuotient(Quotient expr) {
    }
    
}
