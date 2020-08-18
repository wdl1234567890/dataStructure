package com.wdl.sort;

class BucketNode{
	int num;
	BucketNode node;
	BucketNode(int num){
		this.num = num;
	}
	
}
public class BaseNumberSortByLinkList {
	
	private static final int BUCKET_SIZE = 10;//桶的数量
	
	private static int[] myArr; //原始数组
	
	private static BucketNode[] bucket;//桶
	
	private BaseNumberSortByLinkList() {}
	
	public static BaseNumberSortByLinkList instance(int[] arr) {
		myArr = arr;
		initBucket();//初始化桶
		return new BaseNumberSortByLinkList();
	}

	
	private static void initBucket() {
		bucket = new BucketNode[BUCKET_SIZE];
		for(int i = 0; i < BUCKET_SIZE; i++) {
			bucket[i] = new BucketNode(-1);
		}
	}
	
	/**
	 * 
	 * @Title: getEndBucketNode
	 * @Description: 获得指定桶的最后一个元素
	 * @param: @param index 指定的桶的下标
	 * @return: BucketNode 最后一个元素
	 */
	private BucketNode getEndBucketNode(int index) {
		BucketNode bucketNode = bucket[index];
		while(bucketNode.node != null)bucketNode = bucketNode.node;
		return bucketNode;
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
				BucketNode endBucketNode = getEndBucketNode(tempNumber);
				endBucketNode.node = new BucketNode(myArr[j]);//该位数作为下标将元素存放入相应的桶中
			}
			
			//2....
			//按顺序遍历所有桶，将桶中的元素按顺序取出放回原始数组中
			BucketNode bucketNode = null;
			int k = 0;//遍历桶元素存入原始数组所使用的指向原始数组的当前下标
			//遍历每个桶
			for(int ii = 0; ii < BUCKET_SIZE; ii++) {
				//遍历每个桶中的元素
				bucketNode = bucket[ii].node;
				while(bucketNode != null) {
					myArr[k] = bucketNode.num;
					k++;
					bucketNode = bucketNode.node;
				}
				
				//3...
				//清空当前桶中的元素	
				clearBucket(ii);
				
			}
		}
		
	}
	
	/**
	 * 
	 * @Title: clearBucket
	 * @Description: 清空指定桶的所有元素
	 * @param: @param index 指定桶的下标
	 * @return: void
	 */
	private void clearBucket(int index) {
		bucket[index].node = null;
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
	
	
	

}
