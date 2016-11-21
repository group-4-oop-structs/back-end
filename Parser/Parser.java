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
        ArrayList<Expression> sum = new ArrayList<>();
        
        sum.add(gatherFactors());
        while (!stack.isEmpty() && (stack.peek().getSym() == TokenType.PLUSSYM || stack.peek().getSym() == TokenType.MINUSSYM)){
            if (stack.peek().getSym() == TokenType.PLUSSYM){
                stack.pop();
            }
            sum.add(gatherFactors());
        }
        Sum s = new Sum(sum);
        //Sum simple = Simplify.simplifySum(s);
        return s;
    }
    
    private Expression gatherFactors(){
        ArrayList<Expression> product = new ArrayList<>();        
        
        gatherer(product);
        
        while (!stack.isEmpty() && stack.peek().getSym() == TokenType.MULTSYM){
            stack.pop();
            gatherer(product);
        }        
        
        if (product.size() == 1){
            return product.get(0);
        }
        else if (product.size() > 1){
            return new Product(product);
        }
        else{
            throw new UnsupportedOperationException("Not supported yet.");
        }
    }
    
    private void gatherer(ArrayList<Expression> product){
        if (stack.peek().getSym() == TokenType.MINUSSYM){
            product.add(new Constant(-1));
            stack.pop();
        }
        if (stack.peek().getSym() == TokenType.NUMBERSYM){
            double val = stack.pop().getValue();
            if (stack.peek().getSym() == TokenType.POWSYM){
                stack.pop();
                if (stack.peek().getSym() == TokenType.LPARENTSYM){
                    stack.pop();
                    Sum temp = (Sum) gatherTerms();
                    //insert error if no rparent
                    stack.pop();
                    if (temp.getSum().size() == 1 && temp.getSum().get(0) instanceof Variable)
                        product.add(new Exponential(val, temp.getSum().get(0)));
                    else
                        product.add(new Exponential(val, temp));
                }
                else {
                    //insert error if no x
                    stack.pop();
                    product.add(new Exponential(val, new Variable()));
                }
            }
            else{
                product.add(new Constant(val));
            }
        }
        else if (stack.peek().getSym() == TokenType.SINSYM){
            stack.pop();
 
            if (stack.peek().getSym() == TokenType.LPARENTSYM){
                stack.pop();
                Sum temp = (Sum) gatherTerms();
                //insert error if no rparent
                stack.pop();
                if (temp.getSum().size() == 1 && temp.getSum().get(0) instanceof Variable)
                    product.add(new Sin(temp.getSum().get(0)));
                else
                    product.add(new Sin(temp));
            }
            else {
                //insert error if no x
                stack.pop();
                product.add(new Sin(new Variable()));
            }
        }
        else if (stack.peek().getSym() == TokenType.COSSYM){
            stack.pop();
 
            if (stack.peek().getSym() == TokenType.LPARENTSYM){
                stack.pop();
                Sum temp = (Sum) gatherTerms();
                //insert error if no rparent
                stack.pop();
                if (temp.getSum().size() == 1 && temp.getSum().get(0) instanceof Variable)
                    product.add(new Cos(temp.getSum().get(0)));
                else
                    product.add(new Cos(temp));
            }
            else {
                //insert error if no x
                stack.pop();
                product.add(new Cos(new Variable()));
            }
        }
        else if (stack.peek().getSym() == TokenType.TANSYM){
            stack.pop();
 
            if (stack.peek().getSym() == TokenType.LPARENTSYM){
                stack.pop();
                Sum temp = (Sum) gatherTerms();
                //insert error if no rparent
                stack.pop();
                if (temp.getSum().size() == 1 && temp.getSum().get(0) instanceof Variable)
                    product.add(new Tan(temp.getSum().get(0)));
                else
                    product.add(new Tan(temp));
            }
            else {
                //insert error if no x
                stack.pop();
                product.add(new Tan(new Variable()));
            }
        }
        else if (stack.peek().getSym() == TokenType.SECSYM){
            stack.pop();
 
            if (stack.peek().getSym() == TokenType.LPARENTSYM){
                stack.pop();
                Sum temp = (Sum) gatherTerms();
                //insert error if no rparent
                stack.pop();
                if (temp.getSum().size() == 1 && temp.getSum().get(0) instanceof Variable)
                    product.add(new Sec(temp.getSum().get(0)));
                else
                    product.add(new Sec(temp));
            }
            else {
                //insert error if no x
                stack.pop();
                product.add(new Sec(new Variable()));
            }
        }
        else if (stack.peek().getSym() == TokenType.CSCSYM){
            stack.pop();
 
            if (stack.peek().getSym() == TokenType.LPARENTSYM){
                stack.pop();
                Sum temp = (Sum) gatherTerms();
                //insert error if no rparent
                stack.pop();
                if (temp.getSum().size() == 1 && temp.getSum().get(0) instanceof Variable)
                    product.add(new Csc(temp.getSum().get(0)));
                else
                    product.add(new Csc(temp));
            }
            else {
                //insert error if no x
                stack.pop();
                product.add(new Csc(new Variable()));
            }
        }
        else if (stack.peek().getSym() == TokenType.COTSYM){
            stack.pop();
 
            if (stack.peek().getSym() == TokenType.LPARENTSYM){
                stack.pop();
                Sum temp = (Sum) gatherTerms();
                //insert error if no rparent
                stack.pop();
                if (temp.getSum().size() == 1 && temp.getSum().get(0) instanceof Variable)
                    product.add(new Cot(temp.getSum().get(0)));
                else
                    product.add(new Cot(temp));
            }
            else {
                //insert error if no x
                stack.pop();
                product.add(new Cot(new Variable()));
            }
        }
        else if (stack.peek().getSym() == TokenType.IDENTSYM){
            stack.pop();
            if (!stack.isEmpty() && stack.peek().getSym() == TokenType.POWSYM){
                stack.pop();
                //insert error if not a number
                product.add(new Power(stack.pop().getValue(), new Variable()));
            }
            else {
                product.add(new Variable());
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
                product.add(p);
            }
            else {
                product.add(temp);
            }
        }
    }
}
