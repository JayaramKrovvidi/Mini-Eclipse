package project.controller;

import javax.servlet.annotation.MultipartConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import project.model.CustomResponse;
import project.service.FileService;

@RestController
@MultipartConfig
public class FileController {
	@Autowired
	FileService fileService;

	@PostMapping(path = "/upload")
	// @CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<CustomResponse> storeWithService(@RequestParam("testingData") MultipartFile file) {
		try {
			int fileId = fileService.storeWithDao(file);

			return new ResponseEntity<>(
					new CustomResponse("You successfully uploaded " + file.getOriginalFilename(), fileId),
					HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(new CustomResponse("Failed to upload file" + file.getOriginalFilename(), -1),
					HttpStatus.EXPECTATION_FAILED);
		}

	}

	public void setFileService(FileService fileServiceMock) {
		this.fileService = fileServiceMock;

	}

}
