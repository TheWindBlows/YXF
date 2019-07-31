package com.yxf.demo.algorithm;

/**
 * Description：顺序循环队列 <br>
 * @author 袁小飞 <br>
 * date 2019年7月17日 下午1:58:31 <br>
 */
public class YxfSeqCycleQueue<E> implements YxfQueue<E> {
	
	// 存放数据数组
	private Object[] data;
	// 队列头部下标
	private int front;
	// 队列尾部下标
	private int rear;
	
	/**
	 * Description：构建初始化容量与下标的空队列 <br>
	 * author：袁小飞 <br>
	 * date：2019年7月16日 下午4:27:01 <br> <br>
	 */
	public YxfSeqCycleQueue(){
		this(16);
	}

	/**
	 * Description：构建指定容量与下标的空队列<br>
	 * author：袁小飞 <br>
	 * date：2019年7月16日 下午4:29:39 <br>
	 */
	public YxfSeqCycleQueue(int capacity) {
		// 取绝对值初始化队列,防止出现负数
		this.data = new Object[Math.abs(capacity)];
		this.front = this.rear = 0;
	}

	/**
	 * Description：判断队列是否为空，若为空返回true<br>
	 * @author 袁小飞 <br>
	 * date 2019年7月17日 下午2:01:54 <br>
	 */
	@Override
	public boolean isEmpty() {
		return this.front == this.rear;
	}

	/**
     * Description：元素入队，操作成功返回true <br>
     * author：袁小飞 <br>
     * date：2019年7月16日 下午4:21:56 <br>
     */
	@Override
	public boolean enqueue(E element) {
		// 空元素不允许入队列
		if (null == element) {
			return false;
		}
		// 判断头部与尾部是否相撞,如果相撞表示队列已经满了,需要进行扩容处理
		if (this.front == (this.rear + 1) % data.length) {
			// 队列扩容
			Object[] temp = this.data;
			// 将队列扩容为之前的两倍
			this.data = new Object[temp.length * 2];
			int i = this.front,j = 0;
			// 判断头部与尾部是否相撞,相撞表示队列已经遍历结束
			while (i != this.rear) {
				this.data[j] = temp[i];
				// 对下一个下标取余获得准确下标
				i = ++i % temp.length;
				j++;
			}
			// 新队列的front为0
			this.front = 0;
			// 新队列的rear从索引j开始
			this.rear = j;
		}
		this.data[this.rear] = element;
		this.rear = (this.rear + 1) % this.data.length;
		return true;
	}

	@Override
	@SuppressWarnings("unchecked")
	public E dequeue() {
		// 队列为空则返回null
		if (isEmpty()) {
			return null;
		}
		E temp = (E) this.data[this.front];
        this.front = ++this.front % this.data.length;
        return temp;
	}
	
	/**
     * Description：将队列内的值转换成String <br>
     * author：袁小飞 <br>
     * date：2019年7月17日 下午1:39:34 <br>
     */
	public String toString() {
		String str = "(";
		if (!isEmpty()) {
			int frontNum = this.front % this.data.length;
			while (true) {
				str += this.data[frontNum] + ",";
				frontNum = (frontNum + 1) % this.data.length;
				if (frontNum == this.rear) {
					str = str.substring(0, str.length() - 1);
					break;
				}
			}
		}
		str += ")";
		return str;
	}
	
	public static void main(String[] args) {
		YxfSeqCycleQueue<String> queue = new YxfSeqCycleQueue<>(4);
		queue.enqueue("1");
		queue.enqueue("2");
		queue.enqueue("3");
		String s = queue.dequeue();
		System.out.println(s);
		queue.enqueue("4");
		queue.enqueue("5");
		System.out.println(queue.toString());
	}

}
