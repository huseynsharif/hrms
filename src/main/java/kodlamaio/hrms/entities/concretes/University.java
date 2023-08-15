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
@Table(name = "universities")
public class University {

    @Id
    @Column(name = "university_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @NotBlank
    @Column(name = "university_name")
    private String name;

}
