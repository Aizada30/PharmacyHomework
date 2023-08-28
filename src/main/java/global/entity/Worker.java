package global.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.*;

import java.time.LocalDate;

import static jakarta.persistence.CascadeType.*;
import static jakarta.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name = "workers")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder

public class Worker {
    @Id
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "worker_gen")
    @SequenceGenerator(
            name = "worker_gen",
            sequenceName = "worker_seq",
            allocationSize = 1)
    private Long id;
    @Column(name = "full_name")
    private String fullName;
    @Column(unique = true)
    @Pattern(regexp = ".+@gmail\\.com",message = "Email must end with '@gmail.com'")
    private String email;
    @Column(nullable = false)

    private int salary;
    private String address;
    private LocalDate dateOfBirth;
    @ManyToOne(cascade = {PERSIST, MERGE, DETACH, REFRESH})
    @JsonIgnore
    private Pharmacy pharmacy;

}
