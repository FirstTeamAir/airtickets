package ru.vsu.service.service;

import ru.vsu.repository.entity.User;
import ru.vsu.repository.entity.type.EntityType;
import ru.vsu.service.model.create.UserCreateDto;
import ru.vsu.service.model.get.UserGetDto;
import ru.vsu.service.model.update.UserUpdateDto;
import ru.vsu.service.service.validation.annotation.EntityExists;
import ru.vsu.service.service.validation.code.ConstraintCode;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 *  Manages {@link User}.
 *
 *  @author Ignatov Mikhail
 */
public interface IUserService {

    /**
     * Creates an instance in the database with the information provided in the DTO.
     *
     * @param createDto DTO that holds information about entity to save, it can never be null
     * @return DTO from saved entity
     */
    UserGetDto create(@NotNull @Valid UserCreateDto createDto);

    /**
     * Changes properties of the user.
     *
     * @param id identifier used to find existing user
     * @param updateDto model with properties to update
     * @return DTO from updated user
     */
    UserGetDto updateById(
            @EntityExists(entityType = EntityType.USER, message = ConstraintCode.ENTITY_EXISTS_SEARCH_BY) int id,
            @NotNull @Valid UserUpdateDto updateDto
    );

    /**
     * Deletes user by id.
     *
     * @param id identifier used to find existing user
     */
    void deleteById(@EntityExists(entityType = EntityType.USER, message = ConstraintCode.ENTITY_EXISTS_SEARCH_BY) int id);

    /**
     * Returns a DTO of {@link User} by the given identifier.
     *2
     * @param id identifier by which to find. May never be null.
     * @return DTO if found. Null otherwise.
     */
    UserGetDto getById(int id);

    /**
     * Returns all instances of {@link User}.
     *
     * @return all instances.
     */
    List<UserGetDto> getAll();
}