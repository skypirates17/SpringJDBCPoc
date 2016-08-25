package com.poc.dto;

import com.poc.model.User;

public class DataTransferObject {
	private User user;
	
	public DataTransferObject(){}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

}
