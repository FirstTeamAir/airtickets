package ru.vsu.service.service.validation.validator;

import ru.vsu.service.model.base.AbstractTicketDto;
import ru.vsu.service.service.validation.annotation.DateFrame;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.Instant;

/**
 * Validation annotation for checking
 * in {@link AbstractTicketDto}.
 *
 * @author Kolesnikov Vladislav
 */
public class TicketDatetimeFrameValidator implements
        ConstraintValidator<DateFrame, AbstractTicketDto> {
    @Override
    public boolean isValid(AbstractTicketDto value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }
        final Instant minDateValue = value.getDepartureDatetime();
        final Instant maxDateValue = value.getArrivalDatetime();
        if (maxDateValue == null || minDateValue == null) {
            return true;
        }
        return maxDateValue.isAfter(minDateValue);
    }
}
