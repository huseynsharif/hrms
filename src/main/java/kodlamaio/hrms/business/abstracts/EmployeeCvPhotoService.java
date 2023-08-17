package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.Result;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface EmployeeCvPhotoService {

    Result add(MultipartFile photophoto, int employeeCvId) throws IOException;

}
