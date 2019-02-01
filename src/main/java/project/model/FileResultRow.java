package project.model;

public class FileResultRow {
	private int fileId;
	private int lineNo;
	private String methodName;

	private String startTime;
	private String endTime;
	private int expectedResponseCode;
	private String expectedResponseType;
	private int obtainedResponseCode;
	private String obtainedResponseType;
	private boolean result;

	public FileResultRow(int fileId, int lineNo, String methodName, String startTime, String endTime, int expectedResponseCode,
			String expectedResponseType, int obtainedResponseCode, String obtainedResponseType, boolean result) {
		super();
		this.lineNo = lineNo;
		this.fileId = fileId;
		this.methodName = methodName;
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

	public String getMethodName() {
		return methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
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

	public boolean getResult() {
		return result;
	}

	public void setResult(boolean result) {
		this.result = result;
	}

	@Override
	public String toString() {
		return "FileResultRow [fileId=" + fileId + ", lineNo=" + lineNo + ", startTime=" + startTime + ", endTime="
				+ endTime + ", expectedResponseCode=" + expectedResponseCode + ", expectedResponseType="
				+ expectedResponseType + ", obtainedResponseCode=" + obtainedResponseCode + ", obtainedResponseType="
				+ obtainedResponseType + ", result=" + result + "]";
	}

}
