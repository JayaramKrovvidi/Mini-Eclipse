package project.service.test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import project.dao.FileDao;
import project.dao.HistoryDao;
import project.dao.ResultsDao;
import project.service.FileExecuteService;

public class FileExecuteServiceTest {
	public FileDao fileDaoMock;
	public HistoryDao historyDaoMock;
	public ResultsDao resultDaoMock;
	
	public FileExecuteService fileExecuteService;
	
	@Before
	public void setup() {
		fileExecuteService = new FileExecuteService();
		fileDaoMock = Mockito.mock(FileDao.class);
		historyDaoMock = Mockito.mock(HistoryDao.class);
		resultDaoMock = Mockito.mock(ResultsDao.class);
		fileExecuteService.setFileService(fileDaoMock);
		fileExecuteService.setHistoryService(historyDaoMock);
		fileExecuteService.setResultService(resultDaoMock);
		System.out.println("before");
	}
	
	@Test
	public void getFileAndExecuteTest() {
		fileExecuteService.getFileAndExecute(85);
	}
	
	@Test
	public void startAutomationTest() throws IOException, ParseException {
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
		
		fileExecuteService.startAutomation(result.getInputStream(), 2);
	}
}
