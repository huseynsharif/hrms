package kodlamaio.hrms.dataAccess.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.EmployeeCvPhoto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeCvPhotoDAO extends JpaRepository<EmployeeCvPhoto, Integer> {

    EmployeeCvPhoto findEmployeeCvPhotoById(int id);

}
