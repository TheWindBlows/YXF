package com.yxf.demo.algorithm;

/**
 * Description：链式栈<br>
 * @author 袁小飞 <br>
 * date 2019年7月24日 下午2:26:26 <br>
 */
public class YxfLinkedStack<E> implements YxfStack<E> {
	
	// 栈顶节点
	private YxfNode<E> top;

	/**
	 * Description：判断栈是否为空<br>
	 * author：袁小飞 <br>
	 * date：2019年7月24日 上午9:35:31 <br>
	 */
	@Override
	public boolean isEmpty() {
		return null == top;
	}

	/**
     * Description：入栈 <br>
     * author：袁小飞 <br>
     * date：2019年7月24日 上午9:35:59 <br>
     */
	@Override
	public boolean push(E element) {
		if (null == element) {
			return false;
		}
		// 将新节点作为栈顶,next指向上一个节点
		this.top = new YxfNode<>(element,this.top);
		return true;
	}

	/**
     * Description：出栈 <br>
     * author：袁小飞 <br>
     * date：2019年7月24日 上午9:36:29 <br>
     */
	@Override
	public E pop() {
		if (null == this.top) {
			return null;
		}
		// 弹出栈顶
		YxfNode<E> result = this.top;
		this.top = this.top.next;
		return result.data;
	}

	/**
     * Description：取栈顶值，未弹出<br>
     * author：袁小飞 <br>
     * date：2019年7月24日 上午9:36:52 <br>
     */
	@Override
	public E get() {
		if (null == this.top) {
			return null;
		}
		return this.top.data;
	}
	
	/**
	 * Description：返回栈值<br>
	 * @author 袁小飞 <br>
	 * date 2019年7月24日 下午2:13:43 <br>
	 */
	public String toString() {
		String str = "(";
		YxfNode<E> node = top;
		while (null != node) {
			str += node.data + ",";
			node = node.next;
		}
		return str.substring(0, str.length() - 1) + ")";
	}

	public static void main(String[] args) {
		YxfLinkedStack<String> linkedStack = new YxfLinkedStack<>();
		System.out.println(linkedStack.isEmpty());
		linkedStack.push("A");
		linkedStack.push("B");
		System.out.println(linkedStack.toString());
		String s = linkedStack.pop();
		System.out.println(s);
		linkedStack.push("C");
		System.out.println(linkedStack.toString());
		System.out.println(linkedStack.isEmpty());
	}
}
