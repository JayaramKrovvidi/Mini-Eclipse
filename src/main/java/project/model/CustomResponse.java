package project.model;

public class CustomResponse {

	private String description;
	private int fileId;

	public int getFileId() {
		return fileId;
	}

	public void setFileId(int fileId) {
		this.fileId = fileId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public CustomResponse(String description, int fileId) {
		super();
		this.description = description;
		this.fileId = fileId;
	}

	public CustomResponse() {
	}

}
