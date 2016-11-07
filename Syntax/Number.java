/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Syntax;

import Syntax.Token;
import Syntax.TokenType;

public class Number extends Token{
    private final double value;
    
    public Number(double content){
        this.value = content;
    }
    
    @Override
    public String toString(){
        return "\nNumber: " + this.value;
    }
    public double getValue(){
	return value;
    }

    @Override
    public TokenType getType() {
	throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isType(TokenType type) {
	throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
