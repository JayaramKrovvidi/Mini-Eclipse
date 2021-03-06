package project.service;

import java.sql.Blob;

import javax.sql.rowset.serial.SerialBlob;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import project.dao.FileDao;

@Service
public class FileService {

	@Autowired
	FileDao fileDao;

	public int storeWithDao(MultipartFile file) {
		try {
			String name = file.getOriginalFilename();
			byte[] bytes = file.getBytes();
			Blob blobFile = new SerialBlob(bytes);
			return fileDao.storeInDb(blobFile, name);
		} catch (Exception e) {
			return -1;
		}
	}
}
