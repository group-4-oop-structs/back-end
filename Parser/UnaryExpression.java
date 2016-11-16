/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parser;

public abstract class UnaryExpression implements Expression{
    Expression inner;
    
    public UnaryExpression(Expression in){
	this.inner = in;
    }
    public Expression getInner(){
        return this.inner;
    }
    
    public static UnaryExpression factory(String name, Expression inner)
    {
	switch(name){
	    
	    case "sin":
		
	    case "cos":
	    case "tan":
	    case "ln":
	    case "log":
	    default:
		throw new UnsupportedOperationException("Unary Expressions are not fully supported yet");
	}
    }
}
