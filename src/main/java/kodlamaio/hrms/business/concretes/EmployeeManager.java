package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployeeService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployeeDAO;
import kodlamaio.hrms.entities.concretes.Employee;

@Service
public class EmployeeManager implements EmployeeService{

	private EmployeeDAO employeeDAO;
	
	@Autowired
	public EmployeeManager(EmployeeDAO employeeDAO) {
		super();
		this.employeeDAO = employeeDAO;
	}

	
	@Override
	public DataResult<List<Employee>> getAll() {
		
		return new SuccessDataResult<List<Employee>>
		(this.employeeDAO.findAll(), "Is axtaranlar siralandi");
	}


	@Override
	public Result add(Employee employee) {

		this.employeeDAO.save(employee);
		return new SuccessResult("Istifadeci elave olundu");

	}



}
