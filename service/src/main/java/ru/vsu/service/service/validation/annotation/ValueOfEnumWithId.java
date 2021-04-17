package ru.vsu.service.service.validation.annotation;

import ru.vsu.repository.entity.commons.HasId;
import ru.vsu.service.service.validation.validator.ValueOfEnumWithIdValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Validation annotation for checking
 * if enum value correct.
 * You must specify validated {@link Enum} implement {@link HasId}.
 *
 * @author Kolesnikov Vladislav
 */
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {ValueOfEnumWithIdValidator.class})
@Target({ElementType.TYPE_USE, ElementType.FIELD, ElementType.PARAMETER})
public @interface ValueOfEnumWithId {

    /**
     * Validated enum.
     */
    Class<? extends Enum<?>> enumClass();

    /**
     * Message to present if validation fails.
     */
    String message();

    /**
     * Action groups before which validation needs to be performed.
     */
    Class<?>[] groups() default {};

    /**
     * Meta information used in validation.
     */
    Class<? extends Payload>[] payload() default {};
}
