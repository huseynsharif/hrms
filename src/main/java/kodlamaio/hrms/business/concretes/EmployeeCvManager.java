package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.EmployeeCvService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EducationDAO;
import kodlamaio.hrms.dataAccess.abstracts.EmployeeCvDAO;
import kodlamaio.hrms.dataAccess.abstracts.ExperienceDAO;
import kodlamaio.hrms.entities.concretes.Education;
import kodlamaio.hrms.entities.concretes.EmployeeCv;
import kodlamaio.hrms.entities.concretes.Experience;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeCvManager implements EmployeeCvService {

    private EmployeeCvDAO employeeCvDAO;
    private EducationDAO educationDAO;
    private ExperienceDAO experienceDAO;

    @Autowired
    public EmployeeCvManager(EmployeeCvDAO employeeCvDAO, EducationDAO educationDAO, ExperienceDAO experienceDAO) {
        this.employeeCvDAO = employeeCvDAO;
        this.educationDAO = educationDAO;
        this.experienceDAO = experienceDAO;
    }

    @Override
    public Result add(EmployeeCv employeeCv) {

        Education education = employeeCv.getEducation();
        Experience experience = employeeCv.getExperience();
        this.educationDAO.save(education);
        this.experienceDAO.save(experience);
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
