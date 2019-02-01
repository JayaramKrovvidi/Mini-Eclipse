package project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.dao.ResultsDao;
import project.model.FileResultRow;

@Service
public class ResultDisplayService {

	@Autowired
	ResultsDao resultsDao;

	public List<FileResultRow> getByID(int id) {

		return resultsDao.getByID(id);

	}

}
