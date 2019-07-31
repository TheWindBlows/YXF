package com.yxf.demo.design;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Description：代理模式 <br>
 * @author 袁小飞 <br>
 * date 2019年7月15日 下午4:17:15 <br>
 */
public class ProxyPattern {
	public static void main(String[] args) {
		// 静态代理
		UserService userService = new UserServiceImpl();
		StaticProxy staticProxy = new StaticProxy(userService);
		staticProxy.addUser();
		staticProxy.delUser();
		
		// 动态代理
		UserInvocationHandler handler = new UserInvocationHandler(userService);
		// 得到一个动态代理的对象,参数1:定义由那个加载器来加载代理类、2:提供一个接口数组、3:由那个一Handler进行方法调用
		UserService userServiceProxy = (UserService) Proxy.newProxyInstance(userService.getClass().getClassLoader(), userService.getClass().getInterfaces() , handler);
		System.out.println(userServiceProxy.getClass().getName());
		userServiceProxy.addUser();
		userServiceProxy.delUser();
	}
}

/**
 * Description：方法类 <br>
 * @author 袁小飞 <br>
 * date 2019年7月15日 下午5:02:11 <br>
 */
interface UserService{
	public void addUser();
	public void delUser();
}

/**
 * Description：实现类 <br>
 * @author 袁小飞 <br>
 * date 2019年7月15日 下午5:02:24 <br>
 */
class UserServiceImpl implements UserService{

	@Override
	public void addUser() {
		System.out.println("添加用户");
	}

	@Override
	public void delUser() {
		System.out.println("删除用户");
	}
	
}

/**
 * Description：静态代理类 <br>
 * @author 袁小飞 <br>
 * date 2019年7月15日 下午5:02:36 <br>
 */
class StaticProxy implements UserService{
	
	private UserService userService;
	
	public StaticProxy(UserService userService) {
		this.userService = userService;
	}

	@Override
	public void addUser() {
		System.out.println("静态前置");
		userService.addUser();
		System.out.println("静态后置");
	}

	@Override
	public void delUser() {
		System.out.println("静态前置");
		userService.delUser();
		System.out.println("静态后置");
	}
}

/**
 * Description：动态代理类 <br>
 * @author 袁小飞 <br>
 * date 2019年7月15日 下午5:11:57 <br>
 */
class UserInvocationHandler implements InvocationHandler{
	
	private Object obj;
	
	public UserInvocationHandler(Object obj) {
		this.obj = obj;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("动态前置");
		// 当代理对象调用真实对象的方法时，其会自动的跳转到代理对象关联的handler对象的invoke方法来进行调用
		Object result = method.invoke(obj, args);
		System.out.println("动态后置");
		return result;
	}
	
}