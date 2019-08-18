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

    // ^\s*\((?:add|multiply)(\d+)(?:\s*([-+*\/])\s*((?:\s[-+])?\d+)\s*)+$
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner inp = new Scanner(System.in);
        System.out.println("Please Enter Expression: ");
        //String pattern="[(](?:add|multiply) [0-9][0-9]";
        String expression = inp.nextLine();
        //expression.replace(" ", "");
        String op1 = "", op2 = "";
        try
        {
           
            //Loop through input 
            for (int i = 0; i < expression.length(); i++) {
                //Check for first space
                if (expression.charAt(i) == ' ') {
                    //Loop through mext space 
                    for (int j = i + 1; j < expression.length(); j++) {
                        //Stop at next space
                        if (expression.charAt(j) == ' ') {
                            //From space one to space 2=> first operand
                            op1 = expression.substring(i + 1, j);
                            //From space 2 to end of string second operand
                            op2 = expression.substring(j + 1, expression.length() - 1);
                            break;
                        }
                    }
                    break;
                }

            }
            //System.out.println(operation+" "+op1 + " " + op2);
            if(!isNumeric(expression))
            {
                int result=doOperation(expression,Integer.parseInt(op1), Integer.parseInt(op2));
                System.out.println("Result: "+result);
            }
            else
            {
                System.out.println("Result: "+expression);
            }
        }
        catch(Exception e)
        {
            System.err.println(e.getMessage());
        }

    }

    public static boolean isNumeric(String input) {
        try {
             Integer.parseInt(input);
        } catch (NumberFormatException | NullPointerException nfe) {
        return false;
        }
        return true;
    }
    public static void getNumberofOperations(String input) {

    }

    public static int doOperation(String input,int op1, int op2) throws Exception {

        if(input.substring(1, 4).equals("add")) {
            return doAddition(op1,op2);
        } else if (input.substring(1, 9).equals("multiply")) {
            return doMultiplication(op1,op2);
        } else {
            throw new Exception("Invalid Operation - Only add and multiply is allowed");
        }
    }

    public static int doAddition(int op1, int op2) {
        return op1 + op2;
    }

    public static int doMultiplication(int op1, int op2) {
        return op1 * op2;
    }
}
