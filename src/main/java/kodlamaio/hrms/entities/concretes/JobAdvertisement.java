package kodlamaio.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "job_advertisements")
public class JobAdvertisement {

    @Id
    @Column(name = "advertisement_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String description;

    @Column(name = "open_positions")
    private int openPositions;

    @ManyToOne()
    @JoinColumn(name = "employer_id", referencedColumnName = "id")
    private Employer employer;

    @ManyToOne()
    @JoinColumn(name = "job_id", referencedColumnName = "id")
    private Job job;

    @ManyToOne()
    @JoinColumn(name = "city_id")
    private City city;

//    @Column(name = "employer_id")
//    private int employerId;
//
//    @Column(name = "city_id")
//    private int cityId;
//
//    @Column(name = "job_id")
//    private int jobId;

    private LocalDate deadline;

    @Column(name = "is_active")
    private boolean isActive;

    @Column(name = "posting_date")
    private Date postingDate;



}
