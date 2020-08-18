package com.wdl.queue;

public class ArrayQueue {
	
	private int[] queue;
	private int maxSize;
	private int front;
	private int rear;
	
	private void init(int maxSize) {
		this.maxSize = maxSize;
		front = rear = 0;
		queue = new int[maxSize];
	}
	
	public ArrayQueue(int maxSize) {
		init(maxSize + 1);
	}
	
	private boolean isFulled() {
		return (rear + 1) % maxSize == front;
	}
	
	private boolean isEmpty() {
		return rear == front;
	}
	
	public boolean push(int element) {
		if(isFulled())throw new RuntimeException("queue is fulled!");
		queue[rear] = element;
		rear = (rear + 1) % maxSize;
		return true;
	}
	
	public int pop() {
		if(isEmpty())throw new RuntimeException("queue is empty!");
		int temp = queue[front];
		front = (front + 1) % maxSize;
		return temp;
	}
	
	public int head() {
		if(isEmpty())throw new RuntimeException("queue is empty!");
		return queue[front];
	}
	
	public int getSize() {
		return (rear + maxSize - front) % maxSize;
	}
	
	public void show() {
		if(isEmpty())throw new RuntimeException("queue is empty!");
		int eleSizeIndex = front + getSize();
		System.out.print("[");
		for(int i = front; i < eleSizeIndex; i++) {
			int index = i % maxSize;
			System.out.print(queue[index]);
			if(i != eleSizeIndex - 1)System.out.print(",");
		}
		System.out.print("]");
		System.out.println();
	}

}
