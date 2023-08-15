package kodlamaio.hrms.dataAccess.abstracts;


import kodlamaio.hrms.entities.concretes.Language;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LanguageDAO extends JpaRepository<Language, Integer> {

    Language findLanguageById(int id);

}
