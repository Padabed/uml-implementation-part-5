package mas.mp5.rm.mas_mp5_s22284.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.*;
import mas.mp5.rm.mas_mp5_s22284.validation.ValidArrivalDeparture;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ValidArrivalDeparture
@Table(name = "delivery")
@ToString
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    // Covered by ConstraintValidator or not
    @PastOrPresent
    @NotNull
    private LocalDate departureDate;

    @PastOrPresent
    private LocalDate arrivalDate;

    @OneToOne(optional = false)
    @JoinColumn(name = "order_id", nullable = false, updatable = false)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private OrderEntity isIn;

    @ManyToOne
    @JoinColumn(name = "vehicle_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Vehicle deliverBy;
}
