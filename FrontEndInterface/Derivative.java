/*
 *  University of Central Florida
 *  COP 3330
 *  Author: Jonathan Gillis
 */
package FrontEndInterface;

import java.util.List;

/**
 *
 * @author gillis
 */
public class Derivative {
    String soln,
	    original;
    List<String> steps;

    public String getSoln() {
	return soln;
    }

    public void setSoln(String soln) {
	this.soln = soln;
    }

    public String getOriginal() {
	return original;
    }

    public void setOriginal(String original) {
	this.original = original;
    }

    public List<String> getSteps() {
	return steps;
    }

    public void setSteps(List<String> steps) {
	this.steps = steps;
    }	    
}
