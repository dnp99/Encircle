package utilities;

/**
 *
 * @author Deep Patel
 */
public class Utility {

    //Retuns final result of expression for exresion entered by user
    public static int getResult(String expression, int noop) throws Exception {
        int result = 0;
        
        //for loop for nested expression
        for (int i = noop; i > 0; i--) {
            //get most inner expression
            String innerExpression = getInnerExpression(expression, noop);
            //Remove unneccasry space
            String tempInnerExpression = trimSpace(innerExpression);
            //evaluate result
            result = Calculation.evaluateExpression("(" + tempInnerExpression + ")");
            //replce result with original string
            expression = expression.replaceAll("[(]" + innerExpression + "[)]", String.valueOf(result));
            noop--;
        }

        return result;
    }

    //Returns the most inner expression
    public static String getInnerExpression(String expression, int numofOp) throws Exception {
        int count = 0, startofString = 0, endingOfString = 0;
        for (int i = 0; i < expression.length(); i++) {
            //check for open paranthesis
            if (expression.charAt(i) == '(') {
                count++;
                if (count == numofOp) {
                    startofString = i + 1;
                    for (int j = i + 1; j < expression.length(); j++) {
                        //break loop at closing paranthesis
                        if (expression.charAt(j) == ')') {
                            endingOfString = j;
                            break;
                        }
                    }
                    break;
                }
            }
        }
        if (count == 0) {
            throw new Exception("Please use Paranthesis ");
        } else {
            return expression.substring(startofString, endingOfString);
        }
    }

    //Get first operand
    public static int getFirstOperand(String expression) throws Exception {
        String op1 = "";
        //Loop through input 
        for (int i = 0; i < expression.length(); i++) {
            //Check for first space
            if (expression.charAt(i) == ' ') {
                //Loop through till space 
                for (int j = i + 1; j < expression.length(); j++) {
                    //check if next character is number or not
                    if (!Character.isDigit(expression.charAt(j))) {
                        //Stop at next space
                        if (expression.charAt(j) == ' ') {
                            //From space one to space scond => first operand
                            op1 = expression.substring(i + 1, j);
                            break;
                        } else {
                            throw new Exception("After Expression name there must be only one space followed by a digit");
                        }
                    }
                }
                break;
            }

        }
        return Integer.valueOf(op1);
    }

    //Get second operand
    public static int getSecondOperand(String expression) throws Exception {
        String op2 = "";
        //Loop through input 
        for (int i = 0; i < expression.length(); i++) {
            //Check for first space
            if (expression.charAt(i) == ' ') {
                //Loop through next space 
                for (int j = i + 1; j < expression.length(); j++) {
                    //Stop at next space
                    if (expression.charAt(j) == ' ') {
                        //From space 2 to end of string -> second operand
                        op2 = expression.substring(j + 1, expression.length() - 1).trim();//Trim spaces before paranthesis if any
                        break;
                    }
                }
                break;
            }
        }
        return Integer.valueOf(op2);
    }

    //Check if string contains only numbers
    public static boolean isNumeric(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException | NullPointerException nfe) {
            return false;
        }
        return true;
    }

    //Get  number of  open/close paranthesis
    private static String getNumberofParanthesis(String input) throws Exception {
        int openParanthesis = 0;
        int closeParanthesis = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '(') {
                openParanthesis++;
            } else if (input.charAt(i) == ')') {
                closeParanthesis++;
            }
        }
        return String.valueOf(openParanthesis + " " + closeParanthesis);
    }

    //Validates Single Expression 
    public static boolean validateExpression(String expression) throws Exception {
        int openParanthesis = 0;
        int closeParanthesis = 0;
        String paranthesis = getNumberofParanthesis(expression);
        String[] param = paranthesis.split(" ", 2);
        openParanthesis = Integer.valueOf(param[0]);
        closeParanthesis = Integer.valueOf(param[1]);
        if (openParanthesis == closeParanthesis
                && openParanthesis + closeParanthesis <= 6 && openParanthesis != 0 && closeParanthesis != 0) {
            return true;
        } else {
            if (openParanthesis > closeParanthesis) {
                throw new Exception("Error in Expresion: Parenthesis not closed");
            } else if (closeParanthesis > openParanthesis) {
                throw new Exception("Error in Expresion: closed paranthesis are more than open paranthesis ");
            } else if (openParanthesis == 0) {
                throw new Exception("Error in Expresion: No open Parenthesis");
            } else if (closeParanthesis == 0) {
                throw new Exception("Error in Expresion: No closed Parenthesis");
            } else {
                throw new Exception("Error in Expresion:  Parenthesis");
            }
        }
    }

    //returns totla number of operations to perform to calculate result
    public static int getTotalExpressions(String expression) throws Exception {
        /**
         * ** for valid Expression ***
         */
        //If expression is valid total number of open and close paranthesis will be same 
        //Total number of operations to perform = number of open or close paranthesis
        {
            int openParanthesis = 0;
            int closeParanthesis = 0;
            for (int i = 0; i < expression.length(); i++) {
                if (expression.charAt(i) == '(') {
                    openParanthesis++;
                } else if (expression.charAt(i) == ')') {
                    closeParanthesis++;
                }
            }
            return openParanthesis;
        }

    }

    //Removes spaces after opening paranthesis and before expression name of single expression without nesting
    public static String trimSpace(String expression) {
        int start = 0, end = 0;
        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) == '(') {
                for (int j = i + 1; j < expression.length(); j++) {
                    if (Character.isWhitespace(expression.charAt(j))) {
                        if (start == 0) {
                            start = j;
                        }
                    } else {
                        end = j;
                        break;
                    }

                }
            }
        }
        //System.err.println( expression.replace(expression.substring(start, end),"").trim());
        return expression.replace(expression.substring(start, end), "").trim();
    }

}
