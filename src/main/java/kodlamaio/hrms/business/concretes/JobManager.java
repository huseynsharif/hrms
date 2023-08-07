package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.JobService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobDAO;
import kodlamaio.hrms.entities.concretes.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobManager implements JobService {

    private JobDAO jobDAO;

    @Autowired
    public JobManager(JobDAO jobDAO) {
        this.jobDAO = jobDAO;
    }

    @Override
    public DataResult<List<Job>> getAll() {
        return new SuccessDataResult<List<Job>>(this.jobDAO.findAll(), "Ishler listelendi.") ;
    }

    @Override
    public Result add(Job job) {
        this.jobDAO.save(job);
        return new SuccessResult("Data yadda saxlanildi.");
    }
}
