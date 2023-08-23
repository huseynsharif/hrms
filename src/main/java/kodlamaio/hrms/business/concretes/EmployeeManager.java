package kodlamaio.hrms.business.concretes;

import java.util.List;

import kodlamaio.hrms.core.adapters.mappers.ModelMapperService;
import kodlamaio.hrms.core.utilities.results.*;
import kodlamaio.hrms.entities.dtos.EmployeeDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployeeService;
import kodlamaio.hrms.dataAccess.abstracts.EmployeeDAO;
import kodlamaio.hrms.entities.concretes.Employee;

@Service
@AllArgsConstructor
public class EmployeeManager implements EmployeeService{

	private final EmployeeDAO employeeDAO;
	private final ModelMapperService modelMapperService;
	
	@Override
	public DataResult<List<Employee>> getAll() {
		
		return new SuccessDataResult<List<Employee>>
		(this.employeeDAO.findAll(), "Is axtaranlar siralandi");
	}


	@Override
	public Result add(EmployeeDto employeeDto) {
		if(!employeeDto.getPassword().equals(employeeDto.getCPassword())){
			return new ErrorResult("Passwords must be same.");
		}
		Employee employee = modelMapperService.getModelMapper().map(employeeDto, Employee.class);

		this.employeeDAO.save(employee);
		return new SuccessResult("Istifadeci elave olundu");

	}



}
