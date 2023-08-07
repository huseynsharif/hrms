package kodlamaio.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.Register;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.entities.concretes.Employee;

@Service
public class EmployeeRegister implements Register{
	
	@Autowired
	EmailValidation emailValidation;
	@Autowired
	PasswordValidation passwordValidation;
	public Result newEmployee(Employee employee) {
		
		if(employee.getName() == null) {
			return new ErrorResult("Ad bos qala bilmez.");
		}
		
		
		if(employee.getSurname() == null) {
			return new ErrorResult("Soyad bos ola bilmez");
		}
		
		if(employee.getIdentityNumber() == null) {
			return new ErrorResult("Tcno boş ola bilməz");
		}
		
//		if(employee.getBirthyear() == null) {
//			return new ErrorResult("Dogum tarixi bos ola bilmez");
//		}
		
		if(!emailValidation.emailValidatorForEmployee(employee.getBaseUser().getEmail())) {
			return new ErrorResult("Email dogru deyil.");
		}
		
		if(passwordValidation.PasswordValidator(employee.getBaseUser().getPassword())) {
//			if(!employee.getPassword1().equals(employee.getPassword2())) {
//				return new ErrorResult("Sifreler uygun deyil.");
//			}
		}
		else {
			return new ErrorResult("Sifre 1-8 araliginda olmalidir.");
		}
		
		return new SuccessDataResult<Employee>(employee);
	}
	
}
