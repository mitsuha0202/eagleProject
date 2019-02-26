package com.kh.eg.myPage.model.vo;

public class RatingMyPage implements java.io.Serializable{
	private int count;
	private String amount;
	
	public RatingMyPage() {
	
	}
	
	public RatingMyPage(int count, String amount) {
		super();
		this.count = count;
		this.amount = amount;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "RatingMyPage [count=" + count + ", amount=" + amount + "]";
	}
	
}
