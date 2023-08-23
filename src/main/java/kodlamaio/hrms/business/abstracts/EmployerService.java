package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.entities.dtos.EmployerDto;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Employer;

@Service
public interface EmployerService {
	DataResult<List<Employer>> getAll();
	Result add(EmployerDto employerDto);
}

