package kodlamaio.hrms.business.abstracts;


import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.EmployeeCvPhoto;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface EmployeeCvPhotoService {

    DataResult<EmployeeCvPhoto> add(MultipartFile photophoto) throws IOException;
    DataResult<EmployeeCvPhoto> findEmployeeCvPhotoById(int id);

    DataResult<List<EmployeeCvPhoto>> getAll();


}
