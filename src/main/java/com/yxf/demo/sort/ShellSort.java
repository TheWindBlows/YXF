package com.yxf.demo.sort;

/**
 * Description：sell排序，时间复杂度O(n^2)<br>
 * remark:排序方式与直接插入排序一样，只是需要进行分段排
 * @author 袁小飞 <br>
 * date 2019年7月26日 下午2:49:45 <br>
 */
public class ShellSort {

public static int[] data = {2,6,1,3,9,7,0,5,8,4};
	
	public static void main(String[] args) {
		show();
		shell();
		show();
	}
	
	public static void show() {
		String str = "";
		for (int i = 0; i < data.length; i++) {
			str += String.valueOf(data[i]) + ' ';
		}
		System.out.println(str);
	}
	
	public static void shell() {
		// tmp:需要插入元素
		int tmp;
		// 跳跃间隔数量
		int grp;
		// 数组长度
		int length = data.length;
		// 计算分组次数
		for (grp = length / 2;grp > 0;grp /= 2) {
			// 本次分出来有多少组
			for (int i = 0; i < grp; i++) {
				// 直接插入排序
				for (int j = i + grp; j < length; j += grp) {
					tmp = data[j];
					// 找到元素要插入的位置
					while (j - grp >= 0 && tmp < data[j - grp]) {
						// 如果插入位置的元素比需要插入的元素大,就把插入位置的元素向后移动
						data[j] = data[j - grp];
						j -= grp;
					}
					data[j] = tmp;
				}
			}
			
		}
	}
}
