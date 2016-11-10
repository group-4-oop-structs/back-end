/*
 *  University of Central Florida
 *  COP 3330
 *  Author: Jonathan Gillis
 */
package SyntaxVisitor;

import Parser.Constant;
import Parser.Difference;
import Parser.Expression;
import Parser.Power;
import Parser.Product;
import Parser.Quotient;
import Parser.Sum;
import Parser.Variable;

/**
 *
 * @author gillis
 */
public class Evaluate implements ExpressionVisitor {
    double value = 0.0;
    double xval;
    Expression expr;
    
    public static double evaluate(Expression expr, double x){
	Evaluate e = new Evaluate(expr);
	return e.at(x);
    }
    
    public Evaluate(Expression e){
	this.expr = e;
    }
    
    public double at(double xval){
	this.xval = xval;
	expr.accept(this);
	return value;
    }
    
    @Override
    public void visitConstant(Constant expr) {
	value = expr.getValue();
    }

    @Override
    public void visitVariable(Variable expr) {
	value = xval;
    }

    @Override
    public void visitPower(Power expr) {
	Expression base = expr.getLeft();
	double b = Evaluate.evaluate(base,xval);
	Expression exponent = expr.getRight();
	double e = evaluate(exponent, xval);
	value = Math.pow(b, e);
    }

    @Override
    public void visitSum(Sum expr) {
	value += evaluate(expr.getLeft(), xval);
	value += evaluate(expr.getRight(), xval);
    }

    @Override
    public void visitDifference(Difference expr) {
	value += evaluate(expr.getLeft(), xval);
	value -= evaluate(expr.getRight(), xval);
    }

    @Override
    public void visitProduct(Product expr) {
	value = evaluate(expr.getLeft(), xval);
	value *= evaluate(expr.getRight(), xval);
    }

    @Override
    public void visitQuotient(Quotient expr) {
	value = evaluate(expr.getLeft(), xval);
	value /= evaluate(expr.getRight(), xval);
    }
    
}
