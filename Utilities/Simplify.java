package Utilities;

import DataStructureElements.*;
import java.util.*;

public class Simplify {

    static boolean isSimplifying = false;
    public static Sum simplifySum(Sum s){
	if(isSimplifying){
	    return s;
	} else
	    isSimplifying = true;
	
        ArrayList<Expression> terms = s.getSum();
        Map<String, Double> newTerms = new HashMap<>();
        boolean hit = false;
        
        newTerms.put(makeSumString(terms.get(0)),getCoefficient(terms.get(0)));
	
        
        for (int i = 1; i < terms.size(); i++){
	    String key = makeSumString(terms.get(i));
	    double newcoeff = getCoefficient(terms.get(i));
	    double old = newTerms.getOrDefault(key, 0.0d);
	    newTerms.put(key, old+newcoeff);
        }
        
	ArrayList<Expression> newtermslist = new ArrayList<>();
	for (Iterator<String> it = newTerms.keySet().iterator(); it.hasNext();) {
	    String str = it.next();
	    double ncoeff = newTerms.get(str);
	    if(ncoeff == 0){
		continue; // note: this may not always be the thing to do
		// like, what if there is an empty list? 
	    } else if( ncoeff ==1.0 ){
		newtermslist.add(Parser.Parser.parseString(str));
	    } else {
		String nstring = ncoeff + " * (" + str + ")";
		newtermslist.add(Parser.Parser.parseString(nstring));
	    }
	}
	
	isSimplifying = false;
        return new Sum(newtermslist);
    }
    
    static double getCoefficient(Expression e){
	if(e instanceof Product){
	    ArrayList<Expression> l = ((Product)e).getList();
	    for(Expression ex : l){
		if(ex instanceof Constant)
		    return( (Constant) ex).getValue();
	    }
	} else if (e instanceof Constant){
	    return ((Constant) e).getValue();
	}
	return 1;	    
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
	if(isSimplifying){
	    return p;
	} else
	    isSimplifying = true;
	
	
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
	isSimplifying = false;
	return new Product(newFactors);
    }
}
