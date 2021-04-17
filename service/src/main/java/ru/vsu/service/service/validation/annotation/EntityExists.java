package ru.vsu.service.service.validation.annotation;

import ru.vsu.repository.entity.type.EntityType;
import ru.vsu.service.service.validation.code.ConstraintCode;
import ru.vsu.service.service.validation.validator.EntityExistsValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Validation annotation for checking
 * if entity with given id is present in database.
 * You must specify validated {@link EntityType}.
 *
 * @author Kolesnikov Vladislav
 */
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {EntityExistsValidator.class})
@Target({ElementType.FIELD, ElementType.PARAMETER})
public @interface EntityExists {

    /**
     * Validated entity type.
     */
    EntityType entityType();

    /**
     * Message to present if validation fails.
     */
    String message() default ConstraintCode.ENTITY_EXISTS;

    /**
     * Action groups before which validation needs to be performed.
     */
    Class<?>[] groups() default {};

    /**
     * Meta information used in validation.
     */
    Class<? extends Payload>[] payload() default {};
}
