package com.example.petstore.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Pet")
public class Pet implements Serializable {

	private static final long serialVersionUID = -3352680435189176469L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "name", nullable = true, length = 20)
	private String name;

	@Column(name = "type", nullable = true, length = 20)
	private String type;

	@Column(name = "age", nullable = false, length = 20)
	private int age;

	@Column(name = "userid", nullable = true, length = 20)
	private int userid;

	public Pet(int id, String name, String type, int age, int userid) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.age = age;
		this.userid = userid;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public Pet() {
		super();
	}

	@Override
	public String toString() {
		return "Pet [id=" + id + ", name=" + name + ", type=" + type + ", age=" + age + ", userid=" + userid + "]";
	}

	
}
