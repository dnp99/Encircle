/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

/**
 *
 * @author Vedang
 */
public class Utility {
     //get inner expression out of two expressions
    public static String getInnerExpressionOutOfThree(String expression)
    {
        int startofString=0,endingOfString=0;
        int cnt=0;
        //start from one to excluse first parantheis
        for (int i = 1; i < expression.length(); i++) {
                    //Check for second appreance open pranthesis
                    if (expression.charAt(i) == '(') {
                        cnt++;
                        if(cnt==2)
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
    
    
    //get inner expression out of two expressions
    public static String getInnerExpressionOutOfTwo(String expression)
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


}
