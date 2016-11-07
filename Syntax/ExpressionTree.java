/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Syntax;

import Parser.Constant;
import Parser.BinaryExpression;
import Parser.Product;
import Parser.Sum;
import Parser.Expression;
import Parser.Power;
import Parser.Difference;

public class ExpressionTree {
    private Expression root;
    private Expression cur;
    
    public ExpressionTree(){
        root = null;
        cur = null;
    }
    
    public void insert(TokenType id){
        if (cur instanceof BinaryExpression){
            switch(id){
                case PLUSSYM:
                    insert(new Sum(), (BinaryExpression) cur);
                    break;
                case MINUSSYM:
                    insert(new Difference(), (BinaryExpression) cur);
                    break;
                case MULTSYM:
                    insert(new Product(), (BinaryExpression) cur);
                    break;
                case IDENTSYM:
                    insert(new Variable(), (BinaryExpression) cur);
                    break;
                case NEGATESYM:
                    insert(new Negate(), (BinaryExpression) cur);
            }
        }
        else {
            switch(id){
                case PLUSSYM:
                    insert(new Sum(), (UnaryExpression) cur);
                    break;
                case MINUSSYM:
                    insert(new Difference(), (UnaryExpression) cur);
                    break;
                case MULTSYM:
                    insert(new Product(), (UnaryExpression) cur);
                    break;
                case IDENTSYM:
                    insert(new Variable(), (UnaryExpression) cur);
                    break;
                case NEGATESYM:
                    insert(new Negate(), (UnaryExpression) cur);
            }
        }
    }
    
    public void insert(TokenType id, double num){
        if (cur instanceof BinaryExpression){
            switch(id){
                case NUMBERSYM:
                    insert(new Constant(num), (BinaryExpression) cur);
                    break;
                case POWSYM:
                    insert(new Power(num), (BinaryExpression) cur);
                    break;
            }
        }
        else{
            switch(id){
                case NUMBERSYM:
                    insert(new Constant(num), (UnaryExpression) cur);
                    break;
                case POWSYM:
                    insert(new Power(num), (UnaryExpression) cur);
                    break;
            }
        }
    }
    
    private void insert(BinaryExpression e, BinaryExpression cur){    
        if (this.cur == null || this.cur instanceof UnaryExpression){
            e.setLeft(root);
            this.cur = e;
        }
        else{
            e.setLeft(this.cur);
            this.cur = e;
        }
    }
    
    private void insert(BinaryExpression e, UnaryExpression cur){    
        if (this.cur == null || this.cur instanceof UnaryExpression){
            e.setLeft(root);
            this.cur = e;
        }
        else{
            e.setLeft(this.cur);
            this.cur = e;
        }
    }
    
    private void insert(TerminalExpression e, BinaryExpression cur){
        if (root == null){
            root = e;
        }
        else {
            cur.setRight(e);
        }
    }
    
    private void insert(TerminalExpression e, UnaryExpression cur){
        if (root == null){
            root = e;
        }
        else {
            cur.setBase(e);
            
        }
    }
    
    private void insert(UnaryExpression e, BinaryExpression cur){
        if (root == null){
            root = e;
        }
        else{
            cur.setRight(e);
        }
    }
    
    private void insert(UnaryExpression e, UnaryExpression cur){
        if (root == null){
            root = e;
        }
        else {
            
        }
    }
    
    public Expression getRoot(){
        return this.root;
    }
}
