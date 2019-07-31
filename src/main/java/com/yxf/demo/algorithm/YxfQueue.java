package com.yxf.demo.algorithm;

/**
 * Description：队列接口 <br>
 * @author 袁小飞 <br>
 * date 2019年7月16日 下午4:20:40 <br>
 */
public interface YxfQueue<E> {
	
	/**
	 * Description：判断队列是否为空，若为空返回true <br>
	 * author：袁小飞 <br>
	 * date：2019年7月16日 下午4:21:34 <br>
	 */
    public boolean isEmpty();

    /**
     * Description：元素入队，操作成功返回true <br>
     * author：袁小飞 <br>
     * date：2019年7月16日 下午4:21:56 <br>
     */
    public boolean enqueue(E element);

    /**
     * Description：出队，返回当前对头元素，若队列为空则返回null <br>
     * author：袁小飞 <br>
     * date：2019年7月16日 下午4:22:13 <br>
     */
    public E dequeue();

}
