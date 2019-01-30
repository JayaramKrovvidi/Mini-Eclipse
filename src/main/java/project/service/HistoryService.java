package project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.dao.HistoryDao;
import project.model.FileModel;


@Service
public class HistoryService {
	
	@Autowired
	HistoryDao historyDao;
	
	
	public List<FileModel> getHistory() {
		
		return historyDao.getHistory();
		
	}

}
