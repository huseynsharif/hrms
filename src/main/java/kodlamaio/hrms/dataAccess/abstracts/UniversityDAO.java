package kodlamaio.hrms.dataAccess.abstracts;


import kodlamaio.hrms.entities.concretes.University;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UniversityDAO extends JpaRepository<University, Integer> {

    University findUniversityById(int id);

}
