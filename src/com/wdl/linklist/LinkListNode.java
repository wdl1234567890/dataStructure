package com.wdl.linklist;

public class LinkListNode{
	public Integer no;
	public String userName;
	public LinkListNode nextNode;
	
	public LinkListNode(Integer no, String userName) {
		super();
		this.no = no;
		this.userName = userName;
	}

	@Override
	public String toString() {
		return "LinkListNode [no=" + no + ", userName=" + userName + "]";
	}
	
	
}
