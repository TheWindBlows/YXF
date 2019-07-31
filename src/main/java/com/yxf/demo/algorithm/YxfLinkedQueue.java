package com.yxf.demo.algorithm;

/**
 * Description：链式队列 <br>
 * @author 袁小飞 <br>
 * date 2019年7月22日 下午3:04:18 <br>
 */
public class YxfLinkedQueue<E> implements YxfQueue<E> {
	
    private YxfNode<E> front;// 队列头节点
    private YxfNode<E> rear;// 队列尾节点

    /**
	 * Description：判断队列是否为空，若为空返回true <br>
	 * author：袁小飞 <br>
	 * date：2019年7月16日 下午4:21:34 <br>
	 */
	@Override
	public boolean isEmpty() {
		return front == null && rear == null;
	}

	/**
     * Description：元素入队，操作成功返回true <br>
     * author：袁小飞 <br>
     * date：2019年7月16日 下午4:21:56 <br>
     */
	@Override
	public boolean enqueue(E element) {
		if (null == element) {
			return false;
		}
		YxfNode<E> node = new YxfNode<>(element);
		if (isEmpty()) {
			// 空队列,新的节点作为头节点
			this.front = node;
		} else {
			// 不为空队列,新的节点作为尾节点
			this.rear.next = node;
		}
		this.rear = node;
		return true;
	}

	/**
     * Description：出队，返回当前对头元素，若队列为空则返回null <br>
     * author：袁小飞 <br>
     * date：2019年7月16日 下午4:22:13 <br>
     */
	@Override
	public E dequeue() {
		if (!isEmpty()) {
			// 取得链表队列中的头节点
			E e = this.front.data;
			// 删除头节点
			this.front = this.front.next;
			// 如果对头为空，则是空队列，队尾也置为空
			if (null == this.front) {
				this.rear = null;
			}
			return e;
		}
		return null;
	}
	
	/**
     * Description：将队列内的值转换成String <br>
     * author：袁小飞 <br>
     * date：2019年7月17日 下午1:39:34 <br>
     */
	public String toString() {
		StringBuffer str = new StringBuffer();
		str.append("(");
		YxfNode<E> node = this.front;
		while (null != node) {
			str.append(node.data);
			if (node != this.rear) {
				str.append(",");
			}
			node = node.next;
		}
		str.append(")");
		return str.toString();
	}
	
	public static void main(String[] args) {
        YxfQueue<String> queue = new YxfLinkedQueue<String>();
        queue.dequeue();//出栈
        System.out.println(queue.toString());
        queue.enqueue("A");// 元素在队尾入队
        queue.enqueue("B");
        queue.enqueue("C");
        queue.enqueue("D");
        System.out.println(queue.toString());
        queue.dequeue();// 对头出队
        System.out.println(queue.toString());
    }

}
