package kodlamaio.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "employee_cvs")
public class EmployeeCv {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    @JoinColumn(name = "education_id", referencedColumnName = "id")
    private Education education;

    @OneToOne()
    @JoinColumn(name = "experience_id", referencedColumnName = "id")
    private Experience experience;

    @ManyToOne()
    @JoinColumn(name = "language_id", referencedColumnName = "id")
    private Language language;

    @Column(name = "language_degree", nullable = false)
    private int languageDegree;

    @Column( name = "description", nullable = false, length = 500)
    private String description;

    @Column( name = "github_url", nullable = false, length = 500)
    private String githubUrl;

    @Column( name = "linkedin_url", nullable = false, length = 500)
    private String linkedinUrl;

    @ManyToOne()
    @JoinColumn(name = "programming_language_id", referencedColumnName = "id")
    private ProgrammingLanguage programmingLanguage;

}
