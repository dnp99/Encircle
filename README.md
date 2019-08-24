S - expression Calculator  by Deep Patel 

Developed in Java.
All the assumptions have been considered as described on github. 

Implemented following functionalities

1.For better user expierence - spaces before and after paranthesis is ignored.

2.Just one space between operands and expression name and first operand.

3.Support for add and multiply. Plus created CalculatorLogic class under Logic package to add more methods.

4.No explicit limit in logic for how deep expression can be

5.Expression names are not case sensitive. But correct spelling is required.


Sample inputs:

99

(	add 3 4	)

(multiply ( add 4 5	) 6)

(add (add 3 4) 4)

(add (multiply (add 5 4) 5 ) 7)

(add 4 (add 9 (multiply 5 9)	) )
        
	
Source Code Guide

Main class - Encircle_calculator.java

Main package - encircle_calculator

logic package:

	1. CalculatorLogic.java -contains core logic for calculator
utilities package:
	1. Calculation.java - Provides method - evaluateExpression() for doing calculation
	2. Utility.java - Provides following method
			1. getResult("expression",total operations)- Takes two arguments and returns final result of input provided by user. First is string of expression entered by user. Second is integer value total number of operations to perform. Use Utility.getTotalExpressions() for second argument.
			2. getInnerExpression()- Returns most inner expression out of expression
			3. getFirstOperand() - Returns integer value of first operand out of single string expression - Without nested expression.
			4. getSecondOperand() - Returns integer value of second operand out of single string expression - Without nested expression.
			5. isNumeric() - returns boolean value for string provided by user. checks if string contains only digits
			6. getNumberofParanthesis() - returns string of total number of open and close paranthesis delimited by single whitespace. e.g.(add 3 (add 4 4)) -> "2 2".
			7. validateExpression() - validates expression for paranthesis.
			8. getTotalExpressions() - returns number of expression that need to be performed to evaluate expression.
			9. trimSpace() - removes space before and after paranthesis.

