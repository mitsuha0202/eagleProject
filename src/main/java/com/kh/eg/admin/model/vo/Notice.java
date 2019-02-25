package com.kh.eg.admin.model.vo;

import java.sql.Date;

public class Notice {
	private Date writeDay;
	private String memberId;
	private String title;
	private String content;
	
	public Notice() {}

	public Notice(Date writeDay, String memberId, String title, String content) {
		super();
		this.writeDay = writeDay;
		this.memberId = memberId;
		this.title = title;
		this.content = content;
	}

	public Date getWriteDay() {
		return writeDay;
	}

	public void setWriteDay(Date writeDay) {
		this.writeDay = writeDay;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "Notice [writeDay=" + writeDay + ", memberId=" + memberId + ", title=" + title + ", content=" + content
				+ "]";
	}

}
