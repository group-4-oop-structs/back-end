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
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * NOTE: most of the algorithms in this file are implemented in the absolute
 * most naïve way possible, usually giving ugly results, 
 * but that are functionally correct.
 * @author gillis
 */
public class Differentiate implements ExpressionVisitor {

    Expression result;
    
    public static Expression differentiate(Expression e){
	Differentiate d = new Differentiate();
	e.accept(d);
	return d.getResult();
    }
    
    public Expression getResult(){
	return result;
    }
    
    public Differentiate(){
    }
    
    @Override
    public void visitConstant(Constant expr) {
	result = new Constant(0);
    }

    @Override
    public void visitVariable(Variable expr) {
	result = new Constant(1);
    }

    @Override
    public void visitPower(Power expr) {
	throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void visitSum(Sum expr) {
	expr.getLeft().accept(this);
	Expression left = result;
	expr.getRight().accept(this);
	result = new Sum(left, result);
    }

    @Override
    public void visitDifference(Difference expr) {
	expr.getLeft().accept(this);
	Expression left = result;
	expr.getRight().accept(this);
	result = new Difference(left, result);
    }

    @Override
    public void visitProduct(Product expr) {
	// (TODO): this results in seriously stupid answers for certain inputs
	// such as "3*x"
	// but this is the basic concept, I think, and it will evauluate the
	// correct values
	expr.getLeft().accept(this);
	Expression dleft = result;
	expr.getRight().accept(this);
	Expression dright = result;
	
	// NOTE: we are passing node from a different tree into a new tree
	// if we start storing the parent nodes of each node, this will break
	Product left = new Product(dleft, expr.getRight()),
		right = new Product(expr.getLeft(), dright);
	result = new Sum(left,right);
	
    }

    @Override
    public void visitQuotient(Quotient expr) {
	// (TODO): this results in seriously stupid answers for certain inputs
	// such as "3*x"
	// but this is the basic concept, I think, and it will evauluate the
	// correct values
	expr.getLeft().accept(this);
	Expression dleft = result;
	expr.getRight().accept(this);
	Expression dright = result;
	
	// NOTE: we are passing node from a different tree into a new tree
	// if we start storing the parent nodes of each node, this will break
	Product left = new Product(dleft, expr.getRight()),
		right = new Product(expr.getLeft(), dright);
	
	Difference numerator = new Difference(left, right);
	Power denominator = new Power(expr.getRight(), new Constant(2));
	result = new Quotient(numerator, denominator);
	
	
	throw new NotImplementedException();
    }
    
}
