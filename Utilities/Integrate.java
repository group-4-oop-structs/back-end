/*
 *  University of Central Florida
 *  COP 3330
 *  Author: Jonathan Gillis
 */
package Utilities;

import DataStructureElements.Arccos;
import DataStructureElements.Arccot;
import DataStructureElements.Arccsc;
import DataStructureElements.Arcsec;
import DataStructureElements.Arcsin;
import DataStructureElements.Arctan;
import DataStructureElements.Constant;
import DataStructureElements.Cos;
import DataStructureElements.Cot;
import DataStructureElements.Csc;
import DataStructureElements.Exponential;
import DataStructureElements.Power;
import DataStructureElements.Product;
import DataStructureElements.Sec;
import DataStructureElements.Sin;
import DataStructureElements.Sum;
import DataStructureElements.Tan;
import DataStructureElements.*;
import DataStructureElements.Visitor.DSEVisitor;
import java.util.*;

/**
 *
 * @author gillis
 */
public class Integrate extends DSEVisitor {

    Expression result;
    
    public static  Expression integrate(Expression e){
	Integrate i = new Integrate();
	i.visit(e);
	return i.result;
    }
    
    @Override
    public void visitConstant(Constant aThis) {
	result = new Variable();
    }

    @Override
    public void visitVariable(Variable aThis) {
	ArrayList<Expression> factors = new ArrayList<>();
	factors.add(new Constant(1.0/2.0));
	factors.add(new Power(2, aThis));
	
	result = new Product(factors);
    }

    @Override
    public void visitProduct(Product aThis) {
	
	List<Expression> factors = aThis.getList();
	if(factors.size() ==1){
	    result = integrate(factors.get(0));
	    return;
	}
	
	List<Expression> nfactors= new ArrayList<>();
	
	
	ArrayList<Expression>coeffs = new ArrayList<>();
	for(Expression e : factors){
	    if(!(e instanceof Constant))
		nfactors.add(e);
	    else
		coeffs.add(e);
	}
	if(nfactors.size() !=factors.size()){
	    result =  integrate(nfactors.get(0));
	    coeffs.add(result);
	    result =  new Product(coeffs);
	}else if (nfactors.size() ==1){
	    result = integrate(nfactors.get(0));
	}else {
	    result = USub.sub(aThis);
	}
    }

    @Override
    public void visitSum(Sum aThis) {
	ArrayList<Expression> terms = aThis.getSum(),
		nsum = new ArrayList<>();
	for(Expression e : terms){
	    nsum.add(integrate(e));
	}
	result = new Sum(nsum);
    }

    @Override
    public void visitExponential(Exponential aThis) {
	throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void visitPower(Power aThis) {
	ArrayList<Expression> list = new ArrayList<>();
	
	double new_n = aThis.getPower()+1;
	list.add(new Constant(1.0/new_n));
	
	Power p = new Power(new_n, aThis.getExpression());
	list.add(p);
	result = new Product(list);
    }

    @Override
    public void visitTan(Tan aThis) {
	throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void visitSin(Sin aThis) {
	throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void visitCos(Cos aThis) {
	throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void visitATan(Arctan aThis) {
	throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void visitACos(Arccos aThis) {
	throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void visitASin(Arcsin aThis) {
	throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void visitACot(Arccot aThis) {
	throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void visitSec(Sec aThis) {
	throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void visitCSC(Csc aThis) {
	throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void visitASec(Arcsec aThis) {
	throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void visitACSC(Arccsc aThis) {
	throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void visitCot(Cot aThis) {
	throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void visitQuotient(Quotient aThis) {
	throw new UnsupportedOperationException("Not supported yet.");
    }
    
    
}


class USub extends Integrate { 
    public static Expression sub(Expression e){
	USub usub = new USub();
	usub.visit(e);
	return usub.result;
    }
    
    
    @Override
    public void visitProduct(Product p){
	
    }
    
}