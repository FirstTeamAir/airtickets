package ru.vsu.repository.repository.base;

import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.transaction.annotation.Transactional;
import th.co.geniustree.springdata.jpa.repository.support.JpaSpecificationExecutorWithProjectionImpl;

import javax.persistence.EntityManager;
import java.io.Serializable;

/**
 * Default implementation of {@link BaseRepository}.
 *
 * @param <T> Entity type
 * @param <I> Entity id type
 *
 * @author Kolesnikov Vladislav
 */
public class BaseRepositoryImpl<T, I extends Serializable>
    extends JpaSpecificationExecutorWithProjectionImpl<T, I> implements BaseRepository<T, I> {

  private final EntityManager entityManager;

  /**
   * Creates a new {@link BaseRepositoryImpl}.
   *
   * @param entityInformation must not be {@literal null}.
   * @param entityManager must not be {@literal null}.
   */
  public BaseRepositoryImpl(JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager) {
    super(entityInformation, entityManager);
    this.entityManager = entityManager;
  }

  /**
   * Refreshes the given entity.
   *
   * @param entity Entity to refresh
   */
  @Override
  @Transactional
  public void refresh(T entity) {
    entityManager.refresh(entity);
  }

  /**
   * Saves and then refreshes given entity.
   * Use it if entity has nested objects and you need information about them.
   *
   * @param entity Entity to save
   * @return Saved Entity
   */
  @Override
  @Transactional
  public T saveAndRefresh(T entity) {
    final T updated = super.save(entity);
    entityManager.flush();
    entityManager.refresh(updated);
    return updated;
  }

  @Override
  public void clear() {
    entityManager.flush();
    entityManager.clear();
  }
}
