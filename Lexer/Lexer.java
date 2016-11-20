package Lexer;

import java.util.ArrayList;

public class Lexer {
    private static final String separators = "+-*/^()";
    private static final String[] reservedWords = {"sin", "cos", "tan", "ln", "log"};
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
                switch (separators.charAt(e)){
                    case '+':
                        holder.add(new Separator(separators.charAt(e), TokenType.PLUSSYM));
                        break;
                    case '-':
                        holder.add(new Separator(separators.charAt(e), TokenType.MINUSSYM));
                        break;
                    case '*':
                        holder.add(new Separator(separators.charAt(e), TokenType.MULTSYM));
                        break;
                    case '/':
                        holder.add(new Separator(separators.charAt(e), TokenType.DIVSYM));
                        break;
                    case '^':
                        holder.add(new Separator(separators.charAt(e), TokenType.POWSYM));
                        break;
                    case '(':
                        holder.add(new Separator(separators.charAt(e), TokenType.LPARENTSYM));
                        break;
                    case ')':
                        holder.add(new Separator(separators.charAt(e), TokenType.RPARENTSYM));
                        break;
                }
                
            }            
            else if (separated[i].compareToIgnoreCase("x") == 0){
                holder.add(new Identifier("x", TokenType.IDENTSYM));
            }
            else if (isNumeric(separated[i])){
                holder.add(new Number(Double.parseDouble(separated[i]), TokenType.NUMBERSYM));
            }
            else {
                for (int j = 0; j < reservedWords.length; j++){
                    if (separated[i].compareToIgnoreCase(reservedWords[j]) == 0){
                        if (j == 0)
                            holder.add(new Identifier(reservedWords[j], TokenType.SINSYM));
                        else if (j == 1)
                            holder.add(new Identifier(reservedWords[j], TokenType.COSSYM));
                        else if (j == 2)
                            holder.add(new Identifier(reservedWords[j], TokenType.TANSYM));
                    }
                }
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
