package com.kh.eg.admin.model.vo;

import java.math.BigDecimal;

public class Category {
	
	private String categoryNo;
	private String categoryName;
	private java.math.BigDecimal categoryLevel;
	private String uppercategoryNo;
	private String deleteyn;
	
	public Category() {}

	public Category(String categoryNo, String categoryName, BigDecimal categoryLevel, String uppercategoryNo,
			String deleteyn) {
		super();
		this.categoryNo = categoryNo;
		this.categoryName = categoryName;
		this.categoryLevel = categoryLevel;
		this.uppercategoryNo = uppercategoryNo;
		this.deleteyn = deleteyn;
	}

	public String getCategoryNo() {
		return categoryNo;
	}

	public void setCategoryNo(String categoryNo) {
		this.categoryNo = categoryNo;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public java.math.BigDecimal getCategoryLevel() {
		return categoryLevel;
	}

	public void setCategoryLevel(java.math.BigDecimal categoryLevel) {
		this.categoryLevel = categoryLevel;
	}

	public String getUppercategoryNo() {
		return uppercategoryNo;
	}

	public void setUppercategoryNo(String uppercategoryNo) {
		this.uppercategoryNo = uppercategoryNo;
	}

	public String getDeleteyn() {
		return deleteyn;
	}

	public void setDeleteyn(String deleteyn) {
		this.deleteyn = deleteyn;
	}

	@Override
	public String toString() {
		return "Category [categoryNo=" + categoryNo + ", categoryName=" + categoryName + ", categoryLevel="
				+ categoryLevel + ", uppercategoryNo=" + uppercategoryNo + ", deleteyn=" + deleteyn + "]";
	}

	
}
