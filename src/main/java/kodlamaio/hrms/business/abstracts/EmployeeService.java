package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.entities.dtos.EmployeeDto;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Employee;
import kodlamaio.hrms.entities.concretes.Employer;

@Service
public interface EmployeeService {
	DataResult<List<Employee>> getAll();
	Result add(EmployeeDto employeeDto);
}
