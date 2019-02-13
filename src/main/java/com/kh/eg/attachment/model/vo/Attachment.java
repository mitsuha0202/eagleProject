package com.kh.eg.attachment.model.vo;

public class Attachment implements java.io.Serializable {

	private String attachmentNo;
	private String orginName;
	private String changeName;
	private String root;
	private int fileLevel;
	private String addStatus;
	private String boardNo;
	private String itemNo;
	

	public Attachment() {}


	public String getAttachmentNo() {
		return attachmentNo;
	}


	public void setAttachmentNo(String attachmentNo) {
		this.attachmentNo = attachmentNo;
	}


	public String getOrginName() {
		return orginName;
	}


	public void setOrginName(String orginName) {
		this.orginName = orginName;
	}


	public String getChangeName() {
		return changeName;
	}


	public void setChangeName(String changeName) {
		this.changeName = changeName;
	}


	public String getRoot() {
		return root;
	}


	public void setRoot(String root) {
		this.root = root;
	}


	public int getFileLevel() {
		return fileLevel;
	}


	public void setFileLevel(int fileLevel) {
		this.fileLevel = fileLevel;
	}


	public String getAddStatus() {
		return addStatus;
	}


	public void setAddStatus(String addStatus) {
		this.addStatus = addStatus;
	}


	public String getBoardNo() {
		return boardNo;
	}


	public void setBoardNo(String boardNo) {
		this.boardNo = boardNo;
	}


	@Override
	public String toString() {
		return "Attachment [attachmentNo=" + attachmentNo + ", orginName=" + orginName + ", changeName=" + changeName
				+ ", root=" + root + ", fileLevel=" + fileLevel + ", addStatus=" + addStatus + ", boardNo=" + boardNo
				+ ", itemNo=" + itemNo + "]";
	}


	public Attachment(String attachmentNo, String orginName, String changeName, String root, int fileLevel,
			String addStatus, String boardNo, String itemNo) {
		super();
		this.attachmentNo = attachmentNo;
		this.orginName = orginName;
		this.changeName = changeName;
		this.root = root;
		this.fileLevel = fileLevel;
		this.addStatus = addStatus;
		this.boardNo = boardNo;
		this.itemNo = itemNo;
	}


	public String getItemNo() {
		return itemNo;
	}


	public void setItemNo(String itemNo) {
		this.itemNo = itemNo;
	}
	
	
	
}
