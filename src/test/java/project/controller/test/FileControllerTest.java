package project.controller.test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import project.controller.FileController;
import project.model.CustomResponse;
import project.service.FileService;

public class FileControllerTest {
	public FileController fc;
	public FileService fileServiceMock;

	@Before
	public void setup() {
		fc = new FileController();
		fileServiceMock = Mockito.mock(FileService.class);
		fc.setFileService(fileServiceMock);
		System.out.println("before");
	}

	@Test
	public void storeWithServiceTest() {
		Path path = Paths.get("C:/Users/Jayaram.das/Downloads/sampleData1.xlsx");
		String name = "sampleData1.xlsx";
		String originalFileName = "sampleData1.xlsx";
		String contentType = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
		byte[] content = null;
		try {
			content = Files.readAllBytes(path);
		} catch (final IOException e) {
			System.out.println("error");
		}
		MultipartFile result = new MockMultipartFile(name, originalFileName, contentType, content);
		ResponseEntity<CustomResponse> response = fc.storeWithService(result);
	}

}
