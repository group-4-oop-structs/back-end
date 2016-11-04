package Syntax;

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
    
    private Parser() {
    }
    // TODO: get rid of this singleton pattern
    public static Parser getInstance() {
        return ParserHolder.INSTANCE;
    }
    
    private static class ParserHolder {

        private static final Parser INSTANCE = new Parser();
    }
    
    public boolean parse(ArrayList<Token> l){
        int numrparent = 0;
        int numlparent = 0;
        
        for (int i = l.size()-1; i >= 0; i--){
            this.s.add(l.get(i));
            if (l.get(i).getName() == ')')
                numrparent++;
            if (l.get(i).getName() == '(')
                numlparent++;
        }
        
        if (numrparent != numlparent){
            System.out.println("Missing parenthesis");
            Error();
        }        
        
        E();
        
        return true;
    }
    // PLEASE avoid naming things with just a single letter
    private void E(){
        T();
        while(eat(PLUSSYM) || eat(MINUSSYM)){
            T();
        }
    }
    
    private void T(){
        F();
        while(eat(MULTSYM)){
            F();
        }
    }
    
    private void F(){
        if(eat(LPARENTSYM)){
            if(eat(RPARENTSYM)){
                if (eat(POWSYM)){
                    if (!eat(NUMBERSYM)){
                        Error();
                    }
                }
            }
            else {
                Error();
            }
        }
        else if(eat(IDENTSYM)){            
            if (eat(POWSYM)){
                if (!eat(NUMBERSYM)){
                    Error();
                }
            }
            else{
            }
        }
        else if(eat(NUMBERSYM)){
            if (eat(POWSYM)){
                if (!eat(NUMBERSYM)){
                    Error();
                }
            }
        }
        else{
            Error();
        }
    }
    
    private void Error(){
        System.out.println("There's an error!!!");
        System.exit(0);
    }
    
    // omg this method
    private boolean eat(TokenType tok){
        if (s.isEmpty()) return false;
        Token temp = s.pop();
            switch(tok){
                case PLUSSYM:
                    if (temp.getName() != '+'){
                        s.push(temp);
                        return false;
                    }
                    break;
                case MINUSSYM:
                    if (temp.getName() != '-'){
                        s.push(temp);
                        return false;
                    }
                    break;
                case MULTSYM:
                    if (temp.getName() != '*'){
                        s.push(temp);
                        return false;
                    }
                    break;
                case POWSYM:
                    if (temp.getName() != '^'){
                        s.push(temp);
                        return false;
                    }
                    break;
                case LPARENTSYM:
                    if (temp.getName() != '('){
                        s.push(temp);
                        return false;
                    }
                    break;
                case RPARENTSYM:
                    if (temp.getName() != ')'){
                        s.push(temp);
                        return false;
                    }
                    break;
                case NUMBERSYM:
                    if (temp.getValue() == '\0'){
                        s.push(temp);
                        return false;
                    }
                    break;
                case IDENTSYM:
                    if (temp.getName() != 'x'){
                        s.push(temp);
                        return false;
                    }
                    break;
            }
        return true;
    }
}
