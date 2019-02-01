package project.controller.test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import project.controller.HistoryController;
import project.model.FileModel;
import project.service.HistoryService;

public class HistoryControllerTest {
	public HistoryController hc;
	public HistoryService historyServiceMock;

	@Before
	public void setup() {
		hc = new HistoryController();
		historyServiceMock = Mockito.mock(HistoryService.class);
		hc.setHistoryService(historyServiceMock);
		System.out.println("before");
	}

	@Test
	public void getHistory() {

		List<FileModel> response = hc.getHistory();
	}
}
