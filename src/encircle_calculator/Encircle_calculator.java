/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package encircle_calculator;

import java.util.Scanner;
import java.lang.Exception;
/**
 *
 * @author Deep Patel
 */
public class Encircle_calculator {

    public static void main(String[] args) {
        
        Scanner inp = new Scanner(System.in);
        System.out.println("Please Enter Expression: ");
        String expression = inp.nextLine();
        try
        {
            int totalExpression=getNumberofOperations(expression);
            //check if expression contains only numeric data
            if(isNumeric(expression))
            {
                   System.out.println("Result: "+expression);   
            }
            
            //For only one operation
            if(totalExpression==1)
            {      
                System.out.println(evaluateExpression(expression));
            }
            //For two operations
            else if(totalExpression==2){
                //evaluate  inner expressin
                String innerExpression=getInnerExpression(expression);
                System.out.println(innerExpression);
                int innerResult=evaluateExpression(innerExpression);
                String newExpression=expression.replaceAll('('+innerExpression+')', String.valueOf(innerResult));
                System.out.println(newExpression);
                
            }
            //For three operations
            else{
                
            }
            //For more than three opertions getNumberofOperations() will throw exception
        }
        catch(Exception e)
        {
            System.err.println(e.getMessage());
        }

    }

    //Evaluate Expression
    public static int evaluateExpression(String expression) throws Exception
    {
        return doOperation(expression,getFirstOperand(expression),getSecondOperand(expression));
        //System.out.println("Result: "+result);   
        
    }
    
    
    //get inner expression
    public static String getInnerExpression(String expression)
    {
        int startofString=0,endingOfString=0;
        //start from one to excluse first parantheis
        for (int i = 1; i < expression.length(); i++) {
                    //Check for first appreance open pranthesis
                    if (expression.charAt(i) == '(') {
                        startofString=i;
                    }
                    //Check for first appreance closed pranthesis
                    if (expression.charAt(i) == ')') {
                        endingOfString=i+1;
                        break;
                    }
        }       
        return expression.substring(startofString,endingOfString);
    }
    
    //get first operand
    public static int getFirstOperand(String expression)
    {
         String op1 = "";
        //Loop through input 
                for (int i = 0; i < expression.length(); i++) {
                    //Check for first space
                    if (expression.charAt(i) == ' ') {
                        //Loop through mext space 
                        for (int j = i + 1; j < expression.length(); j++) {
                            //Stop at next space
                            if (expression.charAt(j) == ' ') {
                                //From space one to space scond => first operand
                                op1 = expression.substring(i + 1, j);
                                break;
                            }
                        }
                        break;
                    }

                }
            return Integer.valueOf(op1);
    }
   
    //get second operand
    public static int getSecondOperand(String expression)
    {
         String op2 = "";
        //Loop through input 
                for (int i = 0; i < expression.length(); i++) {
                    //Check for first space
                    if (expression.charAt(i) == ' ') {
                        //Loop through mext space 
                        for (int j = i + 1; j < expression.length(); j++) {
                            //Stop at next space
                            if (expression.charAt(j) == ' ') {
                                //From space 2 to end of string second operand
                                op2 = expression.substring(j + 1, expression.length() - 1);
                                break;
                            }
                        }
                        break;
                    }

                }
            return Integer.valueOf(op2);
    }
                                
    //check if string contains only numbers
    public static boolean isNumeric(String input) {
        try {
             Integer.parseInt(input);
        } catch (NumberFormatException | NullPointerException nfe) {
        return false;
        }
        return true;
    }
    
    //Get total number of expression
    public static int getNumberofOperations(String input) throws Exception {
        int openParanthesis=0;
        int closeParanthesis=0;
        for(int i=0;i<input.length();i++)
        {
            if(input.charAt(i)=='(' )
            {
                openParanthesis++;
            }
            else if(input.charAt(i)==')')
            {
                closeParanthesis++;
            }
        }
        //System.out.println(openParanthesis);
        //System.out.println(closeParanthesis);
        //if it is integer and <=3 input is correct
        if(openParanthesis==closeParanthesis && openParanthesis+closeParanthesis<=6 )
        {
            //return  open paranthesis or close paranthesis which is equal to toal number of expressions
             return openParanthesis;
        }
        else{
            if(openParanthesis>closeParanthesis)
            throw new Exception("Error in Expresion: Parenthesis not closed");
            else if(closeParanthesis>openParanthesis)
            throw new Exception("Error in Expresion: closed paranthesis are more than open paranthesis ");
            else
            throw new Exception("Error in Expresion: Parenthesis");    
        }
       
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
