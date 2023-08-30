package kodlamaio.hrms.dataAccess.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface JobAdvertisementDAO extends JpaRepository<JobAdvertisement, Integer> {

    @Query(value = "FROM JobAdvertisement where isActive=true")
    List<JobAdvertisement> getAllActive();

    @Query(value = "FROM JobAdvertisement where isActive=true and employerId=:employerId")
    List<JobAdvertisement> getAllActiveWithEmployerId(int employerId);

    @Query(value = "FROM JobAdvertisement where isActive=true order by postingDate desc")
    List<JobAdvertisement> getAllActiveOrderByDateASC();
}
