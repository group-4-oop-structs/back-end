/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parser;

import Parser.Expression;

public abstract class UnaryExpression implements Expression{
    Expression inner;
    
    public UnaryExpression(Expression in){
	this.inner = in;
    }
    public Expression getInner(){
        return this.inner;
    }
}