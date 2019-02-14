package com.kh.eg.board.model.vo;

import java.sql.Date;
import java.util.ArrayList;

public class Board implements java.io.Serializable{
	private String bid;
	private String bTitle;
	private String bContent;
	private String bMid;
	private Date writeDay;
	private String bStatus;
	private String bType;
	private String reStatus;
	private ArrayList<Reply> replyList;
	
	public Board() {}

	public Board(String bid, String bTitle, String bContent, String bMid, Date writeDay, String bStatus, String reStatus,
			ArrayList<Reply> replyList) {
		super();
		this.bid = bid;
		this.bTitle = bTitle;
		this.bContent = bContent;
		this.bMid = bMid;
		this.writeDay = writeDay;
		this.bStatus = bStatus;
		this.reStatus = reStatus;
		this.replyList = replyList;
	}

	public String getBid() {
		return bid;
	}

	public void setBid(String bid) {
		this.bid = bid;
	}

	public String getbTitle() {
		return bTitle;
	}

	public void setbTitle(String bTitle) {
		this.bTitle = bTitle;
	}

	public String getbContent() {
		return bContent;
	}

	public void setbContent(String bContent) {
		this.bContent = bContent;
	}

	public String getbMid() {
		return bMid;
	}

	public void setbMid(String bMid) {
		this.bMid = bMid;
	}

	public Date getWriteDay() {
		return writeDay;
	}

	public void setWriteDay(Date writeDay) {
		this.writeDay = writeDay;
	}

	public String getbStatus() {
		return bStatus;
	}

	public void setbStatus(String bStatus) {
		this.bStatus = bStatus;
	}

	public String getreStatus() {
		return reStatus;
	}

	public void setreStatus(String reStatus) {
		this.reStatus = reStatus;
	}

	public ArrayList<Reply> getReplyList() {
		return replyList;
	}

	public void setReplyList(ArrayList<Reply> replyList) {
		this.replyList = replyList;
	}

	@Override
	public String toString() {
		return "Board [bid=" + bid + ", bTitle=" + bTitle + ", bContent=" + bContent + ", bMid=" + bMid + ", writeDay="
				+ writeDay + ", bStatus=" + bStatus + ", reStatus=" + reStatus + ", replyList=" + replyList + "]";
	}
	
	
	
	
	
}
