/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructureElements;

import java.util.ArrayList;
import DataStructureElements.Visitor.DSEVisitor;
import Utilities.ShrinkTree;
import Utilities.Simplify;
import Utilities.Stringifier;

/**
 *
 * @author rthec
 */
public class Cot extends UnaryExpression{
    Expression e;

    public Cot(Expression e) {
        this.e = e;
    }

    public Expression getExpression() {
        return e;
    }

    @Override
    public String getName() {
	return "cot";
    }

    @Override
    public void accept(DSEVisitor v) {
	v.visitCot(this);
    }

    public Expression getUsub() {
        return new Cot(new Variable());
    }
    
}
