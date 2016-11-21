/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilities;

import DataStructureElements.*;
import java.util.*;

public class Stringifier {
    public static String string;
    public static String stringify(Expression e){
        string = "";
        printExpression(e);
        return string;
    }
    
    private static void printExpression(Expression e){
        if (e instanceof Sum){
            printSum((Sum) e);
        }
        else if (e instanceof Product){
            printProduct((Product) e);
        }
        else if (e instanceof Power){
            printPower((Power) e);
        }
        else if (e instanceof Variable){
            string += "x";
        }
        else if (e instanceof Constant){
            string += ((Constant) e).getValue();
        }
    }
    
    private static void printSum(Sum s){
        ArrayList<Expression> list = s.getSum();        
        
        printExpression(list.get(0));
        
        for(int i = 1; i < list.size(); i++){
            string += " + ";
            printExpression(list.get(i));            
        }
    }
    
    private static void printProduct(Product p){
        ArrayList<Expression> list = p.getList();
        if (list.get(0).getExpression() instanceof Sum){
            string += "(";
            printExpression(list.get(0));
            string += ")";
        }
        else{
            printExpression(list.get(0));
        }
        
        for (int i = 1; i < list.size(); i++){
            string += " * ";
            if (list.get(i).getExpression() instanceof Sum){
                string += "(";
                printExpression(list.get(i));
                string += ")";
            }
            else{
                printExpression(list.get(i));   
            }    
                     
        }
    }
    
    private static void printPower(Power p){
        if (p.getExpression() instanceof Variable){
            string += "x";
        }
        else {
            string += "(";
            printExpression(p.getExpression());
            string += ")";
        }
        string += "^";
        string += p.getPower();
    }
}
