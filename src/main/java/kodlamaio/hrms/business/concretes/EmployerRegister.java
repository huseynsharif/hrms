package kodlamaio.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.Register;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.entities.concretes.Employer;

@Service
public class EmployerRegister implements Register{
	
	
	private EmailValidation emailValidation;
	private PasswordValidation passwordValidation;
	
	@Autowired
	public EmployerRegister(EmailValidation emailValidation, PasswordValidation passwordValidation) {
		this.emailValidation = emailValidation;
		this.passwordValidation = passwordValidation;
	}

	public Result newEmployer(Employer employer) {
		if(employer.getCompanyName() == null) {
			return new ErrorResult("Ad bos qala bilmez.");
		}
		
		if(employer.getWebsite() == null) {
			return new ErrorResult("Sayt boş ola bilməz");
		}
		
		
		if(!emailValidation.emailValidatorForEmployee(employer.getEmail())) {
			return new ErrorResult("Email dogru deyil.");
		}
		
		if(employer.getPhoneNumber() == null) {
			return new ErrorResult("Telefon bos ola bilmez");
		}
		
		
		if(passwordValidation.PasswordValidator(employer.getPassword())) {
//			if(!employer.getPassword1().equals(employer.getPassword2())) {
//				return new ErrorResult("Sifreler uygun deyil.");
//			}
		}
		else {
			return new ErrorResult("Sifre 1-8 araliginda olmalidir.");
		}
		
		return new SuccessDataResult<Employer>(employer);
	}
}