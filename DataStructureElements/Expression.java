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
public abstract class Expression {
    public abstract Expression getExpression();
    public abstract Expression getDerivative();
    public abstract Expression getIntegral();
    
    public abstract void accept(DSEVisitor v);
    public abstract int getPEMDASLevel();
}
