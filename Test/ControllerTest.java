/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import FrontEndInterface.Controller;
import FrontEndInterface.Derivative;
import FrontEndInterface.Integral;

/**
 *
 * @author rthec
 */
public class ControllerTest {
   
    
    public static void main(String[] args)
    {
        Controller controller = new Controller();
        Integral integral = controller.solveIntegral("cos(x)");
        Derivative derivative = controller.solveDerivative("tan(x)");
        System.out.println(derivative.getOriginal());
        System.out.println(derivative.getSteps());
        System.out.println(derivative.getSoln());
        
        System.out.println(integral.getOriginal());
        System.out.println(integral.getSteps());
        System.out.println(integral.getSoln());
    }
}
