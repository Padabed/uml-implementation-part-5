package mas.mp5.rm.mas_mp5_s22284.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "worker")
@ToString
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public abstract class Worker extends Person {

    @Min(500)
    private double salary;

}
