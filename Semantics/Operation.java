/*
 *  University of Central Florida
 *  COP 3330
 *  Author: Jonathan Gillis
 */
package Semantics;

/**
 *
 * @author gillis
 */
public interface Operation {
    public Operation getParent();
    public int getPrecedence();
}
