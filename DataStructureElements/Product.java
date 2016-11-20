/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructureElements;

import java.util.*;

public class Product extends Container{
    private ArrayList<Factor> holder = new ArrayList<>();

    public Product(ArrayList<Factor> holder) {
        this.holder = holder;
    }
    
    public ArrayList<Factor> getProduct() {
        return holder;
    }   
    
    @Override
    public Expression getDerivative() {
        ArrayList<Factor> holderD = new ArrayList<>();
        ArrayList<Term> derivative = new ArrayList<>();
        double coefficient = 1;

        for (int i = 0; i < holder.size(); i++){
            Expression d = holder.get(i).getDerivative();
            Term castd;
            holderD.add(new Factor(holder.get(i).getDerivative()));
            ArrayList<Factor> temp = new ArrayList<>();
            for (int j = 0; j < holder.size(); j++){
                if (i == j){
                    temp.add(holderD.get(i));
                }
                else{
                    temp.add(holder.get(j));
                }
            }
            Product ptemp = new Product(temp);            
            derivative.add(new Term(1, ptemp));  
        }
        
        return new Sum(derivative);
    }

    @Override
    public Expression getIntegral() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
