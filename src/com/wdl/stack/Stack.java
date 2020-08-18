package com.wdl.stack;

public class Stack {
	
	private String[] stack;
	private int maxSize;
	private int top;
	
	public Stack(int maxSize) {
		if(maxSize <= 0)throw new RuntimeException("maxSize不合法");
		this.maxSize = maxSize;
		top = -1;
		stack = new String[maxSize];
	}
	
	
	public boolean isFulled() {
		return top == maxSize -1;
	}
	
	public boolean isEmpty() {
		return top == -1;
	}
	
	public void push(String Ele) {
		if(isFulled())throw new RuntimeException("堆栈已满");
		stack[++top] = Ele;
	}
	
	public String pop() {
		if(isEmpty())throw new RuntimeException("堆栈为空");
		return stack[top--];
	}
	
	public String peek() {
		if(isEmpty())throw new RuntimeException("堆栈为空");
		return stack[top];
	}
	
	public void show() {
		if(isEmpty())throw new RuntimeException("堆栈为空");
		for(int i = top; i >= 0; i--) {
			System.out.println(stack[i]);
		}
	}
	

}
