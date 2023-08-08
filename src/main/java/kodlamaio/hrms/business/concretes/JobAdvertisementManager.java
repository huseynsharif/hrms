package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CityDAO;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDAO;
import kodlamaio.hrms.dataAccess.abstracts.JobAdvertisementDAO;
import kodlamaio.hrms.dataAccess.abstracts.JobDAO;
import kodlamaio.hrms.entities.concretes.City;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.concretes.Job;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobAdvertisementManager implements JobAdvertisementService {

    private final JobAdvertisementDAO jobAdvertisementDAO;
    private final CityDAO cityDAO;
    private final EmployerDAO employerDAO;
    private final JobDAO jobDAO;


    @Autowired
    public JobAdvertisementManager(JobAdvertisementDAO jobAdvertisementDAO, CityDAO cityDAO, EmployerDAO employerDAO, JobDAO jobDAO) {
        this.jobAdvertisementDAO = jobAdvertisementDAO;
        this.cityDAO = cityDAO;
        this.employerDAO = employerDAO;
        this.jobDAO = jobDAO;
    }

    @Override
    public DataResult<List<JobAdvertisement>> getAll() {
        return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDAO.findAll(), "Is elanlari listelendi.");
    }

    @Override
    public DataResult<JobAdvertisement> add(JobAdvertisement jobAdvertisement) {

//        City tempCity = cityDAO.getById(jobAdvertisement.getCity().getId());
//
//        Employer tempEmployer = employerDAO.getById(jobAdvertisement.getEmployer().getId());
//
//        Job tempJob = jobDAO.getById(jobAdvertisement.getJob().getId());
//
//        jobAdvertisement.setCity(tempCity);
//        jobAdvertisement.setEmployer(tempEmployer);
//        jobAdvertisement.setJob(tempJob);

        return new SuccessDataResult<>(this.jobAdvertisementDAO.save(jobAdvertisement), "Yaradildi");
    }
}
