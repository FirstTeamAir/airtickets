package ru.vsu.repository.repository.base;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

/**
 * Base repository interface.
 * Extends {@link JpaRepository} and adds two new methods to it.
 *
 * @param <T> Entity type
 * @param <I> Entity id type
 *
 * @author Kolesnikov Vladislav
 */
@NoRepositoryBean
public interface BaseRepository<T, I extends Serializable>
    extends JpaRepository<T, I>, JpaSpecificationExecutor<T> {

  /**
   * Refreshes the given entity.
   *
   * @param entity Entity to refresh
   */
  void refresh(T entity);

  /**
   * Saves and then refreshes given entity.
   * Use it if entity has nested objects and you need information about them.
   *
   * @param entity Entity to save
   * @return Saved Entity
   */
  T saveAndRefresh(T entity);

  /**
   * Clear the persistence context.
   */
  void clear();
}
