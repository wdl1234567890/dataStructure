package com.wdl.stack;

import com.wdl.linklist.LinkListNode;

public class LinkListStack {
	
	private LinkListNode linkListNode = new LinkListNode(0, "");
	
	public boolean isEmpty() {
		return linkListNode.nextNode == null;
	}
	
	public void push(String ele) {
		LinkListNode node = new LinkListNode(0, ele);
		node.nextNode = linkListNode.nextNode;
		linkListNode.nextNode = node;
	}
	
	public String pop() {
		if(isEmpty())throw new RuntimeException("堆栈为空！");
		LinkListNode node = linkListNode.nextNode;
		linkListNode.nextNode = linkListNode.nextNode.nextNode;
		return node.userName;
	}
	
	public String peek() {
		if(isEmpty())throw new RuntimeException("堆栈为空！");
		return linkListNode.nextNode.userName;
	}
	
	public void show() {
		if(isEmpty())throw new RuntimeException("堆栈为空！");
		LinkListNode temp = linkListNode.nextNode;
		while(temp != null) {
			System.out.println(temp.userName);
			temp = temp.nextNode;
		}
	}

}
