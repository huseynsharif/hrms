package kodlamaio.hrms.dataAccess.abstracts;

import kodlamaio.hrms.entities.concretes.BaseUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BaseUserDAO extends JpaRepository<BaseUser, Integer> {

    BaseUser findBaseUserByEmail(String email);

}
