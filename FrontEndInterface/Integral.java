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
public class Integral {
    String soln;
    String original;
    String x1;
    String x2;
    List<String> Steps;

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

    public String getX1() {
	return x1;
    }

    public void setX1(String x1) {
	this.x1 = x1;
    }

    public String getX2() {
	return x2;
    }

    public void setX2(String x2) {
	this.x2 = x2;
    }

    public List<String> getSteps() {
	return Steps;
    }

    public void setSteps(List<String> Steps) {
	this.Steps = Steps;
    }
    
    
}