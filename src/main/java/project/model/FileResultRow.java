package project.model;

import java.sql.Timestamp;

public class FileResultRow {
	private int lineNo;
	private int fileId;
	private Timestamp startTime;
	private Timestamp endTime;
	private int expectedResponseCode;
	private String expectedResponseType;
	private int obtainedResponseCode;
	private String obtainedResponseType;
	private boolean result;
	
	public FileResultRow(int lineNo, int fileId, Timestamp startTime, Timestamp endTime, int expectedResponseCode,
			String expectedResponseType, int obtainedResponseCode, String obtainedResponseType, boolean result) {
		super();
		this.lineNo = lineNo;
		this.fileId = fileId;
		this.startTime = startTime;
		this.endTime = endTime;
		this.expectedResponseCode = expectedResponseCode;
		this.expectedResponseType = expectedResponseType;
		this.obtainedResponseCode = obtainedResponseCode;
		this.obtainedResponseType = obtainedResponseType;
		this.result = result;
	}

	public FileResultRow() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getLineNo() {
		return lineNo;
	}

	public void setLineNo(int lineNo) {
		this.lineNo = lineNo;
	}

	public int getFileId() {
		return fileId;
	}

	public void setFileId(int fileId) {
		this.fileId = fileId;
	}

	public Timestamp getStartTime() {
		return startTime;
	}

	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}

	public Timestamp getEndTime() {
		return endTime;
	}

	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}

	public int getExpectedResponseCode() {
		return expectedResponseCode;
	}

	public void setExpectedResponseCode(int expectedResponseCode) {
		this.expectedResponseCode = expectedResponseCode;
	}

	public String getExpectedResponseType() {
		return expectedResponseType;
	}

	public void setExpectedResponseType(String expectedResponseType) {
		this.expectedResponseType = expectedResponseType;
	}

	public int getObtainedResponseCode() {
		return obtainedResponseCode;
	}

	public void setObtainedResponseCode(int obtainedResponseCode) {
		this.obtainedResponseCode = obtainedResponseCode;
	}

	public String getObtainedResponseType() {
		return obtainedResponseType;
	}

	public void setObtainedResponseType(String obtainedResponseType) {
		this.obtainedResponseType = obtainedResponseType;
	}

	public boolean isResult() {
		return result;
	}

	public void setResult(boolean result) {
		this.result = result;
	}
	
	
		
}
