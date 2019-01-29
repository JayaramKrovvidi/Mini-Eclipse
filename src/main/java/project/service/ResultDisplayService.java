package project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.dao.ResultDisplayDao;
import project.model.FileResultRow;

@Service
public class ResultDisplayService {
	
	@Autowired
	ResultDisplayDao resultDisplayDao;
	
	
	public List<FileResultRow> getAllRecords() {
		
		return resultDisplayDao.getAllRecords();
		
	}

//	public static List<FileResultRow> getByID(int id) {
//		
//		return resultDisplayDao.getByID(id);
//		
//	}

}
