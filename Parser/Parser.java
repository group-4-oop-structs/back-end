package Parser;

import Lexer.Token;
import Lexer.TokenType;
import java.util.ArrayList;
import java.util.Stack;

public class Parser {
    private final Stack<Token> s = new Stack<>();
    
    public Parser() {
    }
    public Expression parse(ArrayList<Token> l) throws SyntaxError{
        int numrparent = 0;
        int numlparent = 0;
	for(int i=l.size()-1; i >=0; i--)
	    s.add(l.get(i));
	return gatherTerms();
    }
    
    private Expression gatherTerms() throws SyntaxError{
	
	Expression lhs = gatherCoefficients();
	if(next(TokenType.PLUSSYM)){
	    Token sep = eat(TokenType.PLUSSYM);
	    Expression rhs = gatherTerms();
	    return new Sum(lhs, rhs);
	} else if (next(TokenType.MINUSSYM)) {
	    Token sep = eat(TokenType.MINUSSYM);
	    Expression rhs = gatherTerms();
	    return new Difference(lhs, rhs);
	}
	return lhs;
    }
    
    private Expression gatherCoefficients() throws SyntaxError{
	Expression lhs = gatherPowers();
	
	if(next(TokenType.MULTSYM)){
	    Token sep = eat(TokenType.MULTSYM);
	    Expression rhs = gatherPowers();
	    return new Product(lhs,rhs);
	} else if (eat(TokenType.DIVISIONSYM) != null) {
	    Token sep = eat(TokenType.DIVISIONSYM);
	    Expression rhs = gatherPowers();  
	    return new Quotient(lhs,rhs);
	}
	
	return lhs;
    }
    
    private Expression gatherPowers() throws SyntaxError{
	Expression lhs = gatherUnaryExpression();
	
	Token sep = eat(TokenType.POWSYM);
	if(sep != null){
	    Expression rhs = gatherPowers();
	    return new Power(lhs,rhs);
	    
	}
	
	return lhs;
    }
    
    private Expression gatherUnaryExpression() throws SyntaxError{	
	if(eat(TokenType.MINUSSYM) != null){
	   Expression inside = gatherUnsignedUnaryExpression();
	   return new Product(new Constant(-1), inside);
        }
	eat(TokenType.PLUSSYM);
	
	return gatherUnsignedUnaryExpression();
	
    }
    
    private Expression gatherUnsignedUnaryExpression() throws SyntaxError{
	if (next(TokenType.IDENTSYM)){
	    //check for the presence of an identifier
	    Token id = eat(TokenType.IDENTSYM);
	    // TODO: for now only identifiers which represent a variable 
	    // are supported
	    return new Variable();
	}
	
	// Check for a parenthesized expression
	else if(eat(TokenType.LPARENTSYM) != null){
	    Expression inside = gatherTerms();
	    
	    if(eat(TokenType.RPARENTSYM) == null)
		throw new SyntaxError("Missing ')'");
	    else
		return inside;
	} else if(next(TokenType.NUMBERSYM)){
	    // Check for a numeric constant
	    // TODO: this is a really stupid way of doing this
	    Token num = eat(TokenType.NUMBERSYM);
	    String str = num.toString();
	    
	    String[] split = str.split(" ");
	    double d = Double.parseDouble(split[1]);
	    return new Constant(d);
	} else if(next(TokenType.RPARENTSYM)){
	    throw new SyntaxError("Error: unmatched )");
	}
	
	throw new SyntaxError("Unknown Error");
    }
    
    
    // TODO: This method is so dumb
    public boolean next(TokenType type){
        if (s.isEmpty()) return false;
        Token temp = s.peek();
            switch(type){
                case PLUSSYM:
                    if (temp.getName() == '+')
                        return true;
                    return false;
                case MINUSSYM:
                    if (temp.getName() == '-')
                        return true;
                    return false;
                case MULTSYM:
                    if (temp.getName() == '*')
                        return true;
                    return false;
                case POWSYM:
                    if (temp.getName() == '^')
                        return true;
                    return false;
                case LPARENTSYM:
                    if (temp.getName() == '(')
                        return true;
                    return false;
                case RPARENTSYM:
                    if (temp.getName() == ')')
                        return true;
                    return false;
                case NUMBERSYM:
                    if (temp.getName() == '\0')   //
                        return true;              //
                    return false;                 //  TODO: this is confusing and stupid
                case IDENTSYM:                    //
                    if (temp.getValue() == '\0')  //
                        return true;
                    return false;    
            }
        return false;
    }

    
    public Token eat(TokenType tok){
        if(!next(tok))
	    return null;
	return s.pop();
    }
}