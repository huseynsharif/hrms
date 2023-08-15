package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDAO;
import kodlamaio.hrms.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService{

	private EmployerDAO employerDAO;
	
	@Autowired
	public EmployerManager(EmployerDAO employerDAO) {
		this.employerDAO = employerDAO;
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		
		return new SuccessDataResult<List<Employer>>
		(this.employerDAO.findAll(), "Is Verenler siralandi");
	}


	@Override
	public Result add(Employer employer) {

		this.employerDAO.save(employer);
		return new SuccessResult("Is veren elave olundu");

	}
}