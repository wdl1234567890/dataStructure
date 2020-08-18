package com.wdl.linklist;

public class DoubleLinkList {
	private LinkListNode2 head = new LinkListNode2(0);
	private LinkListNode2 rear = new LinkListNode2(-1);

	public LinkListNode2 getHead() {
		return head;
	}
	
	public void add(LinkListNode2 node) {
		LinkListNode2 temp = head;
		while(temp.nextNode != null)temp = temp.nextNode;
		temp.nextNode = node;
		node.preNode = temp;
		rear.preNode = node;
	}
	
	public void del(int no) {
		if(head.nextNode == null)throw new RuntimeException("链表为空");
		LinkListNode2 temp = head.nextNode;
		while(temp != null && temp.no != no)temp = temp.nextNode;
		if(temp.no == no) {
			temp.preNode.nextNode = temp.nextNode;
			if(temp.nextNode != null) {
				temp.nextNode.preNode = temp.preNode;
			}else {
				rear.preNode = temp.preNode;
			}
			return;
		}
		throw new RuntimeException("找不到该节点");
	}
	
	public void update(LinkListNode2 node) {
		if(head.nextNode == null)throw new RuntimeException("链表为空");
		LinkListNode2 temp = head.nextNode;
		while(temp != null && temp.no != node.no)temp = temp.nextNode;
		if(temp.no == node.no) {
			temp.preNode.nextNode = node;
			node.preNode = temp.preNode;
			node.nextNode = temp.nextNode;
			if(temp.nextNode != null) {
				temp.nextNode.preNode = node;
			}else {
				rear.preNode = node;
			}
		}else {
			throw new RuntimeException("找不到该节点");
		}
		
	}
	
	public void addByOrder(LinkListNode2 node) {
		LinkListNode2 temp = head;
		while(temp != null && temp.no <= node.no)temp = temp.nextNode;
		if(temp != null) {
			temp.preNode.nextNode = node;
			node.preNode = temp.preNode;
			node.nextNode = temp;
			temp.preNode = node;
		}else {
			if(head.nextNode == null) {
				head.nextNode = node;
				node.preNode = head;
				rear.preNode = node;
			}else {
				rear.preNode.nextNode = node;
				node.preNode = rear.preNode;
				rear.preNode = node;
			}
		}
	}
	
	public void show() {
		if(head.nextNode == null)throw new RuntimeException("链表为空");
		LinkListNode2 temp = head.nextNode;
		while(temp != null) {
			System.out.println(temp);
			temp = temp.nextNode;
		}
	}
	
	public void showReverse() {
		if(rear.preNode == null)throw new RuntimeException("链表为空");
		LinkListNode2 temp = rear.preNode ;
		while(temp != null) {
			System.out.println(temp);
			temp = temp.preNode;
		}
	}
	
	
	

	
	

}
