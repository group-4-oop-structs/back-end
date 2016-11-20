/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructureElements;

/**
 *
 * @author rthec
 */
public class Constant extends TerminalExpression{

    public Constant() {
    }
    
    @Override
    public Expression getDerivative() {
        return new Term(0, new Constant());
    }
    
}
