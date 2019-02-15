package com.kh.eg.admin.model.vo;

public class SearchCondition implements java.io.Serializable{
	private String userId;
	private String userName;
	private String phone;
	
	public SearchCondition() {}

	public SearchCondition(String userId, String userName, String phone) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.phone = phone;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "SearchCondition [userId=" + userId + ", userName=" + userName + ", phone=" + phone + "]";
	}
	
	
	
	
}
