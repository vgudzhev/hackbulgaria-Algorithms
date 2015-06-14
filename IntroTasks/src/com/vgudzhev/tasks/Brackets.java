package com.vgudzhev.tasks;

import java.util.Stack;

public class Brackets {
	public static String solve(String expression) {
		if (!checkBrackets(expression)) {
			return "NO";
		}

		int smallBracketIndex = expression.indexOf('(');
		int quadraticBracketIndex = expression.indexOf('[');
		int curlyBracketIndex = expression.indexOf('{');

		String exprToSolve = expression.substring(1, expression.length() - 1);

		if (smallBracketIndex == 0) {
			return solveSimple(exprToSolve) + "";
		} else if (quadraticBracketIndex == 0) {
			return solveQuadraticBrackets(exprToSolve) + "";
		} else if (curlyBracketIndex == 0) {
			return solveCurlyBrackets(exprToSolve) + "";
		} else {
			return "NO";
		}
	}

	private static int solveCurlyBrackets(String expression) {
		if (expression.charAt(0) == '[') {
			int beginIndex = expression.indexOf('[');
			int endIndex = expression.indexOf(']');
			String quadraticBracketExpr = expression.substring(beginIndex + 1,
					endIndex);
			return 2 * solveQuadraticBrackets(quadraticBracketExpr)
					+ solveCurlyBrackets(expression.substring(1 + endIndex));
		} else {
			if (expression.indexOf('[') != -1) {
				int endIndex = expression.indexOf('[');
				String expr = expression.substring(0, endIndex);
				return solveSimple(expr)
						+ solveCurlyBrackets(expression.substring(endIndex));
			} else {
				return solveSimple(expression);
			}
		}
	}

	private static int solveQuadraticBrackets(String expression) {
		if (expression.isEmpty() || expression == "") {
			return 0;
		}

		if (expression.charAt(0) == '(') {
			int beginIndex = expression.indexOf('(');
			int endIndex = expression.indexOf(')');
			String expr = expression.substring(beginIndex + 1, endIndex);

			return 2
					* solveSimple(expr)
					+ solveQuadraticBrackets(expression.substring(1 + endIndex));
		} else {
			if (expression.indexOf('(') != -1) {
				int endIndex = expression.indexOf('(');
				String expr = expression.substring(0, endIndex);
				return solveSimple(expr)
						+ solveQuadraticBrackets(expression.substring(endIndex));
			} else {
				return solveSimple(expression);
			}
		}
	}

	private static int solveSimple(String expression) {
		int result = 0;
		int x, y, z;
		if (expression.length() == 1) {
			x = Character.digit(expression.charAt(0), 10);
			result = x;
		} else if (expression.length() == 2) {
			x = Character.digit(expression.charAt(0), 10);
			y = Character.digit(expression.charAt(1), 10);
			result = 10 * x + y;
		} else if (expression.length() == 3) {
			x = Character.digit(expression.charAt(0), 10);
			y = Character.digit(expression.charAt(1), 10);
			z = Character.digit(expression.charAt(2), 10);
			result = 100 * x + 10 * y + z;
		}

		return result;
	}

	public static boolean checkBrackets(String expression) {
		if (expression.isEmpty() || expression == null) {
			return false;
		}

		if (!(checkForLeadingNumbers(expression) && checkForTrailingNumbers(expression))) {
			return false;
		}

		Stack<Character> brackets = new Stack<Character>();
		brackets.add(expression.charAt(0));
		boolean nestedInCurlyBrackets = false;
		boolean nestedInQuadraticBrackets = false;
		for (int i = 1; i < expression.length() - 1; i++) {
			char currentChar = expression.charAt(i);
			char lastAdded = brackets.peek();

			switch (lastAdded) {

			case '{':
				nestedInCurlyBrackets = true;
				if (currentChar == '{' || currentChar == '('
						|| currentChar == ')' || currentChar == ']') {
					return false;
				} else if (currentChar == '[') {
					brackets.push('[');
				} else if (currentChar == '}') {
					brackets.pop();
				}

				break;

			case '[':
				nestedInQuadraticBrackets = true;
				if (currentChar == '{' || currentChar == '}'
						|| currentChar == '[' || currentChar == ')') {
					return false;
				} else if (currentChar == '(') {
					brackets.push('(');
				} else if (currentChar == ']' && nestedInCurlyBrackets) {
					brackets.pop();
				}
				break;

			case '(':
				if (currentChar == '{' || currentChar == '}'
						|| currentChar == '[' || currentChar == ']'
						|| currentChar == '(') {
					return false;

				} else if (currentChar == ')' && nestedInQuadraticBrackets) {
					brackets.pop();
				}
				break;

			default:
				break;
			}
		}
		return true;
	}

	private static boolean checkForTrailingNumbers(String expression) {
		if (isDigit(expression.charAt(0))) {
			return false;
		}
		return true;
	}

	private static boolean checkForLeadingNumbers(String expression) {
		if (isDigit(expression.charAt(expression.length() - 1))) {
			return false;
		}
		return true;
	}

	private static boolean isDigit(char input) {
		String digits = "0123456789";
		for (int i = 0; i < digits.length() - 1; i++) {
			if (input == digits.charAt(i)) {
				return true;
			}
		}
		return false;
	}
}
