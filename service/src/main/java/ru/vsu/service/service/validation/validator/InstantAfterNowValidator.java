package ru.vsu.service.service.validation.validator;

import ru.vsu.service.service.validation.annotation.AfterNow;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.Instant;

/**
 * Class for checking if specified datetime is or after current datetime.
 *
 * @author Kolesnikov Vladislav
 */
public class InstantAfterNowValidator implements ConstraintValidator<AfterNow, Instant> {

    @Override
    public boolean isValid(Instant value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }
        final var nowDate = Instant.now(context.getClockProvider().getClock());
        return !value.isBefore(nowDate);
    }
}
