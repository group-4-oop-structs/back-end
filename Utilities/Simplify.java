package Utilities;

import DataStructureElements.*;
import java.util.*;

public class Simplify {
    public static Sum simplifySum(Sum s){
        ArrayList<Term> terms = s.getSum();
        ArrayList<Term> newTerms = new ArrayList<>();
        boolean hit = false;
        
        newTerms.add(terms.get(0));
        
        for (int i = 1; i < terms.size(); i++){
            hit = false;
            for (int j = 0; j < newTerms.size(); j++){
                if (Equivalent.isEqual(terms.get(i).getExpression(), newTerms.get(j).getExpression())){
                    newTerms.get(j).setCoefficient(newTerms.get(j).getCoefficient() + terms.get(i).getCoefficient());
                    hit = true;
                    break;
                }
            }
            if (!hit)
                newTerms.add(terms.get(i));
        }
        Sum simple = new Sum(newTerms);
        return simple;
    }
    public static Product simplifyProduct(Product p){
        ArrayList<Factor> factors = p.getProduct();
        ArrayList<Factor> newFactors = new ArrayList<>();
        
        newFactors.add(factors.get(0));

        for (int i = 0; i < factors.size(); i++){
            for (int j = 0; j < newFactors.size(); j++){
                
            }
        }
        
        Product simple = p;
        return p;
    }
}
