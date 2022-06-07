package com.springboot.webservices.restfulwebservices.beans;

public class Post {

	private String postId;
	private String messageCode;
	private String messageDescription;

	public Post(String messageCode, String messageDescription) {
		this.messageCode = messageCode;
		this.messageDescription = messageDescription;
	}

	public Post() {
	}
	
	public String getPostId() {
		return postId;
	}

	public void setPostId(String postId) {
		this.postId = postId;
	}

	public String getMessageCode() {
		return messageCode;
	}

	public void setMessageCode(String messageCode) {
		this.messageCode = messageCode;
	}

	public String getMessageDescription() {
		return messageDescription;
	}

	public void setMessageDescription(String messageDescription) {
		this.messageDescription = messageDescription;
	}

	@Override
	public String toString() {
		return "Post [postId=" + postId + ", messageCode=" + messageCode + ", messageDescription=" + messageDescription
				+ "]";
	}

}
