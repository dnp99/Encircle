/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package encircle_calculator;

import java.util.Scanner;

/**
 *
 * @author Deep Patel
 */
public class Encircle_calculator {

    ^\s*\((?:add|multiply)(\d+)(?:\s*([-+*\/])\s*((?:\s[-+])?\d+)\s*)+$
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner inp= new Scanner(System.in);
        System.out.println("Please Enter Expression: ");
        String pattern= "\(\s(?:add|multiply)";
        String expression=inp.next();
        expression.replace(" ", "");
        
        
        
    }
    
}
