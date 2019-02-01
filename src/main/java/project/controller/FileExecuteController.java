package project.controller;

import javax.servlet.annotation.MultipartConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import project.service.FileExecuteService;

@RestController
@MultipartConfig
public class FileExecuteController {
	
	@Autowired
	FileExecuteService fileExecuteService;
	
	@PostMapping(value = "/execute/{Id}")
	public void executeFile(@PathVariable(value = "Id") int id) {
		fileExecuteService.getFileAndExecute(id);
	}

	public void executeFile(FileExecuteService fileExecuteServiceMock) {
		this.fileExecuteService = fileExecuteServiceMock;
		
	}

}
