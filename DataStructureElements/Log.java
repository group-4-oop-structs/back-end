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
public class Log extends UnaryExpression{
    Expression e;

    public Log(Expression e) {
        this.e = e;
    }

    public Expression getE() {
        return e;
    }       
    
    @Override
    public Expression getDerivative() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
