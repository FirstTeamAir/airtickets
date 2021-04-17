package ru.vsu.service.service.validation.validator;

import ru.vsu.service.service.validation.annotation.AfterNow;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;

/**
 * Class for checking if specified date is today or after current date.
 *
 * @author Kolesnikov Vladislav
 */
public class LocalDateAfterNowValidator implements ConstraintValidator<AfterNow, LocalDate> {

    @Override
    public boolean isValid(LocalDate value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }
        final var nowDate = LocalDate.now(context.getClockProvider().getClock());
        return !value.isBefore(nowDate);
    }
}
