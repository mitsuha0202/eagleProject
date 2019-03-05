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
	private int bCount;
	private String sMid;
	private String userName;
	private String itemNo;
	private ArrayList<Reply> replyList;
	private int rNum;
	
	public Board() {}

	public Board(String bid, String bTitle, String bContent, String bMid, Date writeDay, String bStatus, String bType,
			String reStatus, int bCount, String sMid, String userName, String itemNo, ArrayList<Reply> replyList,
			int rNum) {
		super();
		this.bid = bid;
		this.bTitle = bTitle;
		this.bContent = bContent;
		this.bMid = bMid;
		this.writeDay = writeDay;
		this.bStatus = bStatus;
		this.bType = bType;
		this.reStatus = reStatus;
		this.bCount = bCount;
		this.sMid = sMid;
		this.userName = userName;
		this.itemNo = itemNo;
		this.replyList = replyList;
		this.rNum = rNum;
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

	public String getbType() {
		return bType;
	}

	public void setbType(String bType) {
		this.bType = bType;
	}

	public String getReStatus() {
		return reStatus;
	}

	public void setReStatus(String reStatus) {
		this.reStatus = reStatus;
	}

	public int getbCount() {
		return bCount;
	}

	public void setbCount(int bCount) {
		this.bCount = bCount;
	}

	public String getsMid() {
		return sMid;
	}

	public void setsMid(String sMid) {
		this.sMid = sMid;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getItemNo() {
		return itemNo;
	}

	public void setItemNo(String itemNo) {
		this.itemNo = itemNo;
	}

	public ArrayList<Reply> getReplyList() {
		return replyList;
	}

	public void setReplyList(ArrayList<Reply> replyList) {
		this.replyList = replyList;
	}

	public int getrNum() {
		return rNum;
	}

	public void setrNum(int rNum) {
		this.rNum = rNum;
	}

	@Override
	public String toString() {
		return "Board [bid=" + bid + ", bTitle=" + bTitle + ", bContent=" + bContent + ", bMid=" + bMid + ", writeDay="
				+ writeDay + ", bStatus=" + bStatus + ", bType=" + bType + ", reStatus=" + reStatus + ", bCount="
				+ bCount + ", sMid=" + sMid + ", userName=" + userName + ", itemNo=" + itemNo + ", replyList="
				+ replyList + ", rNum=" + rNum + "]";
	}

	

	

	

	

	
	
	
}
