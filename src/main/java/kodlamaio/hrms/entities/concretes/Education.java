package kodlamaio.hrms.entities.concretes;

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
public class Education {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "university_id")
    private University university;

    @NotBlank
    @NotNull
    @Column(name = "starting_year", nullable = false)
    private int startingYear;

    @Column(name = "ending_year")
    private int endingYear;

    @OneToOne(mappedBy = "education")
    private EmployeeCv employeeCv;

}
