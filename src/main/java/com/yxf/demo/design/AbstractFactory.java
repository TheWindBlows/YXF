package com.yxf.demo.design;

/**
 * Description：抽象工厂模式 <br>
 * @author 袁小飞 <br>
 * date 2019年7月4日 下午2:13:53 <br>
 */
public class AbstractFactory {
	
	public static void main(String[] args) {
		AbstractCarFactory bmwFactory = new bmwCarFactory();
		AbstractCar bmwCar = bmwFactory.buildCar();
		AbstractCarFactory benzFactory = new benzCarFactory();
		AbstractCar benzCar = benzFactory.buildCar();
		bmwCar.run();
		benzCar.run();
	}
}

/**
 * Description：构建工厂抽象类 <br>
 * @author 袁小飞 <br>
 * date 2019年7月4日 下午2:30:39 <br>
 */
interface AbstractCarFactory{
	public AbstractCar buildCar();
}

/**
 * Description：创建bmw工厂 <br>
 * @author 袁小飞 <br>
 * date 2019年7月4日 下午2:31:02 <br>
 */
class bmwCarFactory implements AbstractCarFactory{
	@Override
	public AbstractCar buildCar() {
		return new bmwCar();
	}
}

/**
 * Description：构建benz工厂 <br>
 * @author 袁小飞 <br>
 * date 2019年7月4日 下午2:31:22 <br>
 */
class benzCarFactory implements AbstractCarFactory{
	@Override
	public AbstractCar buildCar() {
		return new benzCar();
	}
}

/**
 * Description：构建车的动作 <br>
 * @author 袁小飞 <br>
 * date 2019年7月4日 下午2:31:38 <br>
 */
interface AbstractCar{
	public void run();
}

/**
 * Description：实现bmw车动作 <br>
 * @author 袁小飞 <br>
 * date 2019年7月4日 下午2:31:51 <br>
 */
class bmwCar implements AbstractCar{
	@Override
	public void run() {
		System.out.println("bmw run");
	}
}

/**
 * 
 * Description：实现benz车动作 <br>
 * @author 袁小飞 <br>
 * date 2019年7月4日 下午2:32:18 <br>
 */
class benzCar implements AbstractCar{
	@Override
	public void run() {
		System.out.println("benz run");
	}
}
