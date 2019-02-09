package com.kh.eg.member.model.vo;

public class Member {
	
	private String mid;
	private String userName;
	private String userId;
	private String userPwd;
	private String account;
	private String phone;
	private String address;
	private String rating;
	private int emoney;
	private String wdStatus;
	private String blStatus;
	private String joinDate;
	
	
	public Member() {}


	public Member(String mid, String userName, String userId, String userPwd, String account, String phone,
			String address, String rating, int emoney, String wdStatus, String blStatus, String joinDate) {
		super();
		this.mid = mid;
		this.userName = userName;
		this.userId = userId;
		this.userPwd = userPwd;
		this.account = account;
		this.phone = phone;
		this.address = address;
		this.rating = rating;
		this.emoney = emoney;
		this.wdStatus = wdStatus;
		this.blStatus = blStatus;
		this.joinDate = joinDate;
	}


	public String getMid() {
		return mid;
	}


	public void setMid(String mid) {
		this.mid = mid;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public String getUserPwd() {
		return userPwd;
	}


	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}


	public String getAccount() {
		return account;
	}


	public void setAccount(String account) {
		this.account = account;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getRating() {
		return rating;
	}


	public void setRating(String rating) {
		this.rating = rating;
	}


	public int getEmoney() {
		return emoney;
	}


	public void setEmoney(int emoney) {
		this.emoney = emoney;
	}


	public String getWdStatus() {
		return wdStatus;
	}


	public void setWdStatus(String wdStatus) {
		this.wdStatus = wdStatus;
	}


	public String getBlStatus() {
		return blStatus;
	}


	public void setBlStatus(String blStatus) {
		this.blStatus = blStatus;
	}


	public String getJoinDate() {
		return joinDate;
	}


	public void setJoinDate(String joinDate) {
		this.joinDate = joinDate;
	}


	@Override
	public String toString() {
		return "Member [mid=" + mid + ", userName=" + userName + ", userId=" + userId + ", userPwd=" + userPwd
				+ ", account=" + account + ", phone=" + phone + ", address=" + address + ", rating=" + rating
				+ ", emoney=" + emoney + ", wdStatus=" + wdStatus + ", blStatus=" + blStatus + ", joinDate=" + joinDate
				+ "]";
	}
	
	
}
