package kodlamaio.hrms.api.controllers;

import java.util.List;

import kodlamaio.hrms.entities.dtos.EmployeeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import kodlamaio.hrms.business.abstracts.EmployeeService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Employee;

@RestController
@RequestMapping("/api/employees")
@CrossOrigin
public class EmployeeController {
	
	private EmployeeService employeeService;
	
	@Autowired
	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@GetMapping("/getall")
	public DataResult<List<Employee>> getAll(){
		
		return this.employeeService.getAll();
		
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody EmployeeDto employeeDto) {

		return this.employeeService.add(employeeDto);
	}
	
	
}