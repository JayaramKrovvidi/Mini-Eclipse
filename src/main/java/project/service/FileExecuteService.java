package project.service;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.dao.FileDao;
import project.dao.HistoryDao;
import project.dao.ResultsDao;
import project.model.FileModel;
import project.model.FileResultRow;
import project.model.XLFile;

@Service
public class FileExecuteService {
	@Autowired
	HistoryDao historyDao;

	@Autowired
	FileDao fileDao;
	
	@Autowired
	ResultsDao resultsDao;

	List<FileResultRow> fileResultList = new ArrayList<>();

	public void getFileAndExecute(int id) {
		Blob blobFile = fileDao.getFile(id);
		try {
			InputStream in = blobFile.getBinaryStream();
			startAutomation(in, id);

		} catch (Exception e) {
			e.toString();
		}

	}

	public void startAutomation(InputStream in, int id) throws IOException, ParseException {
		XSSFWorkbook myWorkBook = new XSSFWorkbook(in);
		XSSFSheet mySheet = myWorkBook.getSheetAt(0);
		Iterator<Row> rowIterator = mySheet.iterator();

		int rowCount = 0;

		XLFile excelPojo = new XLFile();

		while (rowIterator.hasNext()) {
			Row row = rowIterator.next();
			try {
				if (rowCount > 0) {
					excelPojo.setLineNo(rowCount);
					excelPojo.setMethodName(row.getCell(0).toString());
					excelPojo.setURL(row.getCell(1).toString());
					if (row.getCell(2) != null)
						excelPojo.setBody(row.getCell(2).toString());
					double q = Double.parseDouble(row.getCell(3).toString());
					int temp = (int) q;
					excelPojo.setExpectedResponseCode(temp);
					excelPojo.setExpectedResposeType(row.getCell(4).toString());

					if (checkMethodName(excelPojo.getMethodName()))
						methodTesting(id, excelPojo);
				}
				rowCount++;
			} catch (Exception e) {
				e.toString();
			}
		}
		addFileInHistory(id, rowCount - 1);
	}

	public void addFileInHistory(int id, int totalRowCount) throws ParseException {
		int passCount = 0;
		int failCount = 0;
		for (FileResultRow rs : fileResultList) {
			if (rs.getResult()) {
				passCount++;
			} else {
				failCount++;
			}
		}

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss", Locale.ENGLISH);

		String t1 = fileResultList.get(0).getStartTime();
		String t2 = fileResultList.get(fileResultList.size() - 1).getEndTime();

		Date parsedTimeStamp = dateFormat.parse(t1.substring(0, t1.length() - 4));
		Timestamp ts1 = new Timestamp(parsedTimeStamp.getTime());
		Date parsedTimeStamp1 = dateFormat.parse(t2.substring(0, t1.length() - 4));
		Timestamp ts2 = new Timestamp(parsedTimeStamp1.getTime());

		long milliseconds = ts2.getTime() - ts1.getTime();
		int seconds = (int) milliseconds / 1000;

		FileModel fm = new FileModel(id, fileDao.getFileName(id), totalRowCount, t1, t2, passCount, failCount,
				(passCount * 100) / totalRowCount , seconds);
		historyDao.saveSummary(fm);
		this.fileResultList = new ArrayList<>();
	}

	public void methodTesting(int fileId, XLFile xl) throws IOException {
		HttpUriRequest request = new HttpGet(xl.getURL());
		HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);
		Date date = new Date();
		FileResultRow rs = null;
		if (httpResponse.getStatusLine().getStatusCode() == xl.getExpectedResponseCode() && ContentType
				.getOrDefault(httpResponse.getEntity()).getMimeType().equalsIgnoreCase(xl.getExpectedResposeType())) {
			rs = new FileResultRow(fileId, xl.getLineNo(), xl.getMethodName(), new Timestamp(date.getTime()).toString(),
					new Timestamp(date.getTime()).toString(), xl.getExpectedResponseCode(), xl.getExpectedResposeType(),
					httpResponse.getStatusLine().getStatusCode(),
					ContentType.getOrDefault(httpResponse.getEntity()).getMimeType(), true);
			resultsDao.insertResult(rs);
		} else {
			rs = new FileResultRow(fileId, xl.getLineNo(), xl.getMethodName(), new Timestamp(date.getTime()).toString(),
					new Timestamp(date.getTime()).toString(), xl.getExpectedResponseCode(), xl.getExpectedResposeType(),
					httpResponse.getStatusLine().getStatusCode(),
					ContentType.getOrDefault(httpResponse.getEntity()).getMimeType(), false);
			resultsDao.insertResult(rs);
		}

		fileResultList.add(rs);
	}
	
	public boolean checkMethodName(String m)
	{
		if(m.equalsIgnoreCase("GET") || m.equalsIgnoreCase("POST") || m.equalsIgnoreCase("PUT") || m.equalsIgnoreCase("DELETE"))
			return true;
		else
			return false;
	}

	public void setFileService(FileDao fileDaoMock) {
		this.fileDao = fileDaoMock;
	}

	public void setHistoryService(HistoryDao historyDaoMock) {
		this.historyDao = historyDaoMock;
		
	}

	public void setResultService(ResultsDao resultDaoMock) {
		this.resultsDao = resultDaoMock;
		
	}

}
