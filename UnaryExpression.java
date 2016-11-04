/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Syntax;

public abstract class UnaryExpression extends Expression{
    Expression base;
    
    public void setBase(Expression b){
        this.base = b;
    }
    
    public Expression getBase(){
        return this.base;
    }
}
