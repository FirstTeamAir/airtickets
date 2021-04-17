package ru.vsu.service.service.validation.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import ru.vsu.repository.entity.type.EntityType;
import ru.vsu.repository.repository.base.EntityTypedRepository;
import ru.vsu.service.service.validation.annotation.EntityExists;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Class for checking whether or not entity with a given ID exists.
 *
 * @author Alexey Alimov
 */
public class EntityExistsValidator implements ConstraintValidator<EntityExists, Integer> {

    private final Map<EntityType, ? extends EntityTypedRepository<?, Integer>> repositories;

    private CrudRepository<?, Integer> repository;

    /**
     * Constructor.
     */
    public EntityExistsValidator(@Autowired List<? extends EntityTypedRepository<?, Integer>> repositories) {
        this.repositories = repositories
                .stream()
                .collect(Collectors.toMap(EntityTypedRepository::getEntityType, r -> r));
    }

    @Override
    public void initialize(EntityExists annotation) {
        final EntityType entityType = annotation.entityType();
        repository = repositories.get(entityType);
        if (repository == null) {
            throw new UnsupportedOperationException("Checking existence of " + entityType.getEntityName()
                    + " is not supported");
        }
    }

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }

        return repository.existsById(value);
    }
}
