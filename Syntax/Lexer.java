package Syntax;

import java.util.ArrayList;

public class Lexer {
    private static final String separators = "+-*^()";
    private Lexer() {
    }
    
    public static Lexer getInstance() {
        return LexerHolder.INSTANCE;
    }
    
    private static class LexerHolder {

        private static final Lexer INSTANCE = new Lexer();
    }
    
    public ArrayList<Token> lex(String expression){
        char[] content = expression.toCharArray();
        char[] buffer = new char[expression.length()];
        String[] separated = new String[expression.length()];
        ArrayList<Token> holder = new ArrayList<>();
        int bufferCount = 0;
        int numWords = 0;
        
        for(int i = 0; i < expression.length(); i++){
            if (content[i] == ' ' | separators.indexOf(content[i]) >= 0){
                if (bufferCount > 0){
                    separated[numWords] = "";
                    for (int j = 0; j < bufferCount; j++)
                        separated[numWords] = separated[numWords] + buffer[j];
                    numWords++;
                    bufferCount = 0;
                    buffer = new char[expression.length()];
                }
                if (separators.indexOf(content[i]) >= 0){
                    separated[numWords] = String.valueOf(content[i]);
                    numWords++;
                }
            }
            else{
                buffer[bufferCount] = content[i];
                bufferCount++;
            }
        }
        
        if (bufferCount > 0){
            separated[numWords] = "";
            for (int j = 0; j < bufferCount; j++)
                        separated[numWords] = separated[numWords] + buffer[j];
            numWords++;
        }
        
        for (int i = 0; i < numWords; i++){
            if (separators.contains(separated[i])){
                int e = separators.indexOf(separated[i]);
                holder.add(new Separator(separators.charAt(e)));
            }            
            else if (separated[i].compareToIgnoreCase("x") == 0){
                holder.add(new Identifier('x'));
            }
            else if (isNumeric(separated[i])){
                holder.add(new Number(Double.parseDouble(separated[i])));
            }
            else {
                System.out.println(separated[i] + " is invalid token or identifier.");
            }
        }
        return holder;
    }
    
    private static boolean isNumeric(String str){
        try{
            double d = Double.parseDouble(str);
        }
        catch(NumberFormatException nfe){
            return false;
        }
        return true;
    }
}
