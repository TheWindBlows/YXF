package com.yxf.demo.algorithm;

/**
 * Description：顺序栈<br>
 * @author 袁小飞 <br>
 * date 2019年7月24日 上午9:38:53 <br>
 */
public class YxfSeqStack<E> implements YxfStack<E> {
	
	// 栈
	private Object[] data;
	
	// 栈头下标
	private int top;
	
	/**
	 * Description：初始化栈，默认容量16<br>
	 * author：袁小飞 <br>
	 * date：2019年7月24日 下午1:42:31 <br> <br>
	 */
	public YxfSeqStack() {
		this(16);
	}
	
	/**
	 * Description：根据参数进行初始化栈<br>
	 * author：袁小飞 <br>
	 * date：2019年7月24日 下午1:42:57 <br>
	 */
	public YxfSeqStack(int capacity) {
		this.data = new Object[Math.abs(capacity)];
		top = -1;
	}

	/**
	 * Description：判断栈是否为空<br>
	 * author：袁小飞 <br>
	 * date：2019年7月24日 上午9:35:31 <br>
	 */
	@Override
	public boolean isEmpty() {
		return -1 == this.top;
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
		// 判断是否需要进行扩容
		if (this.top == this.data.length - 1) {
			Object[] tmp = this.data;
			// 扩容到原来的一倍
			this.data = new Object[this.data.length << 1];
			// 遍历放回新数组
			for (int i = 0; i < tmp.length; i++) {
				this.data[i] = tmp[i];
			}
			this.top = tmp.length - 1;
		}
		
		// 栈顶加1
		this.top++;
		// 将数据入栈到栈顶中
		this.data[this.top] = element;
		return true;
	}

	/**
     * Description：出栈 <br>
     * author：袁小飞 <br>
     * date：2019年7月24日 上午9:36:29 <br>
     */
	@SuppressWarnings("unchecked")
	@Override
	public E pop() {
		if (isEmpty()) {
			return null;
		}
		// 弹出栈顶数据，栈顶下标-1
		return (E) this.data[this.top--];
	}

	/**
     * Description：取栈顶值，未弹出<br>
     * author：袁小飞 <br>
     * date：2019年7月24日 上午9:36:52 <br>
     */
	@SuppressWarnings("unchecked")
	@Override
	public E get() {
		if (isEmpty()) {
			return null;
		}
		// 取出栈顶数据，栈顶下标不变
		return (E) this.data[this.top];
	}
	
	/**
	 * Description：返回栈值<br>
	 * @author 袁小飞 <br>
	 * date 2019年7月24日 下午2:13:43 <br>
	 */
	public String toString() {
		String str = "(";
		for (int i = this.top; i >= 0; i--) {
			if (null == this.data[i]) {
				break;
			}
			str += this.data[i] + ",";
		}
		return str.substring(0,str.length() - 1) + ")";
	}

	public static void main(String[] args) {
		YxfStack<String> stack = new YxfSeqStack<>(16);
		System.out.println(stack.isEmpty());
		stack.push("A");
		stack.push("B");
		System.out.println(stack.toString());
		String s = stack.pop();
		System.out.println(s);
		stack.push("C");
		System.out.println(stack.toString());
		s = stack.pop();
		System.out.println(s);
		System.out.println(stack.toString());
		System.out.println(stack.isEmpty());
	}
}
