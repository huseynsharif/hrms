package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface JobAdvertisementService {

    DataResult<List<JobAdvertisement>> getAll();

    Result add(JobAdvertisement jobAdvertisement);

}
