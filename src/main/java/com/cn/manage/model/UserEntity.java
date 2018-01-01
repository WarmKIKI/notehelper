package com.cn.manage.model;



import java.util.Date;

import javax.persistence.*;

/**
 * UserEntity实体类
 * @filename UserEntity.java
 * @author   warmCheng
 * @date     2017年11月9日
 */
@Table(name = "user")
public class UserEntity {
	@Id
	@Column(name = "user_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	private String name;
	private String email;
	private String password;
	private String userImg="picture/头像无法显示.png";
	private int userRank=1;
	private String userIdentity;
	private String userPhone;
	private String userAddress;
	private String userEducation;
	private Date  userBrithday=new Date("1995/08/19");



	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getname() {
		return name;
	}

	public void setname(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserImg() {
		return userImg;
	}

	public void setUserImg( String userImg) {
		this.userImg = userImg;
	}

	public int getUserRank() {
		return userRank;
	}

	public void setUserRank(int userRank) {
		this.userRank = userRank;
	}

	public String getUserIdentity() {
		return userIdentity;
	}

	public void setUserIdentity(String userIdentity) {
		this.userIdentity = userIdentity;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public String getUserEducation() {
		return userEducation;
	}

	public void setUserEducation(String userEducation) {
		this.userEducation = userEducation;
	}

	public Date getUserBrithday() {
		return userBrithday;
	}

	public void setUserBrithday(Date userBrithday) {
		this.userBrithday = userBrithday;
	}


}
