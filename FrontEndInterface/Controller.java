/*
 *  University of Central Florida
 *  COP 3330
 *  Author: Jonathan Gillis
 */
package FrontEndInterface;

import DataStructureElements.Expression;
import Parser.Parser;
import Utilities.Derive;
import Utilities.Integrate;
import Utilities.Stringifier;

/**
 *
 * @author gillis
 */
public class Controller {
    
    public Integral solveIntegral(String s){
	
	Expression e = Parser.parseString(s);
	Expression i = Integrate.integrate(e);
	Integral in = new Integral();
	
	in.setOriginal(Stringifier.stringify(e));
	in.setSoln(Stringifier.stringify(i));
	in.setSteps(Integrate.getSteps());
        
	return in;
    }
    
    public Derivative solveDerivative(String s){
	Expression e = Parser.parseString(s);
	Expression d = Derive.derive(e);
        Derivative ddx = new Derivative();
        
	ddx.setOriginal(Stringifier.stringify(e));
	ddx.setSoln(Stringifier.stringify(d));
	ddx.setSteps(Derive.getSteps());
        
	return ddx;
    }
}
