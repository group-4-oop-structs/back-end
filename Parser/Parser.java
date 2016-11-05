package Parser;

import Syntax.Token;
import Syntax.TokenType;
import java.util.ArrayList;
import java.util.Stack;

public class Parser {
    private final Stack<Token> s = new Stack<>();
    private final TokenType PLUSSYM = TokenType.PLUSSYM;
    private final TokenType MINUSSYM = TokenType.MINUSSYM;
    private final TokenType MULTSYM = TokenType.MULTSYM;
    private final TokenType POWSYM = TokenType.POWSYM;
    private final TokenType LPARENTSYM = TokenType.LPARENTSYM;
    private final TokenType RPARENTSYM = TokenType.RPARENTSYM;
    private final TokenType NUMBERSYM = TokenType.NUMBERSYM;
    private final TokenType IDENTSYM = TokenType.IDENTSYM;
    
    Parser() {
    }
    public Expression parse(ArrayList<Token> l) throws SyntaxError{
        int numrparent = 0;
        int numlparent = 0;
        s.addAll(l);
	
	return PEMDAS();
    }
    
    private Expression PEMDAS() throws SyntaxError{
	    Expression lhs = PEMD();
	    if(next(TokenType.PLUSSYM)){
		Token sep = eat(TokenType.PLUSSYM);
		Expression rhs = PEMDAS();
		return new Sum(lhs, rhs);
	    } else if (next(TokenType.MINUSSYM)) {
		Token sep = eat(TokenType.MINUSSYM);
		Expression rhs = PEMDAS();
		return new Difference(lhs, rhs);
	    }
	    return lhs;
    }
    
    private Expression PEMD() throws SyntaxError{
	Expression lhs = PE();
	
	if(next(TokenType.MULTSYM)){
	    Token sep = eat(TokenType.MULTSYM);
	    Expression rhs = PE();
	    return new Product(lhs,rhs);
	} else if (eat(TokenType.DIVISIONSYM) != null) {
	    Token sep = eat(TokenType.DIVISIONSYM);
	    Expression rhs = new Quotient(lhs,rhs);
	}
	
	return lhs;
    }
    
    private Expression PE() throws SyntaxError{
	Expression lhs = P();
	
	Token sep = eat(TokenType.POWSYM);
	if(sep != null){
	    Expression rhs = PE();
	    return new Power(lhs,rhs);
	    
	}
	
	return lhs;
    }
    
    private Expression P() throws SyntaxError{
       boolean isPositive = true;	
	if(eat(TokenType.MINUSSYM) != null){
	   isPositive = false;
        }
	eat(TokenType.PLUSSYM);
       
	// Check for a parenthesized expression
	if(eat(TokenType.LPARENTSYM) != null){
	    Expression inside = PEMDAS();
	    if(eat(TokenType.RPARENTSYM) != null)
		return inside;
	    else 
		throw new SyntaxError("Missing ')'");
	} else if(next(TokenType.NUMBERSYM)){
	    Token num = eat(TokenType.NUMBERSYM);
	    
	    if ((atom = this.atom()) != null)
	}
    }
    
    private boolean next(TokenType type){
	if (s.empty()) return false;
	return s.firstElement().isType(type);
    }
    
    // omg this method
    private Token eat(TokenType tok){
        if(!next(tok))
	    return null;
	return s.pop();
    }
}