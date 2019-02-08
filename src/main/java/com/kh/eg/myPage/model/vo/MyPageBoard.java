package com.kh.eg.myPage.model.vo;

import java.sql.Date;

import org.springframework.stereotype.Component;

@Component
public class MyPageBoard implements java.io.Serializable{
	private int boardNo;
	private String title;
	private String boardContents;
	private int memberNo;
	private Date writeDay;
	private String deleteStatus;
	private String boardStatus;
	private String replyStatus;
	
	public MyPageBoard() {
	
	}

	public MyPageBoard(int boardNo, String title, String boardContents, int memberNo, Date writeDay,
			String deleteStatus, String boardStatus, String replyStatus) {
		super();
		this.boardNo = boardNo;
		this.title = title;
		this.boardContents = boardContents;
		this.memberNo = memberNo;
		this.writeDay = writeDay;
		this.deleteStatus = deleteStatus;
		this.boardStatus = boardStatus;
		this.replyStatus = replyStatus;
	}

	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBoardContents() {
		return boardContents;
	}

	public void setBoardContents(String boardContents) {
		this.boardContents = boardContents;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public Date getWriteDay() {
		return writeDay;
	}

	public void setWriteDay(Date writeDay) {
		this.writeDay = writeDay;
	}

	public String getDeleteStatus() {
		return deleteStatus;
	}

	public void setDeleteStatus(String deleteStatus) {
		this.deleteStatus = deleteStatus;
	}

	public String getBoardStatus() {
		return boardStatus;
	}

	public void setBoardStatus(String boardStatus) {
		this.boardStatus = boardStatus;
	}

	public String getReplyStatus() {
		return replyStatus;
	}

	public void setReplyStatus(String replyStatus) {
		this.replyStatus = replyStatus;
	}

	@Override
	public String toString() {
		return "MyPageBoard [boardNo=" + boardNo + ", title=" + title + ", boardContents=" + boardContents
				+ ", memberNo=" + memberNo + ", writeDay=" + writeDay + ", deleteStatus=" + deleteStatus
				+ ", boardStatus=" + boardStatus + ", replyStatus=" + replyStatus + "]";
	}
	
}
