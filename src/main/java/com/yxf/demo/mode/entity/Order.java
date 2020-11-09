package com.yxf.demo.mode.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;


@Entity
@Getter
@Setter
// 添加链式编程
@Accessors(chain = true)
@Table(name = "ORDER")
public class Order {

	@Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	public String orderId;

	@Column(name = "NAME",length = 32)
	public String name;
}
