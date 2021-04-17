package ru.vsu.service.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import ru.vsu.repository.entity.type.EntityType;
import ru.vsu.repository.repository.TicketRepository;
import ru.vsu.service.mapper.ITicketMapper;
import ru.vsu.service.model.create.TicketCreateDto;
import ru.vsu.service.model.get.TicketGetDto;
import ru.vsu.service.model.update.TicketUpdateDto;
import ru.vsu.service.service.ITicketService;
import ru.vsu.service.service.validation.annotation.EntityExists;
import ru.vsu.service.service.validation.code.ConstraintCode;
import ru.vsu.service.service.validation.marker.Common;
import ru.vsu.service.service.validation.marker.TypeSpecific;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.groups.Default;
import java.util.List;

/**
 * Implementation of {@link ITicketService}.
 *
 * @author Kolesnikov Vladislav
 */
@Validated({Common.class, TypeSpecific.class, Default.class})
@Service
public class TicketServiceImpl implements ITicketService {

    private static final Logger logger = LoggerFactory.getLogger(TicketServiceImpl.class);

    private final TicketRepository repository;
    private final ITicketMapper mapper;

    /**
     * Constructor.
     */
    public TicketServiceImpl(TicketRepository repository, ITicketMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public TicketGetDto create(@NotNull @Valid TicketCreateDto createDto) {
        logger.info("Requested to create Ticket");
        if (logger.isDebugEnabled()) {
            logger.debug("Request params: [createDto={}]", createDto);
        }

        var ticket = mapper.fromCreateDto(createDto);
        ticket = repository.saveAndRefresh(ticket);
        return mapper.toGetDto(ticket);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public TicketGetDto updateById(@EntityExists(entityType = EntityType.TICKET,
            message = ConstraintCode.ENTITY_EXISTS_SEARCH_BY) int id, @NotNull @Valid TicketUpdateDto updateDto) {
        logger.info("Requested to update Ticket with [ID={}]", id);
        if (logger.isDebugEnabled()) {
            logger.debug("Request params: [dto={}]", updateDto);
        }

        final var ticket = repository.findById(id).orElseThrow();
        mapper.mergeUpdate(updateDto, ticket);
        repository.saveAndRefresh(ticket);
        return mapper.toGetDto(ticket);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public void deleteById(@EntityExists(entityType = EntityType.TICKET,
            message = ConstraintCode.ENTITY_EXISTS_SEARCH_BY) int id) {
        logger.info("Requested to delete Ticket with [ID={}]", id);
        repository.deleteById(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public TicketGetDto getById(int id) {
        logger.info("Requested Ticket with [ID={}]", id);
        final var ticket = repository.findById(id).orElse(null);
        if (ticket == null) {
            logger.warn("Ticket with [ID={}] not found", id);
        }
        return mapper.toGetDto(ticket);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public List<TicketGetDto> getAll() {
        logger.info("Requested list of Tickets");
        return mapper.toGetDto(repository.findAll());
    }
}
