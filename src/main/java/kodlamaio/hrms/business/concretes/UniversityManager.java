package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.UniversityService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.dataAccess.abstracts.UniversityDAO;
import kodlamaio.hrms.entities.concretes.University;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UniversityManager implements UniversityService {

    private UniversityDAO universityDAO;

    @Autowired
    public UniversityManager(UniversityDAO universityDAO) {
        this.universityDAO = universityDAO;
    }

    @Override
    public DataResult<List<University>> getAll() {
        return new SuccessDataResult<List<University>>(this.universityDAO.findAll(), "Schools listed successfully.");
    }


    @Override
    public DataResult<University> getById(int id) {
        return new SuccessDataResult<University>(this.universityDAO.findUniversityById(id), "Finded by id successfully.");
    }
}
