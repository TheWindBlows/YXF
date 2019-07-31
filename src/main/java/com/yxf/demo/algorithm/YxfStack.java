package com.yxf.demo.algorithm;

/**
 * Description：栈接口 <br>
 * @author 袁小飞 <br>
 * date 2019年7月24日 上午9:35:00 <br>
 */
public interface YxfStack<E> {
	
	/**
	 * Description：判断栈是否为空<br>
	 * author：袁小飞 <br>
	 * date：2019年7月24日 上午9:35:31 <br>
	 */
    public boolean isEmpty();
    
    /**
     * Description：入栈 <br>
     * author：袁小飞 <br>
     * date：2019年7月24日 上午9:35:59 <br>
     */
    public boolean push(E element);
    
    /**
     * Description：出栈 <br>
     * author：袁小飞 <br>
     * date：2019年7月24日 上午9:36:29 <br>
     */
    public E pop();
    
    /**
     * Description：取栈顶值，未出栈<br>
     * author：袁小飞 <br>
     * date：2019年7月24日 上午9:36:52 <br>
     */
    public E get();

}
