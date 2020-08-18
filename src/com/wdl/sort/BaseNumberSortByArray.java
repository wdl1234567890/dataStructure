package com.wdl.sort;

public class BaseNumberSortByArray {
	
	private static final int BUCKET_SIZE = 10;//桶的数量
	
	private static int[] myArr; //原始数组
	private static int[][] bucket;//桶
	private static int[] elementCount;//每个桶真实所存放的元素数量
	
	
	private BaseNumberSortByArray() {}
	
	public static BaseNumberSortByArray instance(int[] arr) {
		myArr = arr;
		initBucket(arr.length);
		return new BaseNumberSortByArray();
	}
	
	/**
	 * 
	 * @Title: initBucket
	 * @Description: 初始化桶和每个桶目前所存放的元素数量为0
	 * @param: @param length 每个桶的容量
	 * @return: void
	 */
	private static void initBucket(int length) {
		bucket = new int[BUCKET_SIZE][length];
		elementCount = new int[BUCKET_SIZE];
	}
	
	
	/**
	 * 
	 * @Title: getMaxLength
	 * @Description: 获取所有元素中位数的最大值
	 * @return: int 位数的最大值
	 */
	private int getMaxLength() {
		int length = myArr.length;
		int max = myArr[0];
		for(int i = 1; i < length; i++) {
			if(max < myArr[i])max = myArr[i];
		}
		return (max + "").length();
	}
	
	/**
	 * 
	 * @Title: baseNumberSort
	 * @Description: 基数排序入口
	 * @return: void
	 */
	public void baseNumberSort() {
		/**
		 * 算法：
		 * 1.循环获取各个元素的个位数，该个位数作为下标将元素存放入相应的桶中（如元素为32，个位数为2，那么就将32存放入下标为2的桶中）
		 * 2.按顺序遍历所有桶，将桶中的元素按顺序取出放回原始数组中
		 * 3.清空桶中的元素计数
		 * 4.循环获取各个元素的百位数，该百位数作为下标将元素存放入相应的桶中
		 * 5. ....依次循环，直到取到最长位数
		 */
		int maxLength = getMaxLength();
		int myArrSize = myArr.length;
		int tempNumber = -1;//取出的当前位数值
		
		//1，4...
		for(int i = 0; i < maxLength; i++) {
			for(int j = 0; j < myArrSize; j++) {
				tempNumber = (myArr[j] / (int)Math.pow(10, i)) % 10;//取出当前位数
				bucket[tempNumber][elementCount[tempNumber]] = myArr[j];//该位数作为下标将元素存放入相应的桶中
				elementCount[tempNumber]++;//桶中元素计数加一
			}
			
			//2....
			//按顺序遍历所有桶，将桶中的元素按顺序取出放回原始数组中
			
			int k = 0;//遍历桶元素存入原始数组所使用的指向原始数组的当前下标
			//遍历每个桶
			for(int ii = 0; ii < BUCKET_SIZE; ii++) {
				//遍历每个桶中的元素
				for(int jj = 0; jj < elementCount[ii]; jj++) {
					myArr[k] = bucket[ii][jj];
					k++;
				}
				
				//3...
				//当前桶中元素的计数置为0
				elementCount[ii] = 0;	
				
			}
		}
		
	}

}
