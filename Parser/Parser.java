/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parser;

import java.util.*;
import Lexer.*;
import DataStructureElements.*;
import Utilities.ShrinkTree;
import Utilities.Simplify;

public class Parser {
    private Expression e;
    private ArrayDeque<Token> stack = new ArrayDeque<>();
    public static Expression parseString(String s){
	Lexer l = new Lexer();
	Parser p = new Parser();
	return p.parse(l.lex(s));
    }
    
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
        if (sum.size() == 1){
            return sum.get(0);
        }
        Expression s = new Sum(sum);
        s = ShrinkTree.shrink(s);
        Expression simple = Simplify.simplifySum((Sum) s);
        return simple;
    }
    
    private Expression gatherFactors(){
        ArrayList<Expression> product = new ArrayList<>();        
        
        gatherer(product);
        
        while (!stack.isEmpty() && stack.peek().getSym() == TokenType.MULTSYM){
            stack.pop();
            gatherer(product);
        }        
        
        Expression p = new Product(product);
        p = ShrinkTree.shrink(p);
        p = Simplify.simplifyProduct((Product) p);
        
        if (product.size() >= 1){
            return p;
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
            if (!stack.isEmpty() && stack.peek().getSym() == TokenType.POWSYM){
                stack.pop();
                if (stack.peek().getSym() == TokenType.LPARENTSYM){
                    stack.pop();
                    Container temp = (Container) gatherTerms();
                    //insert error if no rparent
                    stack.pop();
                    if (temp.getList().size() == 1 && temp.getList().get(0) instanceof Variable)
                        product.add(new Exponential(val, temp.getList().get(0)));
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
                Container temp = (Container) gatherTerms();
                //insert error if no rparent
                stack.pop();
                if (temp.getList().size() == 1 && temp.getList().get(0) instanceof Variable)
                    product.add(new Sin(temp.getList().get(0)));
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
                Container temp = (Container) gatherTerms();
                //insert error if no rparent
                stack.pop();
                if (temp.getList().size() == 1 && temp.getList().get(0) instanceof Variable)
                    product.add(new Cos(temp.getList().get(0)));
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
                Container temp = (Container) gatherTerms();
                //insert error if no rparent
                stack.pop();
                if (temp.getList().size() == 1 && temp.getList().get(0) instanceof Variable)
                    product.add(new Tan(temp.getList().get(0)));
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
                Container temp = (Container) gatherTerms();
                //insert error if no rparent
                stack.pop();
                if (temp.getList().size() == 1 && temp.getList().get(0) instanceof Variable)
                    product.add(new Sec(temp.getList().get(0)));
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
                Container temp = (Container) gatherTerms();
                //insert error if no rparent
                stack.pop();
                if (temp.getList().size() == 1 && temp.getList().get(0) instanceof Variable)
                    product.add(new Csc(temp.getList().get(0)));
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
                Container temp = (Container) gatherTerms();
                //insert error if no rparent
                stack.pop();
                if (temp.getList().size() == 1 && temp.getList().get(0) instanceof Variable)
                    product.add(new Cot(temp.getList().get(0)));
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
                if (stack.peek().getSym() == TokenType.MINUSSYM){
                    stack.pop();
                    product.add(new Power(-stack.pop().getValue(), new Variable()));
                }
                else{
                    product.add(new Power(stack.pop().getValue(), new Variable()));
                }
                
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
                if (stack.peek().getSym() == TokenType.MINUSSYM){
                    stack.pop();
                    product.add(new Power(-stack.pop().getValue(), temp));
                }
                product.add(new Power(stack.pop().getValue(), temp));
            }
            else if (!stack.isEmpty() && stack.peek().getSym() == TokenType.DIVSYM){
                Expression num = temp;
                stack.pop();
                if (stack.peek().getSym() == TokenType.LPARENTSYM){
                    stack.pop();
                    Expression denom = gatherTerms();
                    //insert error if no rparent
                    stack.pop();
                    product.add(new Quotient(num, denom));
                }
                else {
                    if (stack.peek().getSym() == TokenType.NUMBERSYM){
                        product.add(new Quotient(num, new Constant(stack.pop().getValue())));
                    }
                    else if (stack.peek().getSym() == TokenType.IDENTSYM){
                        stack.pop();
                        product.add(new Quotient(num, new Variable()));
                    }
                    //insert stuff for other unary operations
                }
            }
            else {
                product.add(temp);
            }
        }
    }
}
