package mas.mp5.rm.mas_mp5_s22284.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "person")
@ToString
@SuperBuilder
public abstract class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "FullName is mandatory")
    @Size(min = 5, max = 255)
    private String fullName;

    @NotBlank(message = "Email is mandatory")
    @Size(min = 5, max = 255)
    private String email;

    @NotBlank(message = "Phone is mandatory")
    @Size(min = 5, max = 255)
    private String phone;

}
