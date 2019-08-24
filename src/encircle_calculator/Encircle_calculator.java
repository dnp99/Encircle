package encircle_calculator;

import utilities.Calculation;
import java.util.Scanner;
import utilities.Utility;
import utilities.Utility;
import static utilities.Utility.isNumeric;

/**
 *
 * @author Deep Patel
 */
//Refer Readme.md for source code explaination
public class Encircle_calculator {

    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        System.out.println("Please Enter Expression: ");
        String expression = inp.nextLine();
        try {
            //check if expression contains only digits
            if (!isNumeric(expression)) {
                //Validate Input
                if (Utility.validateExpression(expression)) {
                    //Get result
                    System.out.println(Utility.getResult(expression, Utility.getTotalExpressions(expression)));
                }
            }
            else
                System.out.println(Integer.parseInt(expression));
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }

}
