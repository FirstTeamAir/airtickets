package ru.vsu.service.service.validation.annotation;

import ru.vsu.service.service.validation.validator.TicketDatetimeFrameValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static ru.vsu.service.service.validation.code.ConstraintCode.DATE_FRAME;

/**
 * Validation annotation used
 * to check if maximum date is after
 * minimum date in a date frame.
 *
 * @author Kolesnikov Vladislav
 */
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {
        TicketDatetimeFrameValidator.class,
})
@Target({ElementType.TYPE})
public @interface DateFrame {

    /**
     * Message to present if validation fails.
     */
    String message() default DATE_FRAME;

    /**
     * Action groups before which validation needs to be performed.
     */
    Class<?>[] groups() default {};

    /**
     * Meta information used in validation.
     */
    Class<? extends Payload>[] payload() default {};
}
