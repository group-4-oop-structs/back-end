/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructureElements;

import java.util.*;

public class Sum extends Container{
    private ArrayList<Term> holder = new ArrayList<>();
    
    public Sum(ArrayList<Term> holder){
        this.holder = holder;
    }

    public ArrayList<Term> getSum() {
        return holder;
    }
    
    @Override
    public Expression getDerivative() {
        ArrayList<Term> holderD = new ArrayList<>();
        for (int i = 0; i < holder.size(); i++){
            Expression d = holder.get(i).getExpression().getDerivative();
            Term castd;
            if (d instanceof Term){
                castd = (Term) d;
                castd.setCoefficient(castd.getCoefficient() * holder.get(i).getCoefficient());
                holderD.add(castd);
            }
            else if(d instanceof Sum){
                holderD.add(new Term(holder.get(i).getCoefficient(), d));
            }
            else if(d instanceof Product){
                holderD.add(new Term(1, d));
            }
        }
        
        return new Sum(holderD);
    }
    
}
