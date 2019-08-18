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
        Scanner inp= new Scanner(System.in);
        System.out.println("Please Enter Expression: ");
        //String pattern="[(](?:add|multiply) [0-9][0-9]";
        String expression=inp.nextLine();
        //expression.replace(" ", "");
        String op1="",op2="";
        
        if(expression.charAt(1)=='a')
        {
            //Loop through input 
            for(int i=0;i<expression.length();i++)
            {
                //Check for first space
                if(expression.charAt(i)==' ')
                {
                    //Loop through mext space 
                    for(int j=i+1;j<expression.length();j++)
                    {
                        //Stop at next space
                        if(expression.charAt(j)==' ')
                        {
                            //From space one to space 2=> first operand
                            op1=expression.substring(i+1,j);
                            //From space 2 to end of string second operand
                            op2=expression.substring(j+1,expression.length()-1);
                            break;
                        }
                    }
                    break;
                }
            }
            
        }
        System.out.println(op1+" "+op2); 
        
        
    }
    public void getNumberofOperations(String input)
    {
        
    }
    
    public String getOperation(String input) throws Exception
    {
        
        if(input.substring(1,3).equals("add"))
        {
            return "add";   
        }
            
        else if(input.substring(1,9).equals("multiply"))
        {
          return "mul"; 
        }
        else
            throw new Exception("Invalid Operation - Only add and multiply is allowed");
    }
    
    public int doAddition(int op1, int op2)
    {
      return op1+op2;  
    }
    
    
    public int doMultiplication(int op1, int op2)
    {
      return op1*op2;  
    }
}
