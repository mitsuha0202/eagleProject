package com.kh.eg.admin.model.vo;

import java.sql.Date;

public class Reply {
	
	private String commentNo;
	private Date writeday;
	private String contents;
	private String boardNo;
	private String memberNo;
	private String deletestatus;
	
	public void Reply() {}

	public Reply(String commentNo, Date writeday, String contents, String boardNo, String memberNo,
			String deletestatus) {
		super();
		this.commentNo = commentNo;
		this.writeday = writeday;
		this.contents = contents;
		this.boardNo = boardNo;
		this.memberNo = memberNo;
		this.deletestatus = deletestatus;
	}

	public String getCommentNo() {
		return commentNo;
	}

	public void setCommentNo(String commentNo) {
		this.commentNo = commentNo;
	}

	public Date getWriteday() {
		return writeday;
	}

	public void setWriteday(Date writeday) {
		this.writeday = writeday;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public String getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(String boardNo) {
		this.boardNo = boardNo;
	}

	public String getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(String memberNo) {
		this.memberNo = memberNo;
	}

	public String getDeletestatus() {
		return deletestatus;
	}

	public void setDeletestatus(String deletestatus) {
		this.deletestatus = deletestatus;
	}

	@Override
	public String toString() {
		return "Reply [commentNo=" + commentNo + ", writeday=" + writeday + ", contents=" + contents + ", boardNo="
				+ boardNo + ", memberNo=" + memberNo + ", deletestatus=" + deletestatus + "]";
	}
	
	
	
	
}










