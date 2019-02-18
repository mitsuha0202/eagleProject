package com.kh.eg.auction.model.vo;

import java.sql.Date;

import org.springframework.stereotype.Component;

@Component
public class AuctionDetail implements java.io.Serializable {
	private Date startDay;
	private Date endDay;
	private String exitYN;
	private int itemNo;
	
	
	public AuctionDetail() {}


	public AuctionDetail(Date startDay, Date endDay, String exitYN, int itemNo) {
		super();
		this.startDay = startDay;
		this.endDay = endDay;
		this.exitYN = exitYN;
		this.itemNo = itemNo;
	}


	@Override
	public String toString() {
		return "AuctionDetail [startDay=" + startDay + ", endDay=" + endDay + ", exitYN=" + exitYN + ", itemNo="
				+ itemNo + "]";
	}


	public Date getStartDay() {
		return startDay;
	}


	public void setStartDay(Date startDay) {
		this.startDay = startDay;
	}


	public Date getEndDay() {
		return endDay;
	}


	public void setEndDay(Date endDay) {
		this.endDay = endDay;
	}


	public String getExitYN() {
		return exitYN;
	}


	public void setExitYN(String exitYN) {
		this.exitYN = exitYN;
	}


	public int getItemNo() {
		return itemNo;
	}


	public void setItemNo(int itemNo) {
		this.itemNo = itemNo;
	}
	
	
}
