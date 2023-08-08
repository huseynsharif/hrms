package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.City;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CityService {

    DataResult<List<City>> getAll();

    DataResult<City> getById(int id);

    Result add(City city);


}
