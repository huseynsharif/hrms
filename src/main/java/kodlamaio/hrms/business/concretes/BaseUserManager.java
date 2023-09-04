package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.BaseUserService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.dataAccess.abstracts.BaseUserDAO;
import kodlamaio.hrms.entities.concretes.BaseUser;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@AllArgsConstructor
public class BaseUserManager implements BaseUserService {

    private BaseUserDAO baseUserDAO;

    @Override
    public DataResult<BaseUser> findByEmail(String email, String password) {

        BaseUser baseUser = this.baseUserDAO.findBaseUserByEmail(email);

        if(baseUser==null){
            return new ErrorDataResult<>("Cannot find user by given email.");
        }
        else if(!baseUser.getPassword().equals(password)){
            return new ErrorDataResult<>("Email or password is incorrect.");
        }
        else{
            return new SuccessDataResult<>(baseUser, "Finded successfully.");
        }

    }
}
