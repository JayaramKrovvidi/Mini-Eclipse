package project.controller.test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import project.controller.ResultDisplayController;
import project.model.FileResultRow;
import project.service.ResultDisplayService;

public class ResultDisplayControllerTest {
	public ResultDisplayController rc;
	public ResultDisplayService resultServiceMock;

	@Before
	public void setup() {
		rc = new ResultDisplayController();
		resultServiceMock = Mockito.mock(ResultDisplayService.class);
		rc.setResultService(resultServiceMock);
		System.out.println("before");
	}
	
	@Test
	public void getByIDTest() {
		List<FileResultRow> list = rc.getByID(2);
	}

}
