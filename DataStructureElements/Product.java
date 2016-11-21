/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructureElements;

import static DataStructureElements.Visitor.Compare.cmp;
import DataStructureElements.Visitor.DSEVisitor;
import java.util.*;

public class Product extends Container{
    private final ArrayList<Expression> holder;

    public Product(ArrayList<Expression> holder) {
        this.holder = (ArrayList<Expression>) holder.clone();
    }
    
    public ArrayList<Expression> getList() {
        return (ArrayList<Expression>) holder.clone();
    }   
    
    @Override
    public Expression getDerivative() {
        Sum s;
        Product p;
        Constant c = null;
        ArrayList<Expression> sumHolder = new ArrayList<>();
        ArrayList<Expression> holderD = new ArrayList<>();
        ArrayList<Expression> tempHolder = new ArrayList<>();
        ArrayList<Expression> pHolder = new ArrayList<>();
        
        int countExpressions = 0;
        
        
        for (int i = 0; i < holder.size(); i++){
            tempHolder.add(holder.get(i));
        }
        
        for (int i = 0; i < tempHolder.size(); i++){
            if (!(tempHolder.get(i) instanceof Constant)){
                countExpressions++;
                holderD.add(tempHolder.get(i).getDerivative());
            }
            else{
                c = new Constant(((Constant)tempHolder.get(i)).getValue());
                tempHolder.remove(i);
                i--;
            }
        }
        
        for (int i = 0; i < countExpressions; i++){
            ArrayList<Expression>  productHolder = new ArrayList<>();
            for (int j = 0; j < countExpressions; j++){
                if (i == j){
                    productHolder.add(holderD.get(i));
                }
                else{
                    productHolder.add(tempHolder.get(j));
                }
            }
            p = new Product(productHolder);
            sumHolder.add(p);
        }
        
        s = new Sum(sumHolder);
        if (c != null){
            if (sumHolder.size() == 0){
                return c.getDerivative();
            }
            pHolder.add(c);
            pHolder.add(s);
            p = new Product(pHolder);
            return p;
        }
        else {
            return s;
        }
    }

    @Override
    public Expression getIntegral() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Expression getExpression() {
        return this; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void accept(DSEVisitor v) {
	v.visitProduct(this);
    }

    @Override
    public int getPEMDASLevel() {
	return 2;
    }

    public boolean equals(Product po) {

	List<Expression> aterms = this.getList(), 
		oterms = po.getList();
	if(oterms.size() != aterms.size()){
	    return false;
	}
	
	for(int i =0; i< oterms.size(); i++){
	    Expression
		    oexpr = oterms.get(i),
		    aexpr = aterms.get(i);
	    
	    if(cmp(oexpr,aexpr) != 0){
		return false;
	    }
	}	
	return true;
    }
    
}
