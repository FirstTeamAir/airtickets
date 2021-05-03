package ru.vsu.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Qualifier;
import ru.vsu.repository.entity.User;
import ru.vsu.repository.entity.UserRole;
import ru.vsu.service.model.create.UserCreateDto;
import ru.vsu.service.model.get.UserGetDto;
import ru.vsu.service.model.update.UserUpdateDto;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.List;

/**
 * Maps between {@link User} and it's DTOs.
 *
 * @author Ignatov Mikhail
 */
@Mapper
public interface IUserMapper {

    /**
     * Maps user role.
     *
     * @param userRoleId {@link UserRole} id
     * @return {@link UserRole} with id = userRoleId
     */
    @GetUserRoleFromId
    default UserRole mapType(Integer userRoleId) {
        return UserRole.fromId(userRoleId);
    }

    /**
     * Converts {@link UserCreateDto} to {@link User}.
     *
     * @param dto DTO to convert
     */
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "userRole", source = "userRoleId", qualifiedBy = GetUserRoleFromId.class)
    User fromCreateDto(UserCreateDto dto);

    /**
     * Converts {@link User} to {@link UserGetDto}.
     *
     * @param entity entity to convert
     */
    UserGetDto toGetDto(User entity);

    /**
     * Converts list of {@link User} to list of {@link UserGetDto}.
     *
     * @param entity entity to convert
     */
    List<UserGetDto> toGetDto(List<User> entity);

    /**
     * Converts {@link UserCreateDto} to {@link User}
     * and update User.
     *
     * @param dto    DTO to convert
     * @param user User to update
     */
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "userRole", source = "userRoleId", qualifiedBy = GetUserRoleFromId.class)
    void mergeUpdate(UserUpdateDto dto, @MappingTarget User user);

    @Qualifier
    @Retention(RetentionPolicy.CLASS)
    @Target(ElementType.METHOD)
    @interface GetUserRoleFromId {}
}