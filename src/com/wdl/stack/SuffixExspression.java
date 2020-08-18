package com.wdl.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.wdl.stack.ExspessionCal.EleType;

public class SuffixExspression {

	static final int LEVLE1 = 1;
	static final int LEVLE2 = 2;
	static final int LEVLE0 = 0;

	static String oprs = new String("+-*/()");

	public static double cal(List<String> suffixList) {
		Stack<String> stack = new Stack<>();
		double num1 = 0;
		double num2 = 0;
		for (String item : suffixList) {
			if (isDigital(item)) {
				stack.push(item);
			} else if (getEleType(item.charAt(0)) == EleType.OPERATION) {
				num1 = Double.parseDouble(stack.pop());
				num2 = Double.parseDouble(stack.pop());
				String result = cal(num1, num2, item);
				stack.push(result);
			} else {
				throw new RuntimeException("表达式有误!");
			}
		}
		if (stack.size() != 1)
			throw new RuntimeException("表达式有误!");
		return Double.parseDouble(stack.pop());
	}

	private static String cal(double num1, double num2, String item) {
		double  result = 0;
		switch (item) {
		case "+":
			result = num1 + num2;
			return String.valueOf(result);
		case "-":
			result = num2 - num1;
			return String.valueOf(result);
		case "*":
			result = num1 * num2;
			return String.valueOf(result);
		case "/":
			result = num2 / num1;
			return String.valueOf(result);
		default:
			throw new RuntimeException("表达式有误!");
		}

	}

	public static List<String> getSuffixExpression(List<String> expression) {
		List<String> expressionList = new ArrayList<>();
		Stack<String> s1 = new Stack<>();
		List<String> suffixExpression = new ArrayList<>();
		String ch = null;
		for (String item : expression) {
			if (isDigital(item)) {
				suffixExpression.add(item);
			} else if (getEleType(item.charAt(0)) == EleType.OPERATION) {
				if ("(".equals(item)) {
					s1.add(item);
				} else if (")".equals(item)) {
					while (!s1.isEmpty() && !"(".equals((ch = s1.pop()))) {
						suffixExpression.add(ch);
					}
					if(s1.isEmpty()) {
						throw new RuntimeException("表达式有误!");
					}
				} else {
					while (s1.size() > 0 && getOprProprity(s1.peek().charAt(0)) >= getOprProprity(item.charAt(0))) {
						suffixExpression.add(s1.pop());
					}
					s1.add(item);
				}
			} else {
				throw new RuntimeException("表达式有误!");
			}
		}

		while (s1.size() > 0) {
			String item = s1.pop();
			if("(".equals(item))throw new RuntimeException("表达式有误!");
			suffixExpression.add(item);
		}

		return suffixExpression;
	}

	public static List<String> getMedExpressionList(String expression) {
		int index = 0;
		StringBuffer str = new StringBuffer();
		List<String> expressionList = new ArrayList<>();
		expression = expression.replaceAll(" ", "");
		while (index < expression.length()) {
			if (getEleType(expression.charAt(index)) == EleType.OPERATION) {

				if (expressionList.isEmpty() && expression.charAt(index) != '-' && expression.charAt(index) != '+'
						|| (index + 1 == expression.length() && expression.charAt(index) != ')')
						|| (expression.charAt(index) != ')'
								&& getEleType(expression.charAt(index + 1)) == EleType.OPERATION
								&& expression.charAt(index + 1) != '(')) {

					throw new RuntimeException("表达式有误");
				}
				if (expressionList.isEmpty() && (expression.charAt(index) == '-' || expression.charAt(index) == '+'))
					expressionList.add("0");
				expressionList.add(String.valueOf(expression.charAt(index)));
				index++;
			} else if (getEleType(expression.charAt(index)) == EleType.DIGIT) {
				str.append(expression.charAt(index));
				if (index + 1 == expression.length()) {
					expressionList.add(String.valueOf(expression.charAt(index)));
				} else if (getEleType(expression.charAt(index + 1)) != EleType.DIGIT) {
					expressionList.add(str.toString());
					str.delete(0, str.length());
				}
				index++;
			}
		}

		return expressionList;

	}

	private static int getOprProprity(char ele) {
		if (getEleType(ele) != EleType.OPERATION)
			throw new RuntimeException("不是操作符不能比较优先级！");
		if (ele == '+' || ele == '-')
			return LEVLE1;
		if (ele == '*' || ele == '/')
			return LEVLE2;
		if (ele == '(')
			return LEVLE0;
		throw new RuntimeException("不是操作符不能比较优先级！");
	}

	private static boolean isDigital(String item) {
		return item.matches("^(-?\\d+)(\\.\\d+)?$");
	}

	private static EleType getEleType(char ele) {
		if (Character.isDigit(ele) || ele == '.')
			return EleType.DIGIT;
		if (oprs.contains(String.valueOf(ele)))
			return EleType.OPERATION;
		throw new RuntimeException("表达式有误！");
	}
}
