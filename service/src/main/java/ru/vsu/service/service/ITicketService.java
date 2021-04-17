package ru.vsu.service.service;

import ru.vsu.repository.entity.Ticket;
import ru.vsu.repository.entity.type.EntityType;
import ru.vsu.service.model.create.TicketCreateDto;
import ru.vsu.service.model.get.TicketGetDto;
import ru.vsu.service.model.update.TicketUpdateDto;
import ru.vsu.service.service.validation.annotation.EntityExists;
import ru.vsu.service.service.validation.code.ConstraintCode;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 *  Manages {@link Ticket}.
 *
 *  @author Kolesnikov Vladislav
 */
public interface ITicketService {

    /**
     * Creates an instance in the database with the information provided in the DTO.
     *
     * @param createDto DTO that holds information about entity to save, it can never be null
     * @return DTO from saved entity
     */
    TicketGetDto create(@NotNull @Valid TicketCreateDto createDto);

    /**
     * Changes properties of the ticket.
     *
     * @param id identifier used to find existing ticket
     * @param updateDto model with properties to update
     * @return DTO from updated ticket
     */
    TicketGetDto updateById(
            @EntityExists(entityType = EntityType.TICKET, message = ConstraintCode.ENTITY_EXISTS_SEARCH_BY) int id,
            @NotNull @Valid TicketUpdateDto updateDto
    );

    /**
     * Deletes ticket by id.
     *
     * @param id identifier used to find existing ticket
     */
    void deleteById(@EntityExists(entityType = EntityType.TICKET, message = ConstraintCode.ENTITY_EXISTS_SEARCH_BY) int id);

    /**
     * Returns a DTO of {@link Ticket} by the given identifier.
     *2
     * @param id identifier by which to find. May never be null.
     * @return DTO if found. Null otherwise.
     */
    TicketGetDto getById(int id);

    /**
     * Returns all instances of {@link Ticket}.
     *
     * @return all instances.
     */
    List<TicketGetDto> getAll();
}
