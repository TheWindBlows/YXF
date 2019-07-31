package com.yxf.demo.sort;

/**
 * Description：直接插入排序 <br>
 * remark：将数组中的所有的元素依次跟前面有序表进行比较，第一次有序表只有一个元素，无序表有n-1个元素，每次从无序表中取出一个
 * 	元素插入到有序表中适当位置
 * @author 袁小飞 <br>
 * date 2019年7月25日 下午5:12:53 <br>
 */
public class SISort {
	
	public static int[] data = {2,6,1,3,9,7,0,5,8,4};
	
	public static void main(String[] args) {
		show();
		change();
		show();
	}
	
	public static void change() {
		// tmp:需要插入元素
		// i:无序表下标
		// j:插入位置
		int tmp,i,j;
		for (i = 1; i < data.length; i++) {
			j = i;
			tmp = data[j];
			// 找到元素要插入的位置
			while (j != 0 && tmp < data[j - 1]) {
				// 如果插入位置的元素比需要插入的元素大,就把插入位置的元素向后移动
				data[j] = data[--j];
			}
			data[j] = tmp;
		}
	}
	
	public static void show() {
		String str = "";
		for (int i = 0; i < data.length; i++) {
			str += String.valueOf(data[i]) + ' ';
		}
		System.out.println(str);
	}

	
	
}
