package ru.vsu.service.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import ru.vsu.repository.entity.type.EntityType;
import ru.vsu.repository.repository.UserRepository;
import ru.vsu.service.mapper.IUserMapper;
import ru.vsu.service.model.create.UserCreateDto;
import ru.vsu.service.model.get.UserGetDto;
import ru.vsu.service.model.update.UserUpdateDto;
import ru.vsu.service.service.IUserService;
import ru.vsu.service.service.validation.annotation.EntityExists;
import ru.vsu.service.service.validation.code.ConstraintCode;
import ru.vsu.service.service.validation.marker.Common;
import ru.vsu.service.service.validation.marker.TypeSpecific;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.groups.Default;
import java.util.List;

/**
 * Implementation of {@link IUserService}.
 *
 * @author Ignatov Mikhail
 */
@Validated({Common.class, TypeSpecific.class, Default.class})
@Service
public class UserServiceImpl implements IUserService {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    private final UserRepository repository;
    private final IUserMapper mapper;

    /**
     * Constructor.
     */
    public UserServiceImpl(UserRepository repository, IUserMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public UserGetDto create(@NotNull @Valid UserCreateDto createDto) {
        logger.info("Requested to create User");
        if (logger.isDebugEnabled()) {
            logger.debug("Request params: [createDto={}]", createDto);
        }

        var user = mapper.fromCreateDto(createDto);
        user = repository.saveAndRefresh(user);
        return mapper.toGetDto(user);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public UserGetDto updateById(@EntityExists(entityType = EntityType.USER,
            message = ConstraintCode.ENTITY_EXISTS_SEARCH_BY) int id, @NotNull @Valid UserUpdateDto updateDto) {
        logger.info("Requested to update User with [ID={}]", id);
        if (logger.isDebugEnabled()) {
            logger.debug("Request params: [dto={}]", updateDto);
        }

        final var user = repository.findById(id).orElseThrow();
        mapper.mergeUpdate(updateDto, user);
        repository.saveAndRefresh(user);
        return mapper.toGetDto(user);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public void deleteById(@EntityExists(entityType = EntityType.USER,
            message = ConstraintCode.ENTITY_EXISTS_SEARCH_BY) int id) {
        logger.info("Requested to delete User with [ID={}]", id);
        repository.deleteById(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public UserGetDto getById(int id) {
        logger.info("Requested User with [ID={}]", id);
        final var user = repository.findById(id).orElse(null);
        if (user == null) {
            logger.warn("User with [ID={}] not found", id);
        }
        return mapper.toGetDto(user);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public List<UserGetDto> getAll() {
        logger.info("Requested list of Users");
        return mapper.toGetDto(repository.findAll());
    }
}