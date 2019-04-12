package com.test.domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Student {
	private int sid;
	private String sname;
	private String gender;
	private String phone;
	private Date birthday;//Date类型
	private String hobby;
	private String info;
	
	public String getHobby() {
		return hobby==null?"":hobby;
	}
	public void setHobby(String hobby) {
		if(hobby!=null)
		this.hobby = hobby;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname==null?"":sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getGender() {
		return gender==null?"":gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPhone() {
		return phone==null?"":phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Date getBirthday() {
			return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getInfo() {
		return info==null?"":info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public Student(String sname, String gender, String phone, Date birthday, String hobby, String info) {
		super();
		this.sname = sname;
		this.gender = gender;
		this.phone = phone;
		this.birthday = birthday;
		this.hobby = hobby;
		this.info = info;
	}
	public Student(int sid, String sname, String gender, String phone, Date birthday, String hobby, String info) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.gender = gender;
		this.phone = phone;
		this.birthday = birthday;
		this.hobby = hobby;
		this.info = info;
	}
	public Student() {
		super();
	}
	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + ", gender=" + gender + ", phone=" + phone + ", birthday="
				+ birthday + ", hobby=" + hobby + ", info=" + info + "]";
	}
}
