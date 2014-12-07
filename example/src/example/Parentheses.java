package example;

import java.util.Stack;

public class Parentheses {
	private static final char L_PAREN = '(';
	private static final char R_PAREN = ')';
	private static final char L_BRACE = '{';
	private static final char R_BRACE = '}';
	private static final char L_BRACKET = '[';
	private static final char R_BRACKET = ']';

	public static boolean isBalanced(String s) {
		Stack<Character> stack = new Stack<Character>();

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == L_PAREN)
				stack.push(L_PAREN);
			else if (s.charAt(i) == L_BRACE)
				stack.push(L_BRACE);
			else if (s.charAt(i) == L_BRACKET)
				stack.push(L_BRACKET);

			else if (s.charAt(i) == R_PAREN) {
				if (stack.isEmpty())
					return false;
				if (stack.pop() != L_PAREN)
					return false;
			} else if (s.charAt(i) == R_BRACE) {
				if (stack.isEmpty())
					return false;
				if (stack.pop() != L_BRACE)
					return false;
			} else if (s.charAt(i) == R_BRACKET) {
				if (stack.isEmpty())
					return false;
				if (stack.pop() != L_BRACKET)
					return false;
			}
		}
		return stack.isEmpty();
	}

	public static boolean recIsBalanced(String str) {

		return balanced(str, 0, 0, 0);
	}

	private static boolean balanced(String str, int paren, int brace,
			int bracket) {
		if (str.isEmpty()) {
			return paren == 0 && brace == 0 && bracket == 0;
		} else if (str.charAt(0) == L_PAREN) {
			return balanced(str.substring(1, str.length()), paren - 1, brace,
					bracket);
		} else if (str.charAt(0) == R_PAREN) {
			return balanced(str.substring(1, str.length()), paren + 1, brace,
					bracket);
		} else if (str.charAt(0) == L_BRACE) {
			return balanced(str.substring(1, str.length()), paren, brace - 1,
					bracket);
		} else if (str.charAt(0) == R_BRACE) {
			return balanced(str.substring(1, str.length()), paren, brace + 1,
					bracket);
		} else if (str.charAt(0) == L_BRACKET) {
			return balanced(str.substring(1, str.length()), paren, brace,
					bracket - 1);
		} else if (str.charAt(0) == R_BRACKET) {
			return balanced(str.substring(1, str.length()), paren, brace,
					bracket + 1);
		} else {
			return balanced(str.substring(1, str.length()), paren, brace,
					bracket);
		}
	}
}
