package com.kh.eg.myPage.model.vo;

import java.sql.Date;

public class AnswerBoard implements java.io.Serializable{

	
	private String boardNo;
	private String itemNo;
	private String title;
	private String replystatus;
	private String memberId;
	private Date writeDay;
	
	
	public AnswerBoard(String boardNo, String itemNo, String title, String replystatus, String memberId,
			Date writeDay) {
		super();
		this.boardNo = boardNo;
		this.itemNo = itemNo;
		this.title = title;
		this.replystatus = replystatus;
		this.memberId = memberId;
		this.writeDay = writeDay;
	}


	public AnswerBoard() {
		// TODO Auto-generated constructor stub
	}


	public String getBoardNo() {
		return boardNo;
	}


	public void setBoardNo(String boardNo) {
		this.boardNo = boardNo;
	}


	public String getItemNo() {
		return itemNo;
	}


	public void setItemNo(String itemNo) {
		this.itemNo = itemNo;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getReplystatus() {
		return replystatus;
	}


	public void setReplystatus(String replystatus) {
		this.replystatus = replystatus;
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


	@Override
	public String toString() {
		return "AnswerBoard [boardNo=" + boardNo + ", itemNo=" + itemNo + ", title=" + title + ", replystatus="
				+ replystatus + ", memberId=" + memberId + ", writeDay=" + writeDay + "]";
	}
	
	

}
