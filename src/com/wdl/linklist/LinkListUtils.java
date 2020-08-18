package com.wdl.linklist;

public class LinkListUtils {
	
	private static LinkListNode headD;
	
	public static void reserveByDiGuiD(LinkListNode head) {
		headD = head;
		LinkListNode reserveByDiGui = reserveByDiGui(head.nextNode);
		reserveByDiGui.nextNode = null;
		
	}
	
	public static LinkListNode reserveByDiGui(LinkListNode head) {
		if(head.nextNode == null) {
			headD.nextNode = head;
			return head;
		}else {
			LinkListNode reserveByDiGui = reserveByDiGui(head.nextNode);
			reserveByDiGui.nextNode = head;
			return head;
		}
	}
	
	public static void reserveByYuanDi(LinkListNode head) {
		LinkListNode front = null;
		LinkListNode temp = head.nextNode;
		LinkListNode next = null;
		
		while(temp != null) {
			next = temp.nextNode;
			temp.nextNode = front;
			front = temp;
			temp = next;
		}
		
		head.nextNode = front;
		
		
	}
	
	public static void reserveByHeadInsert(LinkListNode head) {
		
		if(head.nextNode == null)throw new RuntimeException("链表为空");
		LinkListNode temp1 = new LinkListNode(0, "");
		LinkListNode temp2 = head.nextNode;
		LinkListNode temp3;
		while(temp2 != null) {
			temp3 = temp2.nextNode;
			temp2.nextNode = temp1.nextNode;
			temp1.nextNode = temp2;
			temp2 = temp3;
		}
		head.nextNode = temp1.nextNode;
		
		
	}
	
	public static LinkListNode findLastEle(LinkListNode head, Integer index) {
		LinkListNode fast = head;
		LinkListNode slow = head;
		if(index <= 0)throw new RuntimeException("index参数错误！");
		int i;
		for(i = 0; i < index; i++) {
			fast = fast.nextNode;
			if(fast == null)break;
		}
		if(i != index)throw new RuntimeException("index参数错误！");
		while(fast != null) {
			fast = fast.nextNode;
			slow = slow.nextNode;
		}
		return slow;
		
	}
	
	public static LinkListNode getMediumEle(LinkListNode linkListNode) {
		LinkListNode fast = linkListNode;
		LinkListNode slow = linkListNode;
		
		while(fast != null && fast.nextNode != null) {
			fast = fast.nextNode.nextNode;
			slow = slow.nextNode;
		}
		
		return slow;
	}
	
	public static void show(LinkListNode linkListNode) {
		if(linkListNode.nextNode == null)throw new RuntimeException("链表为空！");
		LinkListNode temp = linkListNode.nextNode;
		while(temp != null) {
			System.out.println(temp);
			temp = temp.nextNode;
		}
	}
	
	public static LinkListNode merger(LinkListNode linkListNode1, LinkListNode linkListNode2) {
		if(linkListNode1.nextNode == null && linkListNode2.nextNode != null)return linkListNode2;
		if(linkListNode1.nextNode != null && linkListNode2.nextNode == null)return linkListNode1;
		if(linkListNode1.nextNode == null && linkListNode2.nextNode == null)throw new RuntimeException("链表为空！");
		
		LinkListNode head = new LinkListNode(0, "");
		head.nextNode = linkListNode1.nextNode.no <= linkListNode2.nextNode.no ? linkListNode1.nextNode : linkListNode2.nextNode;
		LinkListNode front = head.nextNode;
		LinkListNode cur1 = front.nextNode;
		LinkListNode cur2 = linkListNode1.nextNode.no <= linkListNode2.nextNode.no ? linkListNode2.nextNode : linkListNode1.nextNode;
		LinkListNode temp = null;
		while(cur1 != null && cur2 != null) {
			if(cur1.no <= cur2.no) {
				front = cur1;
				cur1 = cur1.nextNode;
			}else if(cur1.no > cur2.no) {
				temp = cur2.nextNode;
				cur2.nextNode = cur1;
				front.nextNode = cur2;
				cur2 = temp;
			}
		}
		
		if(cur2 != null) {
			front.nextNode = cur2;
		}
		
		return head;
	}
	
	public static LinkListNode merge2(LinkListNode linkListNode1, LinkListNode linkListNode2) {
		if(linkListNode1.nextNode == null && linkListNode2.nextNode != null)return linkListNode2;
		if(linkListNode1.nextNode != null && linkListNode2.nextNode == null)return linkListNode1;
		if(linkListNode1.nextNode == null && linkListNode2.nextNode == null)throw new RuntimeException("链表为空！");
		
		LinkListNode head = new LinkListNode(0, "");
		LinkListNode headtemp = head;
		LinkListNode cur1 = linkListNode1.nextNode;
		LinkListNode cur2 = linkListNode2.nextNode;
		LinkListNode min = null;
		LinkListNode ll = null;
		while(cur1 != null && cur2 != null) {
			min = cur1.no <= cur2.no ? cur1 : cur2;
			ll = new LinkListNode(min.no, min.userName);
			headtemp.nextNode = ll;
			headtemp = ll;
			if(cur1.no <= cur2.no)cur1 = cur1.nextNode;
			else cur2 = cur2.nextNode;
		}
		
		if(cur1 != null) {
			headtemp.nextNode = cur1;
		}else if(cur2 != null) {
			headtemp.nextNode = cur2;
		}
		
		return head;
		
		
	}

}
