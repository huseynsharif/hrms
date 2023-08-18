package kodlamaio.hrms.dataAccess.abstracts;

import kodlamaio.hrms.entities.concretes.EmployeeCv;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeCvDAO extends JpaRepository<EmployeeCv, Integer> {

    EmployeeCv findEmployeeCvById(int id);

    @Query("FROM EmployeeCv where education.endingYear=0")
    List<EmployeeCv> findEmployeeCvByEducation_EndingYearisNull();

    @Query("FROM EmployeeCv where education.endingYear != 0 ORDER BY education.endingYear desc ")
    List<EmployeeCv> findEmployeeCvOrderByEducation_EndingYearDesc();

    @Query("FROM EmployeeCv where experience.endingDate=0")
    List<EmployeeCv> findEmployeeCvByExperience_EndingDateisNull();

    @Query("SELECT e FROM EmployeeCv e where e.experience.endingDate != NULL ORDER BY e.experience.endingDate desc ")
    List<EmployeeCv> findEmployeeCvOrderByExperience_EndingDateDesc();

}
