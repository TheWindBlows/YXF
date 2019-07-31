package com.yxf.demo.mode.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "USER")
public class User implements Serializable{
	
	private static final long serialVersionUID = 8014192855158013953L;

	@Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	private String id;
	
	@Column(name = "USER_NAME",length = 32)
	private String userName;
	
	@Column(name = "PASS_WORD",length = 32)
	private String passWord;
	
	@ManyToMany(cascade = CascadeType.ALL,fetch=FetchType.EAGER)
	// 设置中间表的字段名与对应的关联id
	@JoinTable(name = "USER_ROLE", joinColumns = @JoinColumn(name = "USER_ID",referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(name = "ROLE_ID",referencedColumnName = "id"))
    private List<Role> roles;
}
