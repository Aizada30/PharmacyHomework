package global.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

import static jakarta.persistence.CascadeType.DETACH;
import static jakarta.persistence.CascadeType.MERGE;
import static jakarta.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name = "pharmacies")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Pharmacy {
    @Id
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "pharmacy_gen")
    @SequenceGenerator(
            name = "pharmacy_gen",
            sequenceName = "pharmacy_seq",
            allocationSize = 1)
    private Long id;
    private String name;
    private String address;
    @OneToMany(mappedBy = "pharmacy",
            cascade = {DETACH, MERGE})
    private List<Worker> workers;
    @ManyToMany(mappedBy = "pharmacies",
            cascade = {MERGE, DETACH})
    private List<Medicine> medicineList;

}
