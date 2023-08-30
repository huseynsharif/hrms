package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.entities.dtos.EmployerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Employer;

@RestController
@RequestMapping("/api/employers")
@CrossOrigin
public class EmployerController {
	
	private EmployerService employerService;
	
	@Autowired
	public EmployerController(EmployerService employerService) {
		this.employerService = employerService;
	}
	
	
	@GetMapping("/getall")
	public Result getAll() {
		return this.employerService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody EmployerDto employerDto) {
		return this.employerService.add(employerDto);
	}
	
}
