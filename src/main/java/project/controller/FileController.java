package project.controller;

import javax.servlet.annotation.MultipartConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import project.service.FileService;

@RestController
@MultipartConfig
public class FileController {
	@Autowired
	FileService fileService;
	
	@PostMapping("/upload")
	@CrossOrigin(origins = "http://localhost:4200") // Call  from Local Angualar
	public ResponseEntity <String> storeWithService(@RequestParam("testingData") MultipartFile file)
	{
		String message = "";
		try
		{
			fileService.storeWithDao(file);
			message = "You successfully uploaded " + file.getOriginalFilename() + "!";
			return ResponseEntity.status(HttpStatus.OK).body(message);
		}
		catch(Exception e) 
		{
			message = "Fail to upload Profile Picture" + file.getOriginalFilename() + "!";
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);
		}
	}
	
	@GetMapping("/gets")
	public String gets()
	{
		return "Hello";
	}
}
