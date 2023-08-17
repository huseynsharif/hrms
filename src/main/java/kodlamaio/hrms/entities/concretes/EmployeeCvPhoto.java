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
@Table(name = "employee_cv_photos")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","employeeCv"})
public class EmployeeCvPhoto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "photo_url", nullable = false, length = 500)
    private String photoUrl;

    @OneToOne(mappedBy = "employeeCvPhoto", fetch = FetchType.LAZY)
    private EmployeeCv employeeCv;

}
