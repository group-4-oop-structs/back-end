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
import DataStructureElements.Visitor.Compare;
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
	factors.add(new Constant(1.0/2.0d));
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
	
	double n = aThis.getPower();
	if(n == -1.0d){
	    result = new Ln(aThis.getExpression());
	} else if (aThis.getExpression() instanceof Variable){
	    list.add(new Constant(1.0/(n+1)));

	    Power p = new Power(n+1, aThis.getExpression());
	    list.add(p);
	    result = ShrinkTree.shrink(new Product(list));
	} else {
	    throw new UnsupportedOperationException("needs to be expanded");
	}
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
	Expression inner = aThis.getExpression();
	inner = ShrinkTree.shrink(inner);
	if(!(inner instanceof Variable))
	    throw new UnsupportedOperationException("too advanced of a usub");
	result = new Sin(inner);
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
	ArrayList<Expression> all = (ArrayList<Expression>) p.getList().clone();
	all = removeConstants(all);
	
	for(int split =0; split<= all.size(); split++ ){
	    ArrayList<Expression>
		    left = (ArrayList<Expression>) all.subList(0, split),
		    right = (ArrayList<Expression>) all.subList(split, all.size());
	    
	    Product pl = new Product(left);
	    pl = Simplify.simplifyProduct(pl);
	    Product pr = new Product(right);
	    pr = Simplify.simplifyProduct(pr);
	    Expression eleft = ShrinkTree.shrink(pl), 
		    eright = ShrinkTree.shrink(pr);
	    Expression dleft = ShrinkTree.shrink(eleft.getDerivative());
	    Expression dright = ShrinkTree.shrink(eright.getDerivative());
	    if(Compare.cmp(pl, dleft) == 0){
		result =  Integrate.integrate(pl);
		return;
	    } else if(Compare.cmp(pr, dright) == 0){
		result =  Integrate.integrate(pr);
		return;
	    }
	    
	}
	Expression dleft = ShrinkTree.shrink(all.get(0).getDerivative());
//	dleft = removeConstants(dleft);
	Expression dright = all.get(1).getDerivative();
//	dright = removeConstants(dright);
	
	dright = ShrinkTree.shrink(dright);
	if(Compare.cmp(all.get(0), dleft) == 0){
	    result = Integrate.integrate(all.get(0));
	} else if (Compare.cmp(all.get(1), dright) == 0){
	    result = Integrate.integrate(all.get(1));
	}
	throw new UnsupportedOperationException("too hard of a usub");
    }
    
    static ArrayList<Expression> removeConstants(ArrayList<Expression> l){
	ArrayList<Expression> n = new ArrayList<>();
	for(Expression e : l){
	    if(!(e instanceof Constant))
		n.add(e);
	}
	return n;
    }
    
}