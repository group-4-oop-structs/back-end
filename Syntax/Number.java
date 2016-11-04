/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Syntax;

public class Number extends Token{
    private final double value;
    
    public Number(double content){
        this.value = content;
    }
    
    @Override
    public double getValue(){
        return this.value;
    }
    
    @Override
    public String toString(){
        return "\nNumber: " + this.value;
    }

    @Override
    public char getName() {
        return '\0';
    }
}
