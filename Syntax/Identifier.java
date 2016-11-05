/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Syntax;

public class Identifier extends Token{
    private final char name; 
    public static TokenType type = TokenType.IDENTSYM;
    
    public Identifier(char content){
        this.name = content;
    }
    @Override
    public char getName(){
        return this.name;
    }
    @Override
    public String toString(){
        return "\nIdentifier: " + this.name;
    }
    
    
}