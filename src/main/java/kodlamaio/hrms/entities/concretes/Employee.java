package kodlamaio.hrms.entities.concretes;

import javax.persistence.*;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="employees")
public class Employee extends BaseUser{

	private String name;

	private String surname;
	
	@Column(name="identity_number")
	private String identityNumber;

	@Column(name = "birth_year")
	private int birthyear;

}
