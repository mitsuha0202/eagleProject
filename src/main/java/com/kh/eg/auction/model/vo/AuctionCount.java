package com.kh.eg.auction.model.vo;

import org.springframework.stereotype.Component;

@Component
public class AuctionCount implements java.io.Serializable{
	private int auctionCount;
	
	public AuctionCount() {
	
	}

	public AuctionCount(int auctionCount) {
		super();
		this.auctionCount = auctionCount;
	}

	public int getAuctionCount() {
		return auctionCount;
	}

	public void setAuctionCount(int auctionCount) {
		this.auctionCount = auctionCount;
	}

	@Override
	public String toString() {
		return "AuctionCount [auctionCount=" + auctionCount + "]";
	}
	
}
