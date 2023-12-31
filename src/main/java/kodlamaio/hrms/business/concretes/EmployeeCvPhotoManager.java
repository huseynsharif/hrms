package kodlamaio.hrms.business.concretes;

import com.cloudinary.utils.ObjectUtils;
import kodlamaio.hrms.business.abstracts.EmployeeCvPhotoService;
import kodlamaio.hrms.core.cloudinary.CloudinaryConfig;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployeeCvDAO;
import kodlamaio.hrms.dataAccess.abstracts.EmployeeCvPhotoDAO;
import kodlamaio.hrms.entities.concretes.EmployeeCvPhoto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Service
public class EmployeeCvPhotoManager implements EmployeeCvPhotoService {

    private final EmployeeCvPhotoDAO employeeCvPhotoDAO;
    private EmployeeCvDAO employeeCvDAO;
    private CloudinaryConfig cloudinaryConfig;

    @Autowired
    public EmployeeCvPhotoManager(EmployeeCvPhotoDAO employeeCvPhotoDAO, EmployeeCvDAO employeeCvDAO, CloudinaryConfig cloudinaryConfig) {
        this.employeeCvPhotoDAO = employeeCvPhotoDAO;
        this.employeeCvDAO = employeeCvDAO;
        this.cloudinaryConfig = cloudinaryConfig;
    }

    @Override
    public DataResult<EmployeeCvPhoto> add(MultipartFile photo) throws IOException {

        Map uploadResult = cloudinaryConfig
                .cloudinary()
                .uploader()
                .upload(photo.getBytes(), ObjectUtils.emptyMap());

        EmployeeCvPhoto employeeCvPhoto = new EmployeeCvPhoto();
        employeeCvPhoto.setPhotoUrl((String) uploadResult.get("url"));
//        EmployeeCv employeeCv = employeeCvDAO.findEmployeeCvById(employeeCvId);
//        employeeCvPhoto.setEmployeeCv(employeeCv);
        employeeCvPhotoDAO.save(employeeCvPhoto);
        return new SuccessDataResult<>(employeeCvPhoto, "Photo successfully added");
    }

    @Override
    public DataResult<EmployeeCvPhoto> findEmployeeCvPhotoById(int id) {
        return new SuccessDataResult<>(this.employeeCvPhotoDAO.findById(id).orElseThrow());
    }

    @Override
    public DataResult<List<EmployeeCvPhoto>> getAll() {
        return new SuccessDataResult<>(this.employeeCvPhotoDAO.findAll());
    }
}
