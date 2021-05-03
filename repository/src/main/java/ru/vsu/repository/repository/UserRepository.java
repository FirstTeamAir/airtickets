package ru.vsu.repository.repository;

import ru.vsu.repository.entity.User;
import ru.vsu.repository.entity.type.EntityType;
import ru.vsu.repository.repository.base.BaseRepository;
import ru.vsu.repository.repository.base.EntityTypedRepository;

/**
 * Repository to manage {@link User}.
 *
 * @author Ignatov Mikhail
 */
public interface UserRepository extends
        BaseRepository<User, Integer>,
        EntityTypedRepository<User, Integer> {

    /**
     * {@inheritDoc}
     */
    @Override
    default EntityType getEntityType() {
        return EntityType.USER;
    }
}