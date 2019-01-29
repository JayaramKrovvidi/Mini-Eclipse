package project.model;

import java.sql.Time;
import java.util.LinkedList;
import java.util.List;

import com.google.protobuf.Timestamp;

public class FileModel {
	private int fileId;
	private String fileName;
	private List<FileResultRow> rowsResultList;
	private long recordsCount;
	private Timestamp startTime;
	private long recordsPassed;
	private long recordsFailed;
	private double passPercentage;
	private long excecutionTime;
	
	
	
	
	public FileModel(int fileId, String fileName, long recordsCount,
			Timestamp startTime, long recordsPassed, long recordsFailed, double passPercentage, long excecutionTime) {
		super();
		this.fileId = fileId;
		this.fileName = fileName;
		this.rowsResultList = new LinkedList<>();
		this.recordsCount = recordsCount;
		this.startTime = startTime;
		this.recordsPassed = recordsPassed;
		this.recordsFailed = recordsFailed;
		this.passPercentage = passPercentage;
		this.excecutionTime = excecutionTime;
	}
	
	


	public FileModel() {
		super();
		// TODO Auto-generated constructor stub
	}




	public long getRecordsCount() {
		return recordsCount;
	}


	public void setRecordsCount(long recordsCount) {
		this.recordsCount = recordsCount;
	}


	public Timestamp getStartTime() {
		return startTime;
	}


	public void setStartTime(Timestamp startTime) {
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


	public long getExcecutionTime() {
		return excecutionTime;
	}


	public void setExcecutionTime(long excecutionTime) {
		this.excecutionTime = excecutionTime;
	}


	public int getFileId() {
		return fileId;
	}


	public void setFileId(int fileId) {
		this.fileId = fileId;
	}


	public String getFileName() {
		return fileName;
	}


	public void setFileName(String fileName) {
		this.fileName = fileName;
	}


	public List<FileResultRow> getRowsResultList() {
		return rowsResultList;
	}


	public void setRowsResultList(List<FileResultRow> rowsResultList) {
		this.rowsResultList = rowsResultList;
	}
	
	
	
}


