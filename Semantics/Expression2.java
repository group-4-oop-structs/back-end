/*
 *  University of Central Florida
 *  COP 3330
 *  Author: Jonathan Gillis
 */
package Semantics;

import Parser.Variable;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author gillis
 */
abstract public class Expression2 {
    
    final Set<Variable> dependencies;
    Expression2(Set<Variable> deps){
	this.dependencies = deps;
    }
    
    Expression2(Expression2[] args){
	Set<Variable> deps = new HashSet<>();
	for(Expression2 e : args){
	    deps.addAll(e.getDependencies());
	}
	this.dependencies = deps;
    }
    
    public Set<Variable> getDependencies(){
	return dependencies;
    }
    
   
    public abstract void accept();
    
    public static int compareOrder(Expression2 lhs, Expression2 rhs, Variable v){
	throw new UnsupportedOperationException();
    }
    
    
    
}
