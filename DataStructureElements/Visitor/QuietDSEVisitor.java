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
import DataStructureElements.Power;
import DataStructureElements.Product;
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
public class QuietDSEVisitor extends DSEVisitor {

    @Override
    public void visitVariable(Variable aThis) {
    }

    @Override
    public void visitProduct(Product aThis) {
    }

    @Override
    public void visitSum(Sum aThis) {
    }

    @Override
    public void visitTan(Tan aThis) {

    }

    @Override
    public void visitSin(Sin aThis) {
    }

    @Override
    public void visitATan(Arctan aThis) {
    }

    @Override
    public void visitPower(Power aThis) {
    }

    @Override
    public void visitACos(Arccos aThis) {
    }
    
    @Override
    public void visitConstant(Constant aThis) {
    }

    @Override
    public void visitCos(Cos aThis) {
    }

    @Override
    public void visitASin(Arcsin aThis) {
    }

    @Override
    public void visitACot(Arccot aThis) {
    }

    @Override
    public void visitSec(Sec aThis) {
    }

    @Override
    public void visitCSC(Csc aThis) {
    }

    @Override
    public void visitASec(Arcsec aThis) {
    }

    @Override
    public void visitACSC(Arccsc aThis) {
    }

    @Override
    public void visitCot(Cot aThis) {
    }
    
}
