package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.EmployeeCv;

import java.util.List;


public interface EmployeeCvService {

    Result add(EmployeeCv employeeCv);

    DataResult<List<EmployeeCv>> getall();

    DataResult<EmployeeCv> findById(int id);

}
