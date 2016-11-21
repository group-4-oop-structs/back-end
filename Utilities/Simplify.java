package Utilities;

import DataStructureElements.*;
import java.util.*;

public class Simplify {    
    public static Sum simplifySum(Sum s){
        ArrayList<Expression> terms = s.getSum();
        ArrayList<Expression> newTerms = new ArrayList<>();
        boolean hit = false;
        
        newTerms.add(terms.get(0));
        
        for (int i = 1; i < terms.size(); i++){
            for (int j = 0; j < newTerms.size(); j++){
		String s1 = makeSumString(terms.get(i));
		String s2 = makeSumString(newTerms.get(j));
                if (s1.equals(s2)){
		    newTerms.add(terms.get(i));
                    break;
                }
            }   
        }
        Sum simple = new Sum(newTerms);
        return simple;
    }
    
    static String makeSumString(Expression e){
	if(e instanceof Product){
	    Product p = (Product) e;
	    ArrayList<Expression> l= p.getList(),
		    temp = new ArrayList();
	    for(Expression ex : l){
		if(!(ex instanceof Constant)){ 
	 	    temp.add(ex);
		}
	    }
	    p = new Product(temp);
	    return Stringifier.stringify(p);   
	} else {
	    return Stringifier.stringify(e);
	}
    }
    

    
    static ArrayList<Expression> withoutConstants(List<Expression> l1){
	
	ArrayList<Expression> result = new ArrayList<>();
	Constant c;
	for(Expression e : l1){
	    if(!(e instanceof Constant)){
		result.add(e);
	    } else {
		c = (Constant) e;
	    }
	}
	return result;
    }
    
    public static Product simplifyProduct(Product p){
	double coeff = 1;
	List<Expression> list = p.getList();
	Map<String, Double> powers =  new HashMap<>();
	
	for(Expression e : list) {
	    if(e instanceof Constant){
		Constant c = (Constant) e;
		coeff *= c.getValue();
	    } else if (e instanceof Power) {
		Power power = (Power) e;
		double pwr = power.getPower();
		String key = Stringifier.stringify(power.getExpression());
		double d = powers.getOrDefault(key, 0d);
		powers.put(key, d+pwr);
	    } else {
		String key = Stringifier.stringify(e);
		double d = powers.getOrDefault(key, 0d);
		powers.put(key, d+1);
	    }
	}
	
	ArrayList<Expression> newFactors = new ArrayList<>();
	if(coeff == 0){
	    newFactors.add(new Constant(0));
	    return new Product(newFactors);
	}
	if(coeff != 1.0){
	    newFactors.add(new Constant(coeff));
	}
	
	for(String s : powers.keySet()){
	    double e = powers.get(s);
	    if(e == 0){
		continue; // note: this isn't always the right thing to do
		// this will definitely cause a bug in some situations
		// If you are looking at this, because you are debugging a problem
		// check this logic.
		
		// the problem is the possibility of an empty list though
	    }
	    if(e != 1.0){
		// this is janky
		newFactors.add(new Power(e, Parser.Parser.parseString(s)));
	    } else if (coeff == 0){
		newFactors.add(Parser.Parser.parseString(s));
	    }
	}
	
	return new Product(newFactors);
    }
}
