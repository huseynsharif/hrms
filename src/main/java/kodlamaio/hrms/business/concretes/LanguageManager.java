package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.LanguageService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.dataAccess.abstracts.LanguageDAO;
import kodlamaio.hrms.entities.concretes.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LanguageManager implements LanguageService {

    private LanguageDAO languageDAO;

    @Autowired
    public LanguageManager(LanguageDAO languageDAO) {
        this.languageDAO = languageDAO;
    }

    @Override
    public DataResult<List<Language>> getAll() {
        return new SuccessDataResult<List<Language>>(this.languageDAO.findAll(), "Languages listed.");
    }

    @Override
    public DataResult<Language> findLanguageById(int id) {

        Language language = this.languageDAO.findLanguageById(id);

        if(language == null){
            return new ErrorDataResult<Language>("Language not found with given id.");
        }
        else{
            return new SuccessDataResult<Language>(language , "Finded language by id.");
        }


    }
}
