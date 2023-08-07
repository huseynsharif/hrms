package kodlamaio.hrms.business.concretes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.Validators;
@Service
public class EmailValidation implements Validators{
	
	private String regexMail;
	
	public boolean emailValidatorForEmployee(String email) {
		regexMail = "^[a-zA-Z0-9.!#$%&{|}]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$";
		Pattern patternM = Pattern.compile(regexMail);
		Matcher matcherM = patternM.matcher(email);
		
		if(matcherM.matches()) {
			return true;
		}
		else{
			return false;
		}
		
	}
	public boolean emailValidatorForEmployer(String email, String website) {
		regexMail = "^[a-zA-Z0-9.!#$%&{|}]+@" + website;
		Pattern patternM = Pattern.compile(regexMail);
		Matcher matcherM = patternM.matcher(email);
		
		if(matcherM.matches()) {
			return true;
		}
		else{
			return false;
		}
	
}

}