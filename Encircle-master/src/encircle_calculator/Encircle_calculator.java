/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package encircle_calculator;

import java.util.Scanner;
import java.lang.Exception;
import logic.CalculatorLogic;
import utilities.Utility;
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
            int totalExpression=Utility.getNumberofOperations(expression);
            //check if expression contains only numeric data
            if(Utility.isNumeric(expression))
            {
                System.out.println("Result: "+expression);  
                  
            }
            
            //For only one operation
            else if(totalExpression==1)
            {      
                System.out.println(evaluateOneExpression(expression));
            }
            //For two operations
            else if(totalExpression==2){
                
                System.out.println(evaluateTwoExpression(expression));
            }
            //For three operations
            else{
               
                System.out.println(evaluateThreeExpression(expression));
            }
            
            //For more than three opertions getNumberofOperations() will throw exception
        }
        catch(Exception e)
        {
            System.err.println(e.getMessage());
        }

    }

    //Evaluate Expression
    public static int evaluateOneExpression(String expression) throws Exception
    {
        return doOperation(expression,Utility.getFirstOperand(expression),Utility.getSecondOperand(expression));
        //System.out.println("Result: "+result);   
        
    }
     public static int evaluateTwoExpression(String expression) throws Exception
    {
        //get  inner expressin
                String innerExpression=Utility.getInnerExpressionOutOfTwo(expression);
                //System.out.println(innerExpression);
                
                //evaluate inner expression
                int innerResult=evaluateOneExpression(innerExpression);
                String innerString=innerExpression.substring(1, innerExpression.length()-1);
                //System.out.println(innerString);
                
                //evaluate outer expression
                String newExpression=expression.replaceAll("[(]"+innerString+"[)]", String.valueOf(innerResult));
                //System.out.println(newExpression);
                return evaluateOneExpression(newExpression);
        
    }
    
     public static int evaluateThreeExpression(String expression) throws Exception
    {
         //get third inner expression
                String innerExpression1=Utility.getInnerExpressionOutOfThree(expression);
                int innerResult1=evaluateOneExpression(innerExpression1);
                innerExpression1=innerExpression1.substring(1, innerExpression1.length()-1);
                //replace result to make it two expressions
                expression=expression.replaceAll("[(]"+innerExpression1+"[)]", String.valueOf(innerResult1));
                //System.out.println(expression);
                return evaluateTwoExpression(expression);
                //get second inner expressin
//                String innerExpression=getInnerExpressionOutOfTwo(expression);
                //System.out.println(innerExpression);
                
                //evaluate second inner expression
//                int innerResult=evaluateExpression(innerExpression);
//                String innerString=innerExpression.substring(1, innerExpression.length()-1);
//                //System.out.println(innerString);
//                
//                //evaluate outer expression
//                String newExpression=expression.replaceAll("[(]"+innerString+"[)]", String.valueOf(innerResult));
//                //System.out.println(newExpression);
//                int outerResult=evaluateExpression(newExpression);
//                System.out.println(outerResult);
    }
    
    
       public static int doOperation(String input,int op1, int op2) throws Exception {

        if(input.substring(1, 4).equals("add")) {
            return CalculatorLogic.doAddition(op1,op2);
        } else if (input.substring(1, 9).equals("multiply")) {
            return CalculatorLogic.doMultiplication(op1,op2);
        } else {
            throw new Exception("Invalid Operation - Only add and multiply is allowed");
        }
    }

}
