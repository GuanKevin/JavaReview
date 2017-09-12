package ProgramCreek;

import Utilities.StackNotation;

import java.util.Arrays;
import java.util.Stack;

/**
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 * Valid operators are +, -, *, /. Each operand may be an integer or another expression.
 */

public class EvaluateReversePolishNotation {
	public static void main(String[] args) {
		String[] array = StackNotation.generateNotation();

		System.out.println("Stack: " + Arrays.toString(array));

		Stack<Integer> numberStack = new Stack<>();
		Stack<Character> operatorStack = new Stack<>();

		for (int i = array.length - 1; i >= 0; i--) {
			try {
				if (!Character.isDigit(Integer.parseInt(array[i]))) {
					// System.out.println("Number: " + array[i]);
					numberStack.push(Integer.parseInt(array[i]));
				}
			} catch (NumberFormatException nfe) {
				// System.out.println("Operator: " + array[i]);
				operatorStack.push(array[i].charAt(0));
			}
		}

		System.out.println("Numbers in stack: " + numberStack.toString());
		System.out.println("Operators in stack: " + operatorStack.toString());

		int value = evaluateNotation(numberStack, operatorStack);
		System.out.println("The value is " + value);
	}

	private static int evaluateNotation(Stack<Integer> numberStack, Stack<Character> operatorStack) {
		int value = 0;

		while (!operatorStack.empty()) {
			int val1 = numberStack.pop();
			int val2 = numberStack.pop();

			switch (operatorStack.pop()) {
				case '-':
					value = (val1 - val2);
					break;
				case '+':
					value = (val1 + val2);
					break;
				case '*':
					value = (val1 * val2);
					break;
				case '/':
					if (val1 == 0 || val2 == 0)
						value = 0;
					else
						value = (val1 / val2);
					break;
				default:
					break;
			}
			numberStack.push(value);
		}

		return value;
	}
}
