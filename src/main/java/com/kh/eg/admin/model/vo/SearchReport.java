package com.kh.eg.admin.model.vo;

public class SearchReport {

	private String userId;
	private String title;
	private String itemNo;
	
	public SearchReport() {}

	public SearchReport(String userId, String title, String itemNo) {
		super();
		this.userId = userId;
		this.title = title;
		this.itemNo = itemNo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
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
		return "SearchReport [userId=" + userId + ", title=" + title + ", itemNo=" + itemNo + "]";
	}
	
}
