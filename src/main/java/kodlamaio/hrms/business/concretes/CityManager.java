package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.CityService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CityDAO;
import kodlamaio.hrms.entities.concretes.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityManager implements CityService {

    private CityDAO cityDAO;

    @Autowired
    public CityManager(CityDAO cityDAO) {
        this.cityDAO = cityDAO;
    }

    @Override
    public DataResult<List<City>> getAll() {
        return new SuccessDataResult<List<City>>(this.cityDAO.findAll(), "Data listelendi.");
    }

    @Override
    public DataResult<City> getById(int id) {
        return new SuccessDataResult<City>(this.cityDAO.getById(id), "Id-e gore getirildi.");
    }

    @Override
    public Result add(City city) {

        this.cityDAO.save(city);

        return new SuccessResult("Sheher yadda saxlanildi.");
    }
}
