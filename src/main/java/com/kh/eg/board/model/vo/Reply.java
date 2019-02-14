package com.kh.eg.board.model.vo;

import java.sql.Date;

public class Reply {
	private String rid;
	private Date writeDay;
	private String rContent;
	private String reBid;
	private String reMid;
	private String rStatus;
	
	public Reply() {}

	public Reply(String rid, Date writeDay, String rContent, String reBid, String reMid, String rStatus) {
		super();
		this.rid = rid;
		this.writeDay = writeDay;
		this.rContent = rContent;
		this.reBid = reBid;
		this.reMid = reMid;
		this.rStatus = rStatus;
	}

	public String getRid() {
		return rid;
	}

	public void setRid(String rid) {
		this.rid = rid;
	}

	public Date getWriteDay() {
		return writeDay;
	}

	public void setWriteDay(Date writeDay) {
		this.writeDay = writeDay;
	}

	public String getrContent() {
		return rContent;
	}

	public void setrContent(String rContent) {
		this.rContent = rContent;
	}

	public String getReBid() {
		return reBid;
	}

	public void setReBid(String reBid) {
		this.reBid = reBid;
	}

	public String getReMid() {
		return reMid;
	}

	public void setReMid(String reMid) {
		this.reMid = reMid;
	}

	public String getrStatus() {
		return rStatus;
	}

	public void setrStatus(String rStatus) {
		this.rStatus = rStatus;
	}

	@Override
	public String toString() {
		return "Reply [rid=" + rid + ", writeDay=" + writeDay + ", rContent=" + rContent + ", reBid=" + reBid
				+ ", reMid=" + reMid + ", rStatus=" + rStatus + "]";
	}
	
	
	
}
