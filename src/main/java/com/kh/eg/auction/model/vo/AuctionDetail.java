package com.kh.eg.auction.model.vo;

import java.sql.Date;

import org.springframework.stereotype.Component;

@Component
public class AuctionDetail implements java.io.Serializable {
	private String startDay;
	private String endDay;
	private String exitYN;
	private int itemNo;
	
	
	public AuctionDetail() {}


	public String getStartDay() {
		return startDay;
	}


	public void setStartDay(String startDay) {
		this.startDay = startDay;
	}


	public String getEndDay() {
		return endDay;
	}


	public void setEndDay(String endDay) {
		this.endDay = endDay;
	}


	public String getExitYN() {
		return exitYN;
	}


	public AuctionDetail(String startDay, String endDay, String exitYN, int itemNo) {
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
