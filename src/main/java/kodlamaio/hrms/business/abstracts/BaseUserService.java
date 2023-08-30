package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.BaseUser;

public interface BaseUserService {

    DataResult<BaseUser> findByEmail(String email, String password);

}
