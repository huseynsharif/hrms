package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.EmployeeCvService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployeeCvDAO;
import kodlamaio.hrms.entities.concretes.EmployeeCv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeCvManager implements EmployeeCvService {

    private EmployeeCvDAO employeeCvDAO;

    @Autowired
    public EmployeeCvManager(EmployeeCvDAO employeeCvDAO) {
        this.employeeCvDAO = employeeCvDAO;
    }

    @Override
    public Result add(EmployeeCv employeeCv) {
        this.employeeCvDAO.save(employeeCv);
        return new SuccessResult("EmployeeCv was successfully saved.");
    }

    @Override
    public DataResult<List<EmployeeCv>> getall() {
        return new SuccessDataResult<List<EmployeeCv>>(this.employeeCvDAO.findAll(), "Datas were successfully listed.");
    }

    @Override
    public DataResult<EmployeeCv> findById(int id) {
        return new SuccessDataResult<>(this.employeeCvDAO.findEmployeeCvById(id), "Finded by id");
    }
}
