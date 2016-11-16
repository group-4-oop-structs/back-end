/*
 *  University of Central Florida
 *  COP 3330
 *  Author: Jonathan Gillis
 */
package SyntaxVisitor;

/**
 * Implements a visitor which "passes through" all operations
 * meaning every method unimplemented in the base class
 * calls expr.accept(this) on all child members
 * @author gillis
 */
abstract public class PassthroughVisitor {
    
}
