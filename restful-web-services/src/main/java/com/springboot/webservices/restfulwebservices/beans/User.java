package com.springboot.webservices.restfulwebservices.beans;

import java.util.Date;
import java.util.List;

public class User {

	private int userId;
	private String name;
	private String phoneNumber;
	private String emailId;
	private Date birthDate;
	private List<Post> posts;
	
	public User(int userId, String name, String phoneNumber, String emailId, Date birthDate) {
		this.userId = userId;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.emailId = emailId;
		this.birthDate = birthDate;
	}

	public User(int userId, String name, String phoneNumber, String emailId, Date birthDate, List<Post> posts) {
		this.userId = userId;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.emailId = emailId;
		this.birthDate = birthDate;
		this.posts = posts;
	}
	public User() {

	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", phoneNumber=" + phoneNumber + ", emailId=" + emailId
				+ ", birthDate=" + birthDate + "]";
	}

}
