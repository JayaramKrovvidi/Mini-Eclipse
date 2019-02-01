package project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import project.model.FileModel;
import project.service.HistoryService;

@RestController
@RequestMapping("/history")
public class HistoryController {
	@Autowired
	HistoryService historyService;

	@GetMapping(value = "/getHistory", produces = "application/json")
	public List<FileModel> getHistory() {
		return historyService.getHistory();
	}

	public void setHistoryService(HistoryService historyServiceMock) {
		this.historyService = historyServiceMock;
		
	}

}
