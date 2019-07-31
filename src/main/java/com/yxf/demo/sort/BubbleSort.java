package com.yxf.demo.sort;

/**
 * Description：冒泡排序，时间复杂度O(n^2)<br>
 * remark:每次左右元素进行比较，保证右边元素比左边大，第一次循环后最后边是最大的元素，以此类推。
 * @author 袁小飞 <br>
 * date 2019年7月25日 下午4:34:22 <br>
 */
public class BubbleSort {
	
	public static int[] data = {2,6,1,3,9,7,0,5,8,4};
	
	public static void main(String[] args) {
		show();
		change();
		show();
	}
	
	public static void show() {
		String str = "";
		for (int i = 0; i < data.length; i++) {
			str += String.valueOf(data[i]) + ' ';
		}
		System.out.println(str);
	}
	
	public static void change() {
		// 用于前后交换
		int tmp;
		// 循环次数
		for (int i = 0; i <= data.length - 1; i++) {
			// 大数向后移
			for (int j = 1; j < data.length - i; j++) {
				if (data[j - 1] > data[j]) {
					tmp = data[j - 1];
					data[j - 1] = data[j];
					data[j] = tmp;
				}
			}
		}
	}

}
