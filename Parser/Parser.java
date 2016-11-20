/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parser;

import java.util.*;
import Lexer.*;
import DataStructureElements.*;
import Utilities.Simplify;

public class Parser {
    private Expression e;
    private ArrayDeque<Token> stack = new ArrayDeque<>();
    
    public Expression parse(ArrayList<Token> list){
        for (int i = list.size()-1; i >= 0; i--){
            stack.push(list.get(i));
        }
        
        e = gatherTerms();
        
        return e;
    }
    
    private Expression gatherTerms(){
        ArrayList<Term> sum = new ArrayList<>();
        
        sum.add(gatherFactors());
        while (!stack.isEmpty() && (stack.peek().getSym() == TokenType.PLUSSYM || stack.peek().getSym() == TokenType.MINUSSYM)){
            if (stack.peek().getSym() == TokenType.PLUSSYM){
                stack.pop();
            }
            sum.add(gatherFactors());
        }
        Sum s = new Sum(sum);
        Sum simple = Simplify.simplifySum(s);
        return simple;
    }
    
    private Term gatherFactors(){
        ArrayList<Factor> product = new ArrayList<>();
        double coefficient = 1;
        
        
        if (stack.peek().getSym() == TokenType.MINUSSYM){
            coefficient *= -1;
            stack.pop();
        }
        if (stack.peek().getSym() == TokenType.NUMBERSYM){
            coefficient *= stack.pop().getValue();
        }
        else if (stack.peek().getSym() == TokenType.IDENTSYM){
            stack.pop();
            if (!stack.isEmpty() && stack.peek().getSym() == TokenType.POWSYM){
                stack.pop();
                //insert error if not a number
                product.add(new Factor(new Power(stack.pop().getValue(), new Variable())));
            }
            else {
                product.add(new Factor(new Variable()));
            }
        }
        else if (stack.peek().getSym() == TokenType.LPARENTSYM){
            stack.pop();
            Expression temp = gatherTerms();
            //insert error if no rparent
            stack.pop();
            if (!stack.isEmpty() && stack.peek().getSym() == TokenType.POWSYM){
                stack.pop();
                Power p = new Power(stack.pop().getValue(), temp);
                product.add(new Factor(p));
            }
            else {
                product.add(new Factor(temp));
            }
        }
        
        
        while (!stack.isEmpty() && stack.peek().getSym() == TokenType.MULTSYM){
            stack.pop();
            if (stack.peek().getSym() == TokenType.MINUSSYM){
                coefficient = -1;
                stack.pop();
            }
            if (stack.peek().getSym() == TokenType.NUMBERSYM){
                coefficient *= stack.pop().getValue();
            }
            else if (stack.peek().getSym() == TokenType.IDENTSYM){
                stack.pop();
                if (!stack.isEmpty() && stack.peek().getSym() == TokenType.POWSYM){
                    stack.pop();
                    //insert error if not a number
                    product.add(new Factor(new Power(stack.pop().getValue(), new Variable())));
                }
                else {
                    product.add(new Factor(new Variable()));
                }
            }
            else if (stack.peek().getSym() == TokenType.LPARENTSYM){
                stack.pop();
                Expression temp = gatherTerms();
                //insert error if no rparent
                stack.pop();
                if (!stack.isEmpty() && stack.peek().getSym() == TokenType.POWSYM){
                    stack.pop();
                    Power p = new Power(stack.pop().getValue(), temp);
                    product.add(new Factor(p));
                }
                else {
                    product.add(new Factor(temp));
                }
            }
        }
        
        
        if (product.isEmpty()){
            return new Term(coefficient, new Constant());
        }        
        else if (product.size() == 1){
            return new Term(coefficient, product.get(0).getExpression());
        }
        else {
            return new Term(coefficient, new Product(product));
        }
    }
}
