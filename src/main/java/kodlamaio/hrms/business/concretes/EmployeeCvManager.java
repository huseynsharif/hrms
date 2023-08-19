package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.EmployeeCvService;
import kodlamaio.hrms.core.utilities.results.*;
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

        EmployeeCv employeeCv = this.employeeCvDAO.findEmployeeCvById(id);

        if (employeeCv == null){
            return new ErrorDataResult<>("Finded by id");
        }

        return new SuccessDataResult<>(employeeCv, "Finded by id");
    }

    @Override
    public DataResult<List<EmployeeCv>> findEmployeeCvByEducation_EndingYearisNull() {
        return new SuccessDataResult<>(this.employeeCvDAO.findEmployeeCvByEducation_EndingYearisNull(), "Nulls listed");
    }

    @Override
    public DataResult<List<EmployeeCv>> findEmployeeCvOrderByEducation_EndingYearDesc() {

        List<EmployeeCv> orderedcvs = this.employeeCvDAO.findEmployeeCvByEducation_EndingYearisNull();
        orderedcvs.addAll(this.employeeCvDAO.findEmployeeCvOrderByEducation_EndingYearDesc());
        return new SuccessDataResult<>(orderedcvs, "Ordered by education ending year desc.");
    }

    @Override
    public DataResult<List<EmployeeCv>> findEmployeeCvByExperience_EndingDateisNull() {
        return new SuccessDataResult<>(this.employeeCvDAO.findEmployeeCvByExperience_EndingDateisNull(), "Nulls listed");
    }

    @Override
    public DataResult<List<EmployeeCv>> findEmployeeCvOrderByExperience_EndingDateDesc() {
        List<EmployeeCv> orderedcvs = this.employeeCvDAO.findEmployeeCvByExperience_EndingDateisNull();
        orderedcvs.addAll(this.employeeCvDAO.findEmployeeCvOrderByExperience_EndingDateDesc());
        return new SuccessDataResult<>(orderedcvs, "Ordered by experience ending date desc.");
    }
}
