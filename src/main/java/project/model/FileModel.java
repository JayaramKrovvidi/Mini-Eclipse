package project.model;

public class FileModel {
	private int fileId;
	private String fileName;
	private long recordsCount;
	private String startTime;
	private long recordsPassed;
	private long recordsFailed;
	private double passPercentage;
	private int executionTime;
	private String stopTime;

	public FileModel(int fileId, String fileName, long recordsCount, String startTime, String stopTime,
			long recordsPassed, long recordsFailed, double passPercentage, int executionTime) {
		super();
		this.fileId = fileId;
		this.fileName = fileName;
		this.recordsCount = recordsCount;
		this.startTime = startTime;
		this.recordsPassed = recordsPassed;
		this.recordsFailed = recordsFailed;
		this.passPercentage = passPercentage;
		this.executionTime = executionTime;
		this.setStopTime(stopTime);
	}

	public FileModel() {
	}

	public long getRecordsCount() {
		return recordsCount;
	}

	public void setRecordsCount(long recordsCount) {
		this.recordsCount = recordsCount;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public long getRecordsPassed() {
		return recordsPassed;
	}

	public void setRecordsPassed(long recordsPassed) {
		this.recordsPassed = recordsPassed;
	}

	public long getRecordsFailed() {
		return recordsFailed;
	}

	public void setRecordsFailed(long recordsFailed) {
		this.recordsFailed = recordsFailed;
	}

	public double getPassPercentage() {
		return passPercentage;
	}

	public void setPassPercentage(double passPercentage) {
		this.passPercentage = passPercentage;
	}

	public int getExecutionTime() {
		return executionTime;
	}

	public void setExecutionTime(int excecutionTime) {
		this.executionTime = excecutionTime;
	}

	public int getFileId() {
		return fileId;
	}

	public void setFileId(int fileId) {
		this.fileId = fileId;
	}

	public String getStopTime() {
		return stopTime;
	}

	public void setStopTime(String stopTime) {
		this.stopTime = stopTime;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

}
