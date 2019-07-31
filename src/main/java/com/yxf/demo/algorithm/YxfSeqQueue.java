package com.yxf.demo.algorithm;

/**
 * Description：顺序队列 <br>
 * @author 袁小飞 <br>
 * date 2019年7月16日 下午4:24:08 <br>
 */
public class YxfSeqQueue<E> implements YxfQueue<E>{
	
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
	public YxfSeqQueue(){
		this(16);
	}

	/**
	 * Description：构建指定容量与下标的空队列<br>
	 * author：袁小飞 <br>
	 * date：2019年7月16日 下午4:29:39 <br>
	 */
	public YxfSeqQueue(int capacity) {
		// 取绝对值初始化队列,防止出现负数
		this.data = new Object[Math.abs(capacity)];
		this.front = this.rear = -1;
	}

	/**
	 * Description：判断队列是否为空，若为空返回true <br>
	 * author：袁小飞 <br>
	 * date：2019年7月16日 下午4:21:34 <br>
	 */
	@Override
	public boolean isEmpty() {
		return this.front == -1 && this.rear == -1;
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
		if (isEmpty()) {
			// 为空队列时,将数据入队队列头部,并且头部下标与尾部下标+1
			this.data[0] = element;
			this.front++;
			this.rear++;
		} else {
			// 队列不为空时,将数据从尾部入队,并且尾部下标+1
			// 判断本次入队是否大于队列容量
			if (this.rear > data.length - 1) {
				// 队列扩容
				Object[] temp = this.data;
				// 将队列扩容为之前的两倍
				this.data = new Object[temp.length * 2];
				for (int i = 0; i < temp.length; i++) {
					this.data[i] = temp[i];
				}
			}
			this.data[++this.rear] = element;
		}
		return true;
	}

	/**
     * Description：出队，返回当前对头元素，若队列为空则返回null <br>
     * author：袁小飞 <br>
     * date：2019年7月16日 下午4:22:13 <br>
     */
	@Override
	@SuppressWarnings("unchecked")
	public E dequeue() {
		// 队列为空则返回null
		if (isEmpty()) {
			return null;
		}
		E temp = (E) this.data[this.front];
        this.front++;
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
			for (int i = front; i <= rear; i++) {
				// 如果队列中只有一个值就返回不加,
				if (i == this.rear) {
                    str += this.data[i];
                } else {
                    str += this.data[i] + ",";
                }
			}
		}
		return str + ")";
	}
	
	public static void main(String[] args) {
		YxfSeqQueue<String> queue = new YxfSeqQueue<>();
		System.out.println(queue.isEmpty());
		queue.enqueue("袁小飞");
		queue.enqueue("袁大飞");
		String s = queue.dequeue();
		System.out.println(s);
		System.out.println(queue.toString());
	}

}
