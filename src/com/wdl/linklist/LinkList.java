package com.wdl.linklist;

public class LinkList {
	
	public LinkListNode linkListNode = new LinkListNode(0,"");
	
	public void addEle(LinkListNode linkListNode) {
		LinkListNode temp = this.linkListNode;
		while(temp.nextNode != null)temp = temp.nextNode;
		temp.nextNode = linkListNode;
	}
	
	public void delEle(Integer no) {
		if(linkListNode.nextNode == null)throw new RuntimeException("链表为空！");
		LinkListNode elePreEle = getElePreEle(no);
		if(elePreEle != null) {
			elePreEle.nextNode = elePreEle.nextNode.nextNode;
		}else {
			throw new RuntimeException("找不到该节点！");
		}
	}
	
	public void upEle(LinkListNode linkListNode) {
		if(this.linkListNode.nextNode == null)throw new RuntimeException("链表为空！");
		LinkListNode elePreEle = getElePreEle(linkListNode.no);
		if(elePreEle != null) {
			linkListNode.nextNode = elePreEle.nextNode.nextNode;
			elePreEle.nextNode = linkListNode;
		}else {
			throw new RuntimeException("找不到该节点！");
		}
		
		
	}
	
	public LinkListNode getElePreEle(Integer no) {
		LinkListNode temp = this.linkListNode;
		while(temp.nextNode != null && temp.nextNode.no != no)temp = temp.nextNode;
		if(temp.nextNode != null) {
			return temp;
		}
		return null;
	}
	
	public void addEleBySort(LinkListNode linkListNode) {
		LinkListNode temp = this.linkListNode;
		while(temp != null) {
			
			if(temp.nextNode == null || temp.nextNode.no > linkListNode.no) {
				linkListNode.nextNode = temp.nextNode;
				temp.nextNode = linkListNode;
				break;
				
			}else if(temp.nextNode.no == linkListNode.no) {
				throw new RuntimeException("该节点已存在！");
			}
			
			temp = temp.nextNode;
		}
	}
	
	public void showEles() {
		
		if(this.linkListNode.nextNode == null)throw new RuntimeException("链表为空！");
		LinkListNode temp = this.linkListNode.nextNode;
		while(temp != null) {
			System.out.println(temp);
			temp = temp.nextNode;
		}
	}

}


