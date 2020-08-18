package com.wdl.test;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import com.wdl.digui.MiGong;
import com.wdl.digui.Queen8;
import com.wdl.linklist.DoubleLinkList;
import com.wdl.linklist.LinkList;
import com.wdl.linklist.LinkListNode;
import com.wdl.linklist.LinkListNode2;
import com.wdl.linklist.LinkListUtils;
import com.wdl.linklist.SingleCircleLinkList;
import com.wdl.queue.ArrayQueue;
import com.wdl.sort.MergeSort;
import com.wdl.sparsearray.SparseArray;
import com.wdl.stack.ExspessionCal;
import com.wdl.stack.LinkListStack;
import com.wdl.stack.Stack;
import com.wdl.stack.SuffixExspression;

public class MainTest {

	public static void main(String[] args) {
		mergeSortTest();
	}
	
	public static void mergeSortTest() {
		int[] arr = new int[]{8,4,5,7,1,3,6,2};
		System.out.println("排序前的数组：" + Arrays.toString(arr));
		MergeSort instance = MergeSort.instance(arr);
		instance.separateMerge();
		System.out.println("排序后的数组：" + Arrays.toString(arr));
	}
	
	public static void queen8Test() {
		Queen8 queen8 = new Queen8();
		queen8.install(0);
		System.out.println("总共有" + queen8.getAmount() + "种方法");
	}
	
	public static void miGongTest() {
		new MiGong(8, 7).go(1, 1);
	}
	
	private static void suffixExspressionTest() {
		String expression = "6-((1+2)*3)+5";
		List<String> medExpressionList = SuffixExspression.getMedExpressionList(expression);
		List<String> suffixExpression = SuffixExspression.getSuffixExpression(medExpressionList);
		double result = SuffixExspression.cal(suffixExpression);
		System.out.println(expression + "=" + result);
	}


	public static void ExspressionTest() {
		String exspression = "1+5.1+2";
		double result = ExspessionCal.cal(exspression);
		System.out.println(exspression + "=" + result);
	}
	
	public static void StackTest() {
		LinkListStack linkListStack = new LinkListStack();
		linkListStack.push("wdl");
		linkListStack.push("wmh");
		linkListStack.push("wlp");
		linkListStack.pop();
		linkListStack.show();
	}
	
	public static void LinkListTest() {
		SingleCircleLinkList singleCircleLinkList = new SingleCircleLinkList();
		singleCircleLinkList.showQuit(2,3,6);
//		singleCircleLinkList.show();
//		DoubleLinkList linkList = new DoubleLinkList();
//		
//		linkList.addByOrder(new LinkListNode2(1));
//		linkList.addByOrder(new LinkListNode2(9));
//		linkList.addByOrder(new LinkListNode2(4));
//		linkList.addByOrder(new LinkListNode2(2));
//		linkList.addByOrder(new LinkListNode2(10));
//		System.out.println("正序");
//		linkList.show();
//		System.out.println("更新10");
//		linkList.update(new LinkListNode2(10));
//		linkList.show();
//		System.out.println("倒序");
//		linkList.showReverse();
//		LinkList linkList1 = new LinkList();
//		
//		linkList1.addEleBySort(new LinkListNode(3, "白龙马"));
//		linkList1.addEleBySort(new LinkListNode(8, "牛魔王"));
//		
//		System.out.println("第二个链表");
//		linkList1.showEles();
//		
//		
//		LinkListNode merger = LinkListUtils.merge2(linkList.linkListNode, linkList1.linkListNode);
//		System.out.println("合并");
//		
//		LinkListUtils.show(merger);
//		LinkListNode findLastEle = LinkListUtils.findLastEle(linkList.linkListNode, 1);
//		System.out.println("倒数第4个元素为：" + findLastEle);
//		LinkListNode mediumEle = LinkListUtils.getMediumEle(linkList.linkListNode);
//		System.out.println("中点为：" + mediumEle);
		//		System.out.println("倒序之后");
//		
//		LinkListUtils.reserveByDiGuiD(linkList.linkListNode);
//		
//		linkList.showEles();
//		System.out.println("第一个链表");
//		linkList.showEles();
		
	}

	public static void ArrayQueueTest() {
		char choose = ' ';
		Scanner scaner = new Scanner(System.in);
		ArrayQueue arrayQueue = new ArrayQueue(3);
		boolean isYes = true;
		while (isYes) {
			try {
				System.out.println("a:push元素");
				System.out.println("g:pop元素");
				System.out.println("h:head元素");
				System.out.println("s:show元素");
				System.out.println("e:退出");
				System.out.println("请选择：");
				choose = scaner.next().charAt(0);
				switch (choose) {
				case 'a':
					System.out.println("请输入添加的元素：");
					int ele = scaner.nextInt();
					arrayQueue.push(ele);
					System.out.println("add success!");
					break;
				case 'g':
					int pop = arrayQueue.pop();
					System.out.println("元素为" + pop);
					break;
				case 'h':
					int pop1 = arrayQueue.head();
					System.out.println("头元素为" + pop1);
					break;
				case 's':
					arrayQueue.show();
					break;
				case 'e':
					isYes = false;
					break;
				default:

					break;
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

		}
		System.out.println("退出成功！");
	}

	public static void sparseTest() {
		// int[][] originArray = new int[5][5];
		// originArray[2][1] = 2;
		// originArray[1][3] = 1;
		// boolean writeToDisk = new
		// SparseArray().toSparseArray(originArray).writeToDisk();
		// System.out.println(writeToDisk);

		int[][] originArray = new SparseArray().readFromDisk().toOriginArray();
		for (int[] row : originArray) {
			for (int item : row) {
				System.out.print(item + " ");
			}
			System.out.println();
		}
	}

}
