package com.yxf.demo.design;

/**
 * Description：单例模式 <br>
 * @author 袁小飞 <br>
 * date 2019年7月4日 下午2:33:19 <br>
 */
public class Singleton {
}

/**
 * Description：单例模式-饿汉模式 <br>
 * @author 袁小飞 <br>
 * date 2019年7月4日 下午2:37:04 <br>
 */
class Hungry{
	
	// 创建私有静态实例，意味着这个类第一次使用的时候就会进行创建
	private static Hungry hungry = new Hungry();
	
	private Hungry() {};
	
	public static Hungry getHungry() {
		return hungry;
	}
}

/**
 * Description：单例模式-饱汉模式 <br>
 * @author 袁小飞 <br>
 * date 2019年7月4日 下午2:39:25 <br>
 */
class Full{
	
	private Full() {};
	
	/**
	 * 使用volatele原因:
	 * 	1.可见性
	 * 	2.防止指令重排序
	 */
	private volatile static Full full = null;
	
	/**
	 * Description：创建full对象,在synchronize前加一个if判断可以创建之后不需要先加锁再判断对象是否为空,直接获取已有对象 <br>
	 * author：袁小飞 <br>
	 * date：2019年7月4日 下午2:48:23 <br>
	 */
	public Full getFull() {
		if (null == full) {
			synchronized (Full.class) {
				if (null == full) {
					full = new Full();
				} 
			}
		}
		return full;
	}
}

/**
 * Description：单例模式-内部类 <br>
 * @author 袁小飞 <br>
 * date 2019年7月4日 下午2:52:36 <br>
 */
class InternalClass{
	
	private InternalClass() {};
	
	// 主要是使用了 嵌套类可以访问外部类的静态属性和静态方法 的特性
	private static class Holder{
		private static InternalClass internalCalss = new InternalClass();
	}
	
	public static InternalClass getInternalClass() {
		return Holder.internalCalss;
	}
	
}

