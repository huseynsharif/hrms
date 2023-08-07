package kodlamaio.hrms.business.concretes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;
@Service
public class PasswordValidation {
	private String regexpassword = ".{8,}";
	
	public boolean PasswordValidator(String password) {
		Pattern patternM = Pattern.compile(regexpassword);
		Matcher matcherM = patternM.matcher(password);
		
		if(matcherM.matches()) {
			return true;
		}
		else{
			return false;
		}
	}
	
}
