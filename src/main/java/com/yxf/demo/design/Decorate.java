package com.yxf.demo.design;

/**
 * Description：装饰者模式 <br>
 * @author 袁小飞 <br>
 * date 2019年7月16日 下午3:45:11 <br>
 */
public class Decorate {
	
	public static void main(String[] args) {
		People people = new PeopleImpl();
		PeopleBefore peopleBefore = new PeopleBefore(people);
		peopleBefore.say();
		PeopleAfter peopleAfter = new PeopleAfter(people);
		peopleAfter.say();
	}

}

/**
 * Description：方法类 <br>
 * @author 袁小飞 <br>
 * date 2019年7月16日 下午3:55:21 <br>
 */
interface People{
	public void say();
}

/**
 * Description：实现类 <br>
 * @author 袁小飞 <br>
 * date 2019年7月16日 下午3:55:35 <br>
 */
class PeopleImpl implements People{
	@Override
	public void say() {
		System.out.println("我要吃饭!!!");
	}
}

/**
 * Description：抽象装饰器 <br>
 * @author 袁小飞 <br>
 * date 2019年7月16日 下午3:58:20 <br>
 */
abstract class PeopleDecorator implements People{
	
	private People people;
	
	public PeopleDecorator(People people){
		this.people = people;
	}
	@Override
	public void say() {
		people.say();
	}
}

/**
 * Description：具体装饰器 1<br>
 * @author 袁小飞 <br>
 * date 2019年7月16日 下午3:55:09 <br>
 */
class PeopleBefore extends PeopleDecorator{

	public PeopleBefore(People people) {
		super(people);
	}
	
	@Override
	public void say() {
		this.before();
		super.say();
	}
	
	private void before() {
		System.out.println("前置");
	}
}

/**
 * Description：具体装饰器2<br>
 * @author 袁小飞 <br>
 * date 2019年7月16日 下午3:55:09 <br>
 */
class PeopleAfter extends PeopleDecorator{

	public PeopleAfter(People people) {
		super(people);
	}
	
	@Override
	public void say() {
		super.say();
		this.after();
	}
	
	private void after() {
		System.out.println("后置");
	}
}


