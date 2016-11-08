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
public interface ExpressionVisitor {
    public void visitConstant(Constant expr);
    public void visitVariable(Variable expr);
    public void visitPower(Power expr);
    public void visitSum(Sum expr);
    public void visitDifference(Difference expr);
    public void visitProduct(Product expr);
    public void visitQuotient(Quotient expr);
    
}
