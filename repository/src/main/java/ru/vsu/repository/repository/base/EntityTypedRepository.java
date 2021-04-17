package ru.vsu.repository.repository.base;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import ru.vsu.repository.entity.type.EntityType;

/**
 * Base repository type that can be used to easily get managed {@link EntityType} without getting actual class,
 * which can be used for field validation.
 *
 * @author Kolesnikov Vladislav
 */
@NoRepositoryBean
@SuppressWarnings("checkstyle")
public interface EntityTypedRepository<T, ID> extends CrudRepository<T, ID> {

  /**
   * Retrieves type of entity managed by this repository.
   */
  EntityType getEntityType();
}
