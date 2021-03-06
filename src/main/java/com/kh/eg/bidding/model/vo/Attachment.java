package com.kh.eg.bidding.model.vo;

public class Attachment implements java.io.Serializable{
	String attachmentNo;
	String originName;
	String changeName;
	String root;
	int fileLevel;
	String addStatus;
	String boardNo;
	String itemNo;
	
	public Attachment() {}

	@Override
	public String toString() {
		return "Attachment [attachmentNo=" + attachmentNo + ", originName=" + originName + ", changeName=" + changeName
				+ ", root=" + root + ", fileLevel=" + fileLevel + ", addStatus=" + addStatus + ", boardNo=" + boardNo
				+ ", itemNo=" + itemNo + "]";
	}

	public Attachment(String attachmentNo, String originName, String changeName, String root, int fileLevel,
			String addStatus, String boardNo, String itemNo) {
		super();
		this.attachmentNo = attachmentNo;
		this.originName = originName;
		this.changeName = changeName;
		this.root = root;
		this.fileLevel = fileLevel;
		this.addStatus = addStatus;
		this.boardNo = boardNo;
		this.itemNo = itemNo;
	}

	public String getAttachmentNo() {
		return attachmentNo;
	}

	public void setAttachmentNo(String attachmentNo) {
		this.attachmentNo = attachmentNo;
	}

	public String getOriginName() {
		return originName;
	}

	public void setOriginName(String originName) {
		this.originName = originName;
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

	public String getItemNo() {
		return itemNo;
	}

	public void setItemNo(String itemNo) {
		this.itemNo = itemNo;
	}
	
	
}
