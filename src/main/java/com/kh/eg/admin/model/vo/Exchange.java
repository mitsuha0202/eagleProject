package com.kh.eg.admin.model.vo;

public class Exchange implements java.io.Serializable{
	
	private String rating;
	private String memberId;
	private int mMoney;
	private int eMoney;
	private String acName;
	private String bkName;
	private String accountNo;
	
	public Exchange () {}

	public Exchange(String rating, String memberId, int mMoney, int eMoney, String acName, String bkName,
			String accountNo) {
		super();
		this.rating = rating;
		this.memberId = memberId;
		this.mMoney = mMoney;
		this.eMoney = eMoney;
		this.acName = acName;
		this.bkName = bkName;
		this.accountNo = accountNo;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public int getmMoney() {
		return mMoney;
	}

	public void setmMoney(int mMoney) {
		this.mMoney = mMoney;
	}

	public int geteMoney() {
		return eMoney;
	}

	public void seteMoney(int eMoney) {
		this.eMoney = eMoney;
	}

	public String getAcName() {
		return acName;
	}

	public void setAcName(String acName) {
		this.acName = acName;
	}

	public String getBkName() {
		return bkName;
	}

	public void setBkName(String bkName) {
		this.bkName = bkName;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	@Override
	public String toString() {
		return "Exchange [rating=" + rating + ", memberId=" + memberId + ", mMoney=" + mMoney + ", eMoney=" + eMoney
				+ ", acName=" + acName + ", bkName=" + bkName + ", accountNo=" + accountNo + "]";
	}

	

}
