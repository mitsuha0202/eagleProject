package com.kh.eg.myPage.model.vo;

public class RatingMyPage implements java.io.Serializable{
	private int count;
	private int amount;
	
	public RatingMyPage() {
	
	}
	
	public RatingMyPage(int count, int amount) {
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

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "RatingMyPage [count=" + count + ", amount=" + amount + "]";
	}
	
}
