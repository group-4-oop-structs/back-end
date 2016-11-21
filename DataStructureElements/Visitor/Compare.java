/*
 *  University of Central Florida
 *  COP 3330
 *  Author: Jonathan Gillis
 */
package DataStructureElements.Visitor;

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
import DataStructureElements.Expression;
import DataStructureElements.Power;
import DataStructureElements.Product;
import DataStructureElements.Quotient;
import DataStructureElements.Sec;
import DataStructureElements.Sin;
import DataStructureElements.Sum;
import DataStructureElements.Tan;
import DataStructureElements.UnaryExpression;
import DataStructureElements.Variable;

/**
 *
 * @author gillis
 */
public class Compare extends DSEVisitor {
    Expression a,b;
    int cmp;
    Compare(Expression a, Expression b){
	this.a = a;
	this.b = b;
    }
    
    @Override
    public void visitVariable(Variable aThis) {
	throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void visitProduct(Product aThis) {
	throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void visitSum(Sum aThis) {
	throw new UnsupportedOperationException("Not supported yet.");
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
    public void visitATan(Arctan aThis) {
	throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void visitPower(Power aThis) {
	throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void visitACos(Arccos aThis) {
	throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void visitConstant(Constant aThis) {
	throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void visitCos(Cos aThis) {
	throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void visitASin(Arcsin aThis) {
	throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void visitACot(Arccot aThis) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void visitSec(Sec aThis) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void visitCSC(Csc aThis) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void visitASec(Arcsec aThis) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void visitACSC(Arccsc aThis) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void visitCot(Cot aThis) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void visitQuotient(Quotient aThis) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void visitExponential(Exponential aThis) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
