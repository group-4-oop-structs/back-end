/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilities;

import DataStructureElements.*;
import java.util.*;

public class ShrinkTree {
    public static Expression shrink(Expression e){
        Sum tempSum;
        Product tempProduct;
        if (!(e instanceof Container)){
            if (e instanceof Variable || e instanceof Constant)
                return e;
            else
                shrink(e.getExpression());
        }
        else {
            ArrayList<Expression> holder = new ArrayList<>();
            if (e instanceof Container){
                if (e instanceof Sum){
                    holder = ((Sum)e).getSum();
                    for (int i = 0; i < holder.size(); i++){
                        shrink(holder.get(i));
                        if (holder.get(i) instanceof Sum){
                            tempSum = (Sum) holder.get(i);
                            holder.addAll(tempSum.getSum());
                            holder.remove(i);
                        }
                    }
                }
                else if (e instanceof Product){
                    holder = ((Product)e).getList();
                    for (int i = 0; i < holder.size(); i++){
                        shrink(holder.get(i));
                        if (holder.get(i) instanceof Sum){
                            tempSum = (Sum) holder.get(i);
                            if (tempSum.getSum().size() == 1 && 
                                    tempSum.getSum().get(0) instanceof Product){
                                tempProduct = (Product) tempSum.getSum().get(0);
                                holder.addAll(tempProduct.getList());
                                holder.remove(i);
                            }                                
                        }
                        if (holder.get(i) instanceof Product){
                            tempProduct = (Product) holder.get(i);
                            holder.addAll(tempProduct.getList());
                            holder.remove(i);
                        }
                    }
                }
            }
        }
        return e;
    }
}
