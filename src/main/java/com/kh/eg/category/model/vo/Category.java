package com.kh.eg.category.model.vo;

import org.springframework.stereotype.Component;

@Component
public class Category implements java.io.Serializable {

	private String categoryNo;
	private String categoryName;
	private int categoryLevel;
	private String upperCategoryNo;
	private String deleteYn;
	
	public Category() {}

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

	public int getCategoryLevel() {
		return categoryLevel;
	}

	public void setCategoryLevel(int categoryLevel) {
		this.categoryLevel = categoryLevel;
	}

	public String getUpperCategoryNo() {
		return upperCategoryNo;
	}

	public void setUpperCategoryNo(String upperCategoryNo) {
		this.upperCategoryNo = upperCategoryNo;
	}

	public String getDeleteYn() {
		return deleteYn;
	}

	public void setDeleteYn(String deleteYn) {
		this.deleteYn = deleteYn;
	}

	@Override
	public String toString() {
		return "Category [categoryNo=" + categoryNo + ", categoryName=" + categoryName + ", categoryLevel="
				+ categoryLevel + ", upperCategoryNo=" + upperCategoryNo + ", deleteYn=" + deleteYn + "]";
	}

	public Category(String categoryNo, String categoryName, int categoryLevel, String upperCategoryNo,
			String deleteYn) {
		super();
		this.categoryNo = categoryNo;
		this.categoryName = categoryName;
		this.categoryLevel = categoryLevel;
		this.upperCategoryNo = upperCategoryNo;
		this.deleteYn = deleteYn;
	}
	
	
	
}
