/*
 *  University of Central Florida
 *  COP 3330
 *  Author: Jonathan Gillis
 */
package FrontEndInterface;

import DataStructureElements.Expression;
import Parser.Parser;
import Utilities.Integrate;
import Utilities.Stringifier;

/**
 *
 * @author gillis
 */
public class Controller {
    
    public static Integral solveIntegral(String s){
	
	Expression e = Parser.parseString(s);
	Expression i = Integrate.integrate(e);
	Integral in = new Integral();
	
	in.setOriginal(Stringifier.stringify(e));
	in.setSoln(Stringifier.stringify(i));
	
	return in;
    }
    
    public static Derivative solve(String s){
	Derivative d = new Derivative();
	Expression e = Parser.parseString(s);
	Expression ddx = e.getDerivative();
	d.setOriginal(Stringifier.stringify(e));
	d.setSoln(Stringifier.stringify(ddx));
	
		
	
	return d;
    }
}
