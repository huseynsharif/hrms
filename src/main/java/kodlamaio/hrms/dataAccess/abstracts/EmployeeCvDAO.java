package kodlamaio.hrms.dataAccess.abstracts;

import kodlamaio.hrms.entities.concretes.EmployeeCv;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeCvDAO extends JpaRepository<EmployeeCv, Integer> {

    EmployeeCv findEmployeeCvById(int id);

}
