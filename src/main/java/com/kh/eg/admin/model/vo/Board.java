package com.kh.eg.admin.model.vo;

import java.sql.Date;

public class Board {
	
	private String boardNo;
	private String title;
	private String boardContent;
	private String memberNo;
	private Date wirteDay;
	private String delStatus;
	private String boardStatus;
	private String replyStatus;
	private String bCount;
	private String sMemberNo;
	private String itemNo;
	
	public void Board() {}

	public Board(String boardNo, String title, String boardContent, String memberNo, Date wirteDay, String delStatus,
			String boardStatus, String replyStatus, String bCount, String sMemberNo, String itemNo) {
		super();
		this.boardNo = boardNo;
		this.title = title;
		this.boardContent = boardContent;
		this.memberNo = memberNo;
		this.wirteDay = wirteDay;
		this.delStatus = delStatus;
		this.boardStatus = boardStatus;
		this.replyStatus = replyStatus;
		this.bCount = bCount;
		this.sMemberNo = sMemberNo;
		this.itemNo = itemNo;
	}

	public String getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(String boardNo) {
		this.boardNo = boardNo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBoardContent() {
		return boardContent;
	}

	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}

	public String getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(String memberNo) {
		this.memberNo = memberNo;
	}

	public Date getWirteDay() {
		return wirteDay;
	}

	public void setWirteDay(Date wirteDay) {
		this.wirteDay = wirteDay;
	}

	public String getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(String delStatus) {
		this.delStatus = delStatus;
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

	public String getbCount() {
		return bCount;
	}

	public void setbCount(String bCount) {
		this.bCount = bCount;
	}

	public String getsMemberNo() {
		return sMemberNo;
	}

	public void setsMemberNo(String sMemberNo) {
		this.sMemberNo = sMemberNo;
	}

	public String getItemNo() {
		return itemNo;
	}

	public void setItemNo(String itemNo) {
		this.itemNo = itemNo;
	}

	@Override
	public String toString() {
		return "Board [boardNo=" + boardNo + ", title=" + title + ", boardContent=" + boardContent + ", memberNo="
				+ memberNo + ", wirteDay=" + wirteDay + ", delStatus=" + delStatus + ", boardStatus=" + boardStatus
				+ ", replyStatus=" + replyStatus + ", bCount=" + bCount + ", sMemberNo=" + sMemberNo + ", itemNo="
				+ itemNo + "]";
	}
	
	
	
}




