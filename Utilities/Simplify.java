package Utilities;

import DataStructureElements.*;
import java.util.*;

public class Simplify {

    static boolean isSimplifying = false;
    public static Sum simplifySum(Sum s){
	ArrayList<Expression> withCoefficients = new ArrayList<>();
        ArrayList<Expression> withoutCoefficients = new ArrayList<>();
        ArrayList<Expression> holder = new ArrayList<>();
        ArrayList<Expression> pHolder = new ArrayList<>();
        ArrayList<Expression> temp = new ArrayList<>();
        Product pTerm;
        Constant c;
        Product p;
        
        
        holder = s.getSum();
        if (holder.get(0) instanceof Product){
            p = (Product) holder.get(0);
            if (p.getList().get(0) instanceof Constant){
                c = (Constant) p.getList().get(0);
                if (c.getValue() == 1){
                    temp = p.getList();
                    temp.remove(0);
                    holder.remove(0);
                    holder.add(0, new Product(temp));
                    return new Sum(holder);
                }
                else if (c.getValue() == 0){
                    holder.clear();
                    holder.add(new Constant(0));
                    return new Sum(holder);
                }
            }
        }
        
        for (int i = 0; i < holder.size(); i++){
            if (holder.get(i) instanceof Product){
                pTerm = (Product) holder.get(i);
                pHolder = pTerm.getList();
                if (pHolder.get(0) instanceof Constant){
                    
                }
            }
        }
        
        return s;
    }
           
    public static Product simplifyProduct(Product p){
	ArrayList<Expression> withoutConstants = new ArrayList<>();
        ArrayList<Expression> holder = new ArrayList<>();
        ArrayList<Constant> constants = new ArrayList<>();
        ArrayList<Expression> newHolder = new ArrayList<>();
        Product simpleProduct;
        boolean hit = false;
        
        holder = p.getList();
        if (holder.size() == 1 && !(holder.get(0) instanceof Constant)){
            holder.add(0, new Constant(1));
            simpleProduct = new Product(holder);
            return simpleProduct;
        }
        
        constants = removeConstants(holder);
        
        
        //Multiplies all constants in a product together
        for (int i = 1; i < constants.size(); i++){
            double temp = constants.get(0).getValue();
            constants.get(0).setValue(temp * constants.get(i).getValue());
        }
        
        if (holder.isEmpty()){
            newHolder.add(constants.get(0));
            simpleProduct = new Product(newHolder);
            return simpleProduct;
        }
        
        //Multiplies all terms that can be multiplied together
        newHolder.add(holder.get(0));
        for (int i = 1; i < holder.size(); i++){
            hit = false;
            for (int j = 0; j < newHolder.size(); j++){
                Expression temp1;
                Expression temp2;
                Power ptemp;
                temp1 = holder.get(i);
                temp2 = newHolder.get(j);                                    
                if (temp1 instanceof Power && temp2 instanceof Power){
                    if (Stringifier.stringify(temp1.getExpression()).compareTo(Stringifier.stringify(temp2.getExpression())) == 0){
                        ptemp = new Power(((Power)temp1).getPower() + ((Power)temp1).getPower(), temp1.getExpression());
                        newHolder.remove(j);
                        newHolder.add(j, ptemp);
                        hit = true;
                        break;
                    }
                }
                else if (temp1 instanceof Power && !(temp2 instanceof Power)){                                       
                    if (Stringifier.stringify(temp1.getExpression()).compareTo(Stringifier.stringify(temp2.getExpression())) == 0){
                        ((Power)temp1).setPower(((Power)temp1).getPower()+1); 
                        ptemp = (Power) temp1;
                        newHolder.remove(j);
                        newHolder.add(j, ptemp);
                        hit = true;
                        break;
                    }
                }
                 else if (temp2 instanceof Power && !(temp1 instanceof Power)){
                    if (Stringifier.stringify(temp1.getExpression()).compareTo(Stringifier.stringify(temp2.getExpression())) == 0){
                        ((Power)temp2).setPower(((Power)temp2).getPower()+1);
                        ptemp = (Power) temp2;
                        newHolder.remove(j);
                        newHolder.add(j, ptemp);
                        hit = true;
                        break;
                    }                    
                }
                 else {
                    if (Stringifier.stringify(temp1.getExpression()).compareTo(Stringifier.stringify(temp2.getExpression())) == 0){
                        ptemp = new Power(2, temp1);
                        newHolder.remove(j);
                        newHolder.add(j, ptemp);
                        hit = true;
                        break;
                    }                     
                }                
            }
            if (!hit){
                newHolder.add(holder.get(i));
            }
        }
        
        if (constants.isEmpty())
            constants.add(new Constant(1));
        
        newHolder.add(0, constants.get(0));
        simpleProduct = new Product(newHolder);
        return simpleProduct;
    }
    
    //Removes constants from holder and returns a list of the removed constants
    public static ArrayList<Constant> removeConstants(ArrayList<Expression> product){
        ArrayList<Constant> constants = new ArrayList<>();
        
        for (int i = 0; i < product.size(); i++){
            if(product.get(i) instanceof Constant){
                constants.add((Constant) product.get(i));
                product.remove(i);
                i--;
            }
        }
        
        return constants;
    }
    
}
