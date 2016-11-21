/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructureElements;

import DataStructureElements.Visitor.DSEVisitor;

/**
 *
 * @author rthec
 */
public class Csc extends UnaryExpression{
    Expression inner;    

    public Csc(Expression e) {
        this.inner = e;
    }

    public Expression getExpression() {
        return inner;
    }
    
    @Override
    public Expression getDerivative() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Expression getIntegral() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getName() {
	return "csc";
    }

    @Override
    public void accept(DSEVisitor v) {
	v.visitCSC(this);
    }
    
}
