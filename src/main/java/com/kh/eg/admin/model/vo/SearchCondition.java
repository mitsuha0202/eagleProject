package com.kh.eg.admin.model.vo;

public class SearchCondition implements java.io.Serializable{
	private String userId;
	private String userName;
	private String phone;
	private String title;
	private String itemNo;
	
	public SearchCondition() {}

	public SearchCondition(String userId, String userName, String phone, String title, String itemNo) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.phone = phone;
		this.title = title;
		this.itemNo = itemNo;
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getItemNo() {
		return itemNo;
	}

	public void setItemNo(String itemNo) {
		this.itemNo = itemNo;
	}

	@Override
	public String toString() {
		return "SearchCondition [userId=" + userId + ", userName=" + userName + ", phone=" + phone + ", title=" + title
				+ ", itemNo=" + itemNo + "]";
	}

	
}
