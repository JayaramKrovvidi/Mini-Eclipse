package project.controller;

import javax.servlet.annotation.MultipartConfig;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import project.model.ResponseObject;
import project.service.FileService;

@RestController
@MultipartConfig
public class FileController {
	@Autowired
	FileService fileService;
	
	@PostMapping(path = "/upload", produces = "application/json")
	//@CrossOrigin(origins = "http://localhost:4200") // Call  from Local Angular
	public ResponseObject storeWithService(@RequestParam("testingData") MultipartFile file)
	{
		String message = "";
		try
		{
			fileService.storeWithDao(file);
			message = "You successfully uploaded " + file.getOriginalFilename() + "!";
			fileService.startAutomation(file);
			Thread.sleep(5000);
			return new ResponseObject("success");
		}
		catch(Exception e) 
		{
			message = "Fail to upload Profile Picture" + file.getOriginalFilename() + "!";
			//return new ResponseEntity<>(message,HttpStatus.EXPECTATION_FAILED);
			return new ResponseObject("Failed");
		}
	}
	
	@GetMapping("/gets")
	public String gets()
	{
		return "Hello";
	}
}
