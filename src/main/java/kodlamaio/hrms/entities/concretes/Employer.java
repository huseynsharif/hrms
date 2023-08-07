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
public class Employer{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int employer_id;
	
	@Column(name="company_name")
	private String companyName;

	private String website;
	
	@Column(name="phone_number")
	private String phoneNumber;

	@OneToOne()
	@JoinColumn(name = "id")
	private BaseUser baseUser;

}
