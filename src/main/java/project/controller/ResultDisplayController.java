package project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import project.model.FileResultRow;
import project.service.ResultDisplayService;

@RestController
@RequestMapping("/results")
public class ResultDisplayController {
	
	@Autowired
	ResultDisplayService resultDisplayService;
	
	@GetMapping(value="/getRecords",produces="application/json")
	public List<FileResultRow> getAllRecords() {
		return resultDisplayService.getAllRecords();
	}
	
	@GetMapping(value="/{Id}/get",produces="application/json")
	public List<FileResultRow> getByID(@PathVariable(value="Id") int id) {
		return resultDisplayService.getByID(id);
	}
	
	
	
	
	@GetMapping("/gets")
	public String gets()
	{
		return "Hello";
	}

}
