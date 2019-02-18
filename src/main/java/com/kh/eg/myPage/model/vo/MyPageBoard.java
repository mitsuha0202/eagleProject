package com.kh.eg.myPage.model.vo;

import java.sql.Date;

import org.springframework.stereotype.Component;

@Component
public class MyPageBoard implements java.io.Serializable{
	private String itemNo;
	private String boardNo;
	private String title;
	private String boardContents;
	private int memberNo;
	private Date writeDay;
	private String deleteStatus;
	private String boardStatus;
	private String replyStatus;
	private String rCommentNo;
	private Date rWriteDay;
	private String rContents;
	private String rDeleteStatus;
	private int count;
	private String saleMemberName;
	
	public MyPageBoard() {
	
	}

	public MyPageBoard(String itemNo, String boardNo, String title, String boardContents, int memberNo, Date writeDay,
			String deleteStatus, String boardStatus, String replyStatus, String rCommentNo, Date rWriteDay,
			String rContents, String rDeleteStatus, int count, String saleMemberName) {
		super();
		this.itemNo = itemNo;
		this.boardNo = boardNo;
		this.title = title;
		this.boardContents = boardContents;
		this.memberNo = memberNo;
		this.writeDay = writeDay;
		this.deleteStatus = deleteStatus;
		this.boardStatus = boardStatus;
		this.replyStatus = replyStatus;
		this.rCommentNo = rCommentNo;
		this.rWriteDay = rWriteDay;
		this.rContents = rContents;
		this.rDeleteStatus = rDeleteStatus;
		this.count = count;
		this.saleMemberName = saleMemberName;
	}

	public String getItemNo() {
		return itemNo;
	}

	public void setItemNo(String itemNo) {
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

	public String getrCommentNo() {
		return rCommentNo;
	}

	public void setrCommentNo(String rCommentNo) {
		this.rCommentNo = rCommentNo;
	}

	public Date getrWriteDay() {
		return rWriteDay;
	}

	public void setrWriteDay(Date rWriteDay) {
		this.rWriteDay = rWriteDay;
	}

	public String getrContents() {
		return rContents;
	}

	public void setrContents(String rContents) {
		this.rContents = rContents;
	}

	public String getrDeleteStatus() {
		return rDeleteStatus;
	}

	public void setrDeleteStatus(String rDeleteStatus) {
		this.rDeleteStatus = rDeleteStatus;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getSaleMemberName() {
		return saleMemberName;
	}

	public void setSaleMemberName(String saleMemberName) {
		this.saleMemberName = saleMemberName;
	}

	@Override
	public String toString() {
		return "MyPageBoard [itemNo=" + itemNo + ", boardNo=" + boardNo + ", title=" + title + ", boardContents="
				+ boardContents + ", memberNo=" + memberNo + ", writeDay=" + writeDay + ", deleteStatus=" + deleteStatus
				+ ", boardStatus=" + boardStatus + ", replyStatus=" + replyStatus + ", rCommentNo=" + rCommentNo
				+ ", rWriteDay=" + rWriteDay + ", rContents=" + rContents + ", rDeleteStatus=" + rDeleteStatus
				+ ", count=" + count + ", saleMemberName=" + saleMemberName + "]";
	}

}
