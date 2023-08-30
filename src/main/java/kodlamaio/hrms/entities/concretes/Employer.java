package kodlamaio.hrms.entities.concretes;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="employers")
public class Employer extends BaseUser{
	
	@Column(name="company_name")
	private String companyName;

	private String website;
	
	@Column(name="phone_number")
	private String phoneNumber;

}
