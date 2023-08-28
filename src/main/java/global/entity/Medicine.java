package global.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;
import org.hibernate.annotations.AnyDiscriminator;

import java.math.BigDecimal;
import java.util.List;

import static jakarta.persistence.CascadeType.DETACH;
import static jakarta.persistence.CascadeType.MERGE;

@Entity
@Table(name = "medicines")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Medicine {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "medicine_gen")
    @SequenceGenerator(name = "medicine_gen",
            sequenceName = "medicine_seq",
            allocationSize = 1)
    private Long id;
    private String name;
    @NotNull
    @Min(value =0,message = "Price of medicine can not be negative")
    private BigDecimal price;
    @ManyToMany(cascade = {DETACH, MERGE})
    private List<Pharmacy> pharmacies;


}
