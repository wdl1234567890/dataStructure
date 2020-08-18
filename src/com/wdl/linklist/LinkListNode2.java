package com.wdl.linklist;

public class LinkListNode2 {
	public Integer no;
	public LinkListNode2 preNode;
	public LinkListNode2 nextNode;
	
	
	public LinkListNode2(Integer no) {
		super();
		this.no = no;
	}


	@Override
	public String toString() {
		return "LinkListNode [no=" + no + "]";
	}
}
