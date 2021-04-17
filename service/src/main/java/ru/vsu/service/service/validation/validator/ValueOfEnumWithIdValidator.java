package ru.vsu.service.service.validation.validator;

import ru.vsu.repository.entity.commons.HasId;
import ru.vsu.service.service.validation.annotation.ValueOfEnumWithId;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Validation class for checking if enum with id value correct.
 *
 * @author Kolesnikov Vladislav
 */
public class ValueOfEnumWithIdValidator implements ConstraintValidator<ValueOfEnumWithId, Integer> {

  private List<Integer> acceptedValues;

  /**
   * {@inheritDoc}
   */
  @Override
  public void initialize(ValueOfEnumWithId annotation) {
    if (!HasId.class.isAssignableFrom(annotation.enumClass())) {
      throw new UnsupportedOperationException("Checking existence of " + annotation.enumClass()
          + " is not supported");
    }
    acceptedValues = Arrays.stream(annotation.enumClass().getEnumConstants())
        .map(v -> ((HasId) v).getId())
        .collect(Collectors.toList());
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean isValid(Integer value, ConstraintValidatorContext context) {
    if (value == null) {
      return true;
    }
    return acceptedValues.contains(value);
  }
}
