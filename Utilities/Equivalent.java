/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilities;

import DataStructureElements.*;
import java.util.*;

public class Equivalent {
    public static boolean isEqual(Expression e1, Expression e2){
        return (Stringifier.stringify(e1).compareTo(Stringifier.stringify(e2)) == 0);
    }
}
