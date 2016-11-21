/*
 *  University of Central Florida
 *  COP 3330
 *  Author: Jonathan Gillis
 */
package DataStructureElements.Visitor;

import DataStructureElements.Arccos;
import DataStructureElements.Arcsin;
import DataStructureElements.Arctan;
import DataStructureElements.Constant;
import DataStructureElements.Cos;
import DataStructureElements.Power;
import DataStructureElements.Product;
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
    
}
