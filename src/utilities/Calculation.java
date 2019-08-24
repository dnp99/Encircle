/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import logic.CalculatorLogic;

/**
 *
 * @author Deep Patel
 */
public class Calculation {

    //Evaluate Expression
    public static int evaluateExpression(String expression) throws Exception {
        return doOperation(expression, Utility.getFirstOperand(expression), Utility.getSecondOperand(expression));
    }

    private static int doOperation(String input, int op1, int op2) throws Exception {
        if (input.substring(1, 4).equalsIgnoreCase("add")) {
            return CalculatorLogic.doAddition(op1, op2);
        } else if (input.substring(1, 9).equalsIgnoreCase("multiply")) {
            return CalculatorLogic.doMultiplication(op1, op2);
        } else {
            throw new Exception("Invalid Operation - Use add or multiply (case sensitivity is not an issue)");
        }
    }

}
