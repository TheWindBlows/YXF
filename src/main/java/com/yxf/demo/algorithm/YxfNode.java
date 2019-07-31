package com.yxf.demo.algorithm;

/**
 * Description：链表节点类 <br>
 * @author 袁小飞 <br>
 * date 2019年7月22日 下午3:07:23 <br>
 */
public class YxfNode<E> {
	
	// 参数
	public E data;
	
	// 下一个节点
	public YxfNode<E> next;
	
	/**
	 * Description：构造函数 <br>
	 * author：袁小飞 <br>
	 * date：2019年7月22日 下午3:13:50 <br>
	 */
	public YxfNode(E data,YxfNode<E> next) {
		this.data = data;
		this.next = next;
	}
	
	public YxfNode(E data) {
		this(data, null);
	}

	public YxfNode() {
		this(null, null);
	}

}
