package com.yxf.demo.mode.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.experimental.Accessors;
import org.hibernate.annotations.GenericGenerator;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
// 添加链式编程
@Accessors(chain = true)
@Table(name = "PERMISSION")
public class Permission {
	
	@Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	private String id;
	
	@Column(name = "PERMISSION_NAME",length = 32)
	private String permissionName;
}
