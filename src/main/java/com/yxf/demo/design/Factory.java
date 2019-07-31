package com.yxf.demo.design;

/**
* @Description: 工厂模式
* @author: yxf
* @date: 2019年7月3日
 */
public class Factory {
	
	public static void main(String[] args) {
		CarFactory carFactory = new CarFactory();
		Car bmw = carFactory.getCar("bmw");
		bmw.run();
		Car benz = carFactory.getCar("benz");
		benz.run();
	}

}

class CarFactory{
	public Car getCar(String carName) {
		if ("bmw".equals(carName)) {
			return new Bmw();
		} else if ("benz".equals(carName)) {
			return new Benz();
		} else {
			return null;
		}
	}
}

class Car{
	public void run() {};
}

class Bmw extends Car{
	
	@Override
	public void run() {
		System.out.println("bmw is run");
	}
}

class Benz extends Car{
	
	@Override
	public void run() {
		System.out.println("benz is run");
	}
}

