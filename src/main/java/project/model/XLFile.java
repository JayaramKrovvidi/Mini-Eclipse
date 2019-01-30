package project.model;

public class XLFile {
	private int lineNo;
	private String methodName;
	private String URL;
	private String body;
	private int expectedResponseCode;
	private String expectedResposeType;
	
	
	
	public XLFile() {
		super();
	}


	public XLFile(int lineNo, String methodName, String uRL, String body, int expectedResponseCode,
			String expectedResposeType) {
		super();
		this.lineNo = lineNo;
		this.methodName = methodName;
		URL = uRL;
		this.body = body;
		this.expectedResponseCode = expectedResponseCode;
		this.expectedResposeType = expectedResposeType;
	}


	public String getMethodName() {
		return methodName;
	}
	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}
	public String getURL() {
		return URL;
	}
	public void setURL(String uRL) {
		URL = uRL;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public int getExpectedResponseCode() {
		return expectedResponseCode;
	}
	public void setExpectedResponseCode(int expectedResponseCode) {
		this.expectedResponseCode = expectedResponseCode;
	}
	public String getExpectedResposeType() {
		return expectedResposeType;
	}
	public void setExpectedResposeType(String expectedResposeType) {
		this.expectedResposeType = expectedResposeType;
	}


	public int getLineNo() {
		return lineNo;
	}


	public void setLineNo(int lineNo) {
		this.lineNo = lineNo;
	}
	
	
}
