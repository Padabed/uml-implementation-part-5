package mas.mp5.rm.mas_mp5_s22284.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ArrivalDepartureValidator.class)
@Documented
public @interface ValidArrivalDeparture {

    String message() default "Departure date/time must be after the arrival date/time";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
