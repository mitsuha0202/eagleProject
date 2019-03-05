package com.kh.eg.admin.model.vo;

import java.sql.Date;

public class Post implements java.io.Serializable{
	private String boardNo;
	private String memberId;
	private Date writeDay;
	private String phone;
	private String reply;
	private String title;
	
	public Post() {}

	public Post(String boardNo, String memberId, Date writeDay, String phone, String reply, String title) {
		super();
		this.boardNo = boardNo;
		this.memberId = memberId;
		this.writeDay = writeDay;
		this.phone = phone;
		this.reply = reply;
		this.title = title;
	}

	public String getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(String boardNo) {
		this.boardNo = boardNo;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public Date getWriteDay() {
		return writeDay;
	}

	public void setWriteDay(Date writeDay) {
		this.writeDay = writeDay;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getReply() {
		return reply;
	}

	public void setReply(String reply) {
		this.reply = reply;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "Post [boardNo=" + boardNo + ", memberId=" + memberId + ", writeDay=" + writeDay + ", phone=" + phone
				+ ", reply=" + reply + ", title=" + title + "]";
	}

	
	
}
