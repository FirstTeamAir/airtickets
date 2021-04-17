package ru.vsu.repository.repository;

import ru.vsu.repository.entity.Ticket;
import ru.vsu.repository.entity.type.EntityType;
import ru.vsu.repository.repository.base.BaseRepository;
import ru.vsu.repository.repository.base.EntityTypedRepository;

/**
 * Repository to manage {@link Ticket}.
 *
 * @author Kolesnikov Vladislav
 */
public interface TicketRepository extends
        BaseRepository<Ticket, Integer>,
        EntityTypedRepository<Ticket, Integer> {

    /**
     * {@inheritDoc}
     */
    @Override
    default EntityType getEntityType() {
        return EntityType.TICKET;
    }
}
