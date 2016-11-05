package Syntax;

public abstract class Token {
    @Override
    public abstract String toString();
    
    public abstract TokenType getType();
    public abstract boolean isType(TokenType type);
}
