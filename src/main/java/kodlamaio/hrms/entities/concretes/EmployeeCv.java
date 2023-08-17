package kodlamaio.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "employee_cvs")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","language"})
public class EmployeeCv {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "education_id", referencedColumnName = "id")
    private Education education;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "experience_id", referencedColumnName = "id")
    private Experience experience;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "language_id", referencedColumnName = "id")
    private Language language;

    @Column(name = "language_level", nullable = false)
    private int languageLevel;

    @Column( name = "description", nullable = false, length = 500)
    private String description;

    @Column( name = "github_url", nullable = false, length = 500)
    private String githubUrl;

    @Column( name = "linkedin_url", nullable = false, length = 500)
    private String linkedinUrl;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "programming_language_id", referencedColumnName = "id")
    private ProgrammingLanguage programmingLanguage;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "photo_id", referencedColumnName = "id")
    private EmployeeCvPhoto employeeCvPhoto;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "technology_id", referencedColumnName = "id")
    private Technology technology;


}
