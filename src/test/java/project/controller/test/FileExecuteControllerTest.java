package project.controller.test;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import project.controller.FileExecuteController;
import project.service.FileExecuteService;

public class FileExecuteControllerTest {
	public FileExecuteController fc;
	public FileExecuteService fileServiceMock;

	@Before
	public void setup() {
		fc = new FileExecuteController();
		fileServiceMock = Mockito.mock(FileExecuteService.class);
		fc.executeFile(fileServiceMock);
		System.out.println("before");
	}

	@Test
	public void executeFileTest() {
		fc.executeFile(11);
	}
}
