/*
 *  University of Central Florida
 *  COP 3330
 *  Author: Jonathan Gillis
 */
package Parser;

/**
 *
 * @author gillis
 */
public class SyntaxError extends Throwable {

    SyntaxError(String missing_) {
	super(missing_);
    }
    
}
