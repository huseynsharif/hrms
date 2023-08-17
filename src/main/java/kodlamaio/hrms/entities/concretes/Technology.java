package kodlamaio.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "technologies")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","employeeCvs"})
public class Technology {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "technology_name")
    private String technologyName;

    @OneToMany(mappedBy = "technology", fetch = FetchType.LAZY)
    private List<EmployeeCv> employeeCvs;
}
