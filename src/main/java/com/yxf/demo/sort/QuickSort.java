package com.yxf.demo.sort;

/**
 * Description：快速排序算法 ，时间复杂度O(n^2)<br>
 * remark:拿第一个元素作为标记，定义左下标与右下标向中级移动，如果左边比标记元素大同时右边比标记元素小就进行左右元素互换，
 * 	当左右下标相撞时表示已经互换完成，标识元素与中间元素进行互换，达到左边元素比中间元素小，右边元素比中间元素大，再进行左边
 * 	排序完成后再进行右边排序。
 * @author 袁小飞 <br>
 * date 2019年7月2日 下午3:59:22 <br>
 */
public class QuickSort {
	
	public static void main(String[] args) {
		String str = "";
		QuickSort sort = new QuickSort();
		int[] elements = {5, 3, 1, 2, 7, 8, 6, 0};
		sort.partition(elements, 0, elements.length - 1);
		for (int element : elements) {
			str += element + " ";
		}
		System.out.println(str);
	}
	
	public void partition(int[] num,int l,int r) {
		int tag,tmp;
		int i = l; 
	    int j = r;
	    // 判断是否还需要左右移动
	    if (i >= j) {
	    	return;
	    }
	    // 获取比较标识数,数组第一个数
	    tag = num[l];
	    while (i != j) {
	    	// 判断是否向左移动
	    	while (num[j] > tag  && i < j) {
	        	j--;
	        }
	    	// 判断是否向右移动
	        while (num[i] <= tag  && i < j) {
	        	i++;
	        }
	        // 右边最小数与左边最大数互换
	        tmp = num[i];
	        num[i] = num[j];
	        num[j] = tmp;
       }
    	// 比较标识数与中间数互换
       tmp = num[l];
       num[l] = num[i];
       num[i] = tmp;
       // 递归左边未排序数
       partition(num,l,i - 1);
       // 递归右边未排序数
       partition(num,i + 1,r);
	}

}
