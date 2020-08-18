package com.wdl.sort;

public class MergeSort {
	
	private static int[] tempArr;//辅助排序数组
	private static int[] myArr;//原始数组
	
	private MergeSort() {}
	
	public static MergeSort instance(int[] arr) {
		myArr = arr;
		tempArr = new int[arr.length];
		return new MergeSort();
		
	}
	
	/**
	 * 
	 * @Title: merge
	 * @Description: ”治“，将两半从小到大排序（用left和right来标识在原始数组中左一半的开始下标和右一半的结束下标，这两半的中间分界下标在方法中可以通过计算得到）
	 * @param: @param left 需要排序的数组的左端下表
	 * @param: @param right 右端下标
	 * @return: void
	 */
	private static void merge(int left, int right) {

		/*
		 * 
		       算法：
		       1.用两个索引i和j分别指向左一半和右一半的当前下标
		       2.比较当前指向的两个元素哪个比较小，把该较小元素放进辅助数组
		       3.把该元素所在的那一半的当前下标加一，辅助数组下标加一
		       4.直到有任何的一半的下标走到该半的结束下标的下一个位置（左一半的结束下标为mid，右一半为right），跳出循环
		       5.把有剩余没排完的那一半全部按顺序放入辅助数组中
		       6.把辅助数组复制到原始数组(复制到原始数组的left下标到right下标)
		*/
		
		
		//1
		int mid = (left + right) / 2;//获取数组中点下标
		int i = left;//左一半开始下标
		int j = mid + 1;//右一半开始下标
		int k = 0;//辅助数组的下标
		
		//2，3，4
		while(i <= mid && j <= right) {
			if(myArr[i] <= myArr[j]) {
				tempArr[k++] = myArr[i++];
			}else {
				tempArr[k++] = myArr[j++];
			}
		}
		
		//5
		while(i <= mid) {
			tempArr[k++] = myArr[i++];
		}
		while(j <= right) {
			tempArr[k++] = myArr[j++];
		}
		
		
		//6
		for(int d = left,p = 0; d <= right; d++,p++) {
			myArr[d] = tempArr[p];
		}
	}
	
	/**
	 * 
	 * @Title: separateMerge
	 * @Description: 递归实现“分”
	 * @param: @param left 当前序列的开始下标
	 * @param: @param right 当前序列的结束下标
	 * @return: void 返回类型
	 */
	private void separate(int left, int right) {
		//如果当前开始下标小于结束下标（即“分”到这里的数组元素大于1个），那么就继续切分成左右两半
		if(left < right) {
			int mid = (left + right) / 2;//获取数组中点下标
			separate(left, mid);//左一半“分”
			separate(mid + 1, right);//右一半“分”
			merge(left, right);//对左右两半进行排序
		}
	}
	
	/**
	 * 
	 * @Title: separateMerge
	 * @Description: 归并排序的入口
	 * @return: void
	 */
	public void separateMerge() {
		separate(0, myArr.length - 1);
	}

}
