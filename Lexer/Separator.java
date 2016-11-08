/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lexer;

public class Separator extends Token{
    private final char name;
    
    public Separator(char content){
       this.name = content; 
    }
    
    @Override
    public char getName(){
        return this.name;
    }
    
    @Override
    public String toString(){
        return "\nSeparator type: " + this.name;
    }

    @Override
    public double getValue() {
        return 100;  // TODO: this is arbitrary and stupid
    }
}