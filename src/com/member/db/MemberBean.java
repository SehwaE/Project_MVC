package com.member.db;

import java.sql.Timestamp;

public class MemberBean {

	private String id;
	private String pw;
	private String name;
	private String email;
	private String phone;
	private Timestamp reg_date;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Timestamp getReg_date() {
		return reg_date;
	}
	public void setReg_date(Timestamp reg_date) {
		this.reg_date = reg_date;
	}
	
	@Override
	public String toString() {
		return "MemberBean [id=" + id + ", pw=" + pw + ", name=" + name + ", email=" + email + ", phone=" + phone
				+ ", reg_date=" + reg_date + "]";
	}

	
	
	
	
	
	
}