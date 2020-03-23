package com.yxf.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.yxf.demo.service.ConsumerService;
import com.yxf.demo.service.ProducerService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoTest {
	
	@Autowired
	public ProducerService p;
	
	@Autowired
	public ConsumerService c;

	@Test
	public void test() {
		try {
			p.messageSentOut("abc");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void test3() {
		try {
			p.messageSentOutOrder("yxf");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void test4() {
		try {
			p.messageSentOutTransaction("tansaction");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void test5() {
		try {
			p.messageSentOutBroadcasting("broadcasting");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
