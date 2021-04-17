package ru.vsu.service.service.validation.annotation;

import ru.vsu.service.service.validation.code.ConstraintCode;
import ru.vsu.service.service.validation.validator.InstantAfterNowValidator;
import ru.vsu.service.service.validation.validator.LocalDateAfterNowValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Validation annotation for checking if
 * specified date is after current date.
 *
 * @author Kolesnikov Vladislav
 */
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {LocalDateAfterNowValidator.class, InstantAfterNowValidator.class})
@Target({ElementType.FIELD, ElementType.PARAMETER})
public @interface AfterNow {

    /**
     * Message to present if validation fails.
     */
    String message() default ConstraintCode.AFTER_NOW;

    /**
     * Action groups before which validation needs to be performed.
     */
    Class<?>[] groups() default {};

    /**
     * Meta information used in validation.
     */
    Class<? extends Payload>[] payload() default {};
}
