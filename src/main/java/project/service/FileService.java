package project.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.sql.rowset.serial.SerialBlob;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import project.dao.FileDao;
import project.model.FileResultRow;
import project.model.XLFile;

@Service
public class FileService {
	
	@Autowired
	FileDao fileDao;
	
	List<FileResultRow> fileResultList = new ArrayList<FileResultRow>();
	
	public void storeWithDao(MultipartFile file)
	{
		try
		{
			String name = file.getOriginalFilename();
			byte[] bytes = file.getBytes();
			Blob blobFile = new SerialBlob(bytes);
			fileDao.storeInDb(blobFile,name);
		}
		catch(Exception e)
		{
			System.out.println("File Error");
		}
	}
	
	public void startAutomation(MultipartFile mFile) throws IOException {
		File file = convert(mFile);
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook myWorkBook = new XSSFWorkbook (fis);
		XSSFSheet mySheet = myWorkBook.getSheetAt(0); 
		Iterator<Row> rowIterator = mySheet.iterator();
		
		int i=0;
		List<XLFile> xlList = new ArrayList<>();
		
		
		XLFile xl = new XLFile();
		while (rowIterator.hasNext()) {
			Row row = rowIterator.next(); 
			if(i>0) {
				xl.setLineNo(i);
				xl.setMethodName(row.getCell(0).toString());
				xl.setURL(row.getCell(1).toString());
				xl.setBody(row.getCell(2).toString());
				xl.setExpectedResponseCode(Integer.parseInt(row.getCell(3).toString()));
				xl.setExpectedResposeType(row.getCell(4).toString());
			}
		}
	}
	
	public File convert(MultipartFile file){    
		String path="D:/";
		File upLoadedfile=null;
		try{
			upLoadedfile = new File(path+file.getOriginalFilename());
			file.transferTo(upLoadedfile);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	    return upLoadedfile;
	}
}
