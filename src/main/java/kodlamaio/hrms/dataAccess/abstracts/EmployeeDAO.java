package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.Employee;

public interface EmployeeDAO extends JpaRepository<Employee, Integer>{
	
}
