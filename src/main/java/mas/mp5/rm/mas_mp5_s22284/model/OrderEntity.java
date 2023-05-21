package mas.mp5.rm.mas_mp5_s22284.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.*;
import mas.mp5.rm.mas_mp5_s22284.validation.ValidArrivalDeparture;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ValidArrivalDeparture
@Table(name = "orders")
@ToString
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Destination is mandatory")
    @Size(min = 5, max = 255)
    private String destination;

    // Covered by ConstraintValidator or not
    @PastOrPresent
    private LocalDate arrivalDate;

    @PastOrPresent
    private LocalDate departureDate;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

}
