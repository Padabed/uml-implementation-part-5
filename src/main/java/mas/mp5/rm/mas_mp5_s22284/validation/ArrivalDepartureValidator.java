package mas.mp5.rm.mas_mp5_s22284.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import mas.mp5.rm.mas_mp5_s22284.model.Delivery;

import java.time.LocalDate;

public class ArrivalDepartureValidator implements ConstraintValidator<ValidArrivalDeparture, Delivery> {

    @Override
    public void initialize(ValidArrivalDeparture constraintAnnotation) {

    }

    @Override
    public boolean isValid(Delivery delivery, ConstraintValidatorContext context) {
        LocalDate arrivalDate = delivery.getArrivalDate();
        LocalDate departureDate = delivery.getDepartureDate();

        if (arrivalDate == null || departureDate == null) {
            // If either arrivalDate or departureDate is null, assume it's valid
            return true;
        }

        return !departureDate.isBefore(arrivalDate);
    }

}
