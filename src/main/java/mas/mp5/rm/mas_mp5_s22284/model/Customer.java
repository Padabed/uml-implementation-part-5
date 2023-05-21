package mas.mp5.rm.mas_mp5_s22284.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "customer")
@ToString
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class Customer extends Person {

    @NotBlank(message = "Address is mandatory")
    @Size(min = 5, max = 255)
    private String address;

}
