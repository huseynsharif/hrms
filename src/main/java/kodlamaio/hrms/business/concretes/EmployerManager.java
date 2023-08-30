package kodlamaio.hrms.business.concretes;

import java.util.List;

import kodlamaio.hrms.core.adapters.mappers.ModelMapperService;
import kodlamaio.hrms.entities.dtos.EmployerDto;
import lombok.AllArgsConstructor;
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
@AllArgsConstructor
public class EmployerManager implements EmployerService{

	private EmployerDAO employerDAO;
	private ModelMapperService modelMapperService;


	@Override
	public DataResult<List<Employer>> getAll() {
		
		return new SuccessDataResult<List<Employer>>
		(this.employerDAO.findAll(), "Is Verenler siralandi");
	}


	@Override
	public Result add(EmployerDto employerDto) {

		if (!employerDto.getPassword().equals(employerDto.getCPassword())){
			return new ErrorResult("Passwords must be same.");
		}

		Employer employer = modelMapperService.getModelMapper().map(employerDto, Employer.class);

		this.employerDAO.save(employer);
		return new SuccessResult("Is veren elave olundu");

	}
}