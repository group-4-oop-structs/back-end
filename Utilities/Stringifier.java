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
        else if (e instanceof Term){
            string += ((Term)e).getCoefficient();
            string += "*";
            printExpression(((Term)e).getExpression());
        }
    }
    
    private static void printSum(Sum s){
        ArrayList<Term> list = s.getSum();
        string += list.get(0).getCoefficient() + "*";
        if (list.get(0).getExpression() instanceof Sum){
            string += "(";
            printExpression(list.get(0).getExpression());
            string += ")";
        }
        else{
            printExpression(list.get(0).getExpression());
        }
        
        for(int i = 1; i < list.size(); i++){
            string += " + ";
            string += list.get(i).getCoefficient() + "*";
            printExpression(list.get(i).getExpression());            
        }
    }
    
    private static void printProduct(Product p){
        ArrayList<Factor> list = p.getProduct();
        if (list.get(0).getExpression() instanceof Sum){
            string += "(";
            printExpression(list.get(0).getExpression());
            string += ")";
        }
        else{
            printExpression(list.get(0).getExpression());
        }
        
        for (int i = 1; i < list.size(); i++){
            string += " * ";
            if (list.get(i).getExpression() instanceof Sum){
                string += "(";
                printExpression(list.get(i).getExpression());
                string += ")";
            }
            else{
                printExpression(list.get(i).getExpression());   
            }    
                     
        }
    }
    
    private static void printPower(Power p){
        if (p.getE() instanceof Variable){
            string += "x";
        }
        else {
            string += "(";
            printExpression(p.getE());
            string += ")";
        }
        string += "^";
        string += p.getPower();
    }
}
