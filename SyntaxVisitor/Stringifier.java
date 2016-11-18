/*
 *  University of Central Florida
 *  COP 3330
 *  Author: Jonathan Gillis
 */
package SyntaxVisitor;

import Parser.BinaryExpression;
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
public class Stringifier  implements ExpressionVisitor {

    StringBuilder sb = new StringBuilder();
    static final int SUM_PRECEDENCE = 0,
	    PRODUCT_PRECEDENCE = 1,
	    EXPONENT_PRECEDENCE = 2;
    
    private int pastPrecedence = SUM_PRECEDENCE;
    
    private void stringifyBinaryExpression(BinaryExpression expr, char sep){
	expr.getLeft().accept(this);
	sb.append(sep);
	expr.getRight().accept(this);
    }
    
    @Override 
    public String toString(){
	return sb.toString();
    }
    
    @Override
    public void visitConstant(Constant expr) {
	sb.append(expr.getValue());
    }

    @Override
    public void visitVariable(Variable expr) {
	sb.append("x");
    }

    @Override
    public void visitPower(Power expr) {
	int precedence_save = pastPrecedence;
	pastPrecedence = EXPONENT_PRECEDENCE; 
	if(precedence_save > SUM_PRECEDENCE){
	    sb.append("(");
	    this.stringifyBinaryExpression(expr, '^');
	    sb.append(")");
	} else {
	    this.stringifyBinaryExpression(expr, '^');
	}
	pastPrecedence = precedence_save;
    }

    @Override
    public void visitSum(Sum expr) {
	int precedence_save = pastPrecedence;
	pastPrecedence = SUM_PRECEDENCE; 
	if(precedence_save > SUM_PRECEDENCE){
	    sb.append("(");
	    this.stringifyBinaryExpression(expr, '+');
	    sb.append(")");
	} else {
	    this.stringifyBinaryExpression(expr, '+');
	}
	
	pastPrecedence = precedence_save;
    }

    @Override
    public void visitDifference(Difference expr) {
	int precedence_save = pastPrecedence;
	pastPrecedence = SUM_PRECEDENCE; 
	if(precedence_save > SUM_PRECEDENCE){
	    sb.append("(");
	    this.stringifyBinaryExpression(expr, '-');
	    sb.append(")");
	} else {
	    this.stringifyBinaryExpression(expr, '-');
	}
	
	pastPrecedence = precedence_save;
    }

    @Override
    public void visitProduct(Product expr) {
	int precedence_save = pastPrecedence;
	pastPrecedence = PRODUCT_PRECEDENCE; 
	if(precedence_save > PRODUCT_PRECEDENCE){
	    sb.append("(");
	    this.stringifyBinaryExpression(expr, '*');
	    sb.append(")");
	} else {
	    this.stringifyBinaryExpression(expr, '*');
	}
	
	pastPrecedence = precedence_save;
    }

    @Override
    public void visitQuotient(Quotient expr) {
	int precedence_save = pastPrecedence;
	pastPrecedence = PRODUCT_PRECEDENCE; 
	if(precedence_save > PRODUCT_PRECEDENCE){
	    sb.append("(");
	    this.stringifyBinaryExpression(expr, '/');
	    sb.append(")");
	} else {
	    this.stringifyBinaryExpression(expr, '/');
	}
	
	pastPrecedence = precedence_save;
    }
    
}
