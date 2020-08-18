package com.wdl.stack;

public class ExspessionCal {

	enum EleType {
		DIGIT, OPERATION
	}

	static final int LEVLE1 = 1;
	static final int LEVLE2 = 2;

	static String oprs = new String("+-*/");

	public static double cal(String exspression) {
		Stack numberStack = new Stack(5);
		Stack oprStack = new Stack(5);
		int index = 0;
		int expreesionLength = exspression.length();
		String nums = "";
		String num1;
		String num2;
		char opr;
		char curChar;
		while (index < expreesionLength) {
			curChar = exspression.charAt(index);
			if (getEleType(curChar) == EleType.OPERATION) {
				if(index == expreesionLength - 1 || getEleType(exspression.charAt(index + 1)) == EleType.OPERATION)throw new RuntimeException("表达式有误！");
				if(oprStack.isEmpty()) {
					oprStack.push(String.valueOf(curChar));
					index++;
				}else if (getOprProprity(curChar) <= getOprProprity(oprStack.peek().charAt(0))) {
					opr = oprStack.pop().charAt(0);
					num1 = numberStack.pop();
					if(!numberStack.isEmpty())num2 = numberStack.pop();
					else num2 = null;
					double result = cal(num1, num2, opr);
					numberStack.push(String.valueOf(result));
				} else {
					oprStack.push(String.valueOf(curChar));
					index++;
				}
			} else if (getEleType(curChar) == EleType.DIGIT) {
				nums += curChar;
				if(index + 1 == expreesionLength) {
					numberStack.push(nums);
				}else if(getEleType(exspression.charAt(index + 1)) == EleType.OPERATION) {
					numberStack.push(nums);
					nums = "";
				}
				index++;
			}
		}
		
		while(!oprStack.isEmpty()) {
			opr = oprStack.pop().charAt(0);
			num1 = numberStack.pop();
			if(!numberStack.isEmpty())num2 = numberStack.pop();
			else num2 = null;
			double result = cal(num1, num2, opr);
			numberStack.push(String.valueOf(result));
		}
		
		return Double.valueOf(numberStack.pop());
	}

	private static double cal(String numa, String numb, char opr) {
		double num1 = 0;
		double num2 = 0;
		try {
			num1 = Double.valueOf(numa);
			if(numb != null)num2 = Double.valueOf(numb);
		} catch (Exception e) {
			throw new RuntimeException("表达式不合法");
		}
		
		double result;
		switch (opr) {
		case '+':
			result = num1 + num2;
			break;
		case '-':
			result = num2 - num1;
			break;
		case '*':
			result = num2 * num1;
			break;
		case '/':
			result = num2 / num1;
			break;
		default:
			throw new RuntimeException("表达式不合法！");
		}
		return result;
	}

	private static int getOprProprity(char ele) {
		if (getEleType(ele) != EleType.OPERATION)
			throw new RuntimeException("不是操作符不能比较优先级！");
		if (ele == '+' || ele == '-')
			return LEVLE1;
		if (ele == '*' || ele == '/')
			return LEVLE2;
		throw new RuntimeException("不是操作符不能比较优先级！");
	}

	private static EleType getEleType(char ele) {
		if (Character.isDigit(ele) || ele == '.')
			return EleType.DIGIT;
		if (oprs.contains(String.valueOf(ele)))
			return EleType.OPERATION;
		throw new RuntimeException("表达式有误！");
	}
}
