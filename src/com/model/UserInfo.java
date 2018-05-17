package com.model;

public class UserInfo {

	private int id;
	private String name;
	private String age;
	private String remark;

	public UserInfo(String name, String age, String remark) {
		super();
		this.name = name;
		this.age = age;
		this.remark = remark;
	}

	public UserInfo(int id, String name) {
		super();
		this.id = id;
		this.name = name;
}

	public UserInfo(int id, String name, String age,  String remark) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.remark = remark;
	}

	@Override
	public String toString() {
		String msg = "id=" + id 
				+ " ,name = " + name 
				+ ",age = " + age 
				+ ",remark = " + remark;
		System.out.println(msg);
		return msg;
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

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}


	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
