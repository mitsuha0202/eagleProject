package com.kh.eg.bidding.model.vo;

public class Board implements java.io.Serializable{
	String boardNo;
	String title;
	String boardContent;
	String mNo;
	String writeDay;
	String deleteStatus;
	String boardStatus;
	String replyStatus;
	int bCount;
	String sMno;
	String itemNo;
	String mName;
	
	public Board() {}

	@Override
	public String toString() {
		return "Board [boardNo=" + boardNo + ", title=" + title + ", boardContent=" + boardContent + ", mNo=" + mNo
				+ ", writeDay=" + writeDay + ", deleteStatus=" + deleteStatus + ", boardStatus=" + boardStatus
				+ ", replyStatus=" + replyStatus + ", bCount=" + bCount + ", sMno=" + sMno + ", itemNo=" + itemNo
				+ ", mName=" + mName + "]";
	}

	public Board(String boardNo, String title, String boardContent, String mNo, String writeDay, String deleteStatus,
			String boardStatus, String replyStatus, int bCount, String sMno, String itemNo, String mName) {
		super();
		this.boardNo = boardNo;
		this.title = title;
		this.boardContent = boardContent;
		this.mNo = mNo;
		this.writeDay = writeDay;
		this.deleteStatus = deleteStatus;
		this.boardStatus = boardStatus;
		this.replyStatus = replyStatus;
		this.bCount = bCount;
		this.sMno = sMno;
		this.itemNo = itemNo;
		this.mName = mName;
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

	public String getmNo() {
		return mNo;
	}

	public void setmNo(String mNo) {
		this.mNo = mNo;
	}

	public String getWriteDay() {
		return writeDay;
	}

	public void setWriteDay(String writeDay) {
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

	public int getbCount() {
		return bCount;
	}

	public void setbCount(int bCount) {
		this.bCount = bCount;
	}

	public String getsMno() {
		return sMno;
	}

	public void setsMno(String sMno) {
		this.sMno = sMno;
	}

	public String getItemNo() {
		return itemNo;
	}

	public void setItemNo(String itemNo) {
		this.itemNo = itemNo;
	}

	public String getmName() {
		return mName;
	}

	public void setmName(String mName) {
		this.mName = mName;
	}

	
	
}
