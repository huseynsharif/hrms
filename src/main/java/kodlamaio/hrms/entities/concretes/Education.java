package kodlamaio.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "educations")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","employeeCv"})
public class Education {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

//    @ManyToOne(fetch = FetchType.LAZY)
    @Column(name = "university_id")
    private int universityId;

    @NotBlank
    @NotNull
    @Column(name = "starting_year", nullable = false)
    private int startingYear;

    @Column(name = "ending_year")
    private int endingYear;

//    @ManyToOne(fetch = FetchType.LAZY)
    @Column(name = "department_id")
    private int departmentId;

}
