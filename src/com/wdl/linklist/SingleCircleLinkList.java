package com.wdl.linklist;

public class SingleCircleLinkList {

	private LinkListNode first;

	public void add(int count) {
		LinkListNode cur = null;
		for (int i = 0; i < count; i++) {
			if (i == 0) {
				first = new LinkListNode(i, "");
				first.nextNode = first;
				cur = first;
			} else {
				cur.nextNode = new LinkListNode(i, "");
				cur.nextNode.nextNode = first;
				cur = cur.nextNode;
			}
		}
	}
	
	public void showQuit(int startIndex, int step, int count) {
		
		if(startIndex <= 0 || step <= 0 || count <=0)throw new RuntimeException("参数错误");
		add(count);
		LinkListNode preNode = first;
		for(int i = 0; i < startIndex - 2; i++)preNode = preNode.nextNode;
		while(preNode.nextNode != preNode) {
			for(int j = 0; j < step - 1; j++)preNode = preNode.nextNode;
			System.out.println(preNode.nextNode.no);
			preNode.nextNode = preNode.nextNode.nextNode;
		}
		System.out.println(preNode.nextNode.no);
		
	}

	public void show() {
		if (first == null)
			throw new RuntimeException("链表为空");
		LinkListNode cur = first;
		while (cur.nextNode != first) {
			System.out.println(cur);
			cur = cur.nextNode;
		}
		System.out.println(cur);
	}

}
