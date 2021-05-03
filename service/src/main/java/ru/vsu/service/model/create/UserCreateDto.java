package ru.vsu.service.model.create;

import ru.vsu.repository.entity.User;
import ru.vsu.service.model.base.AbstractUserDto;

/**
 * DTO creating class for {@link User}.
 * Used to create new entity in database.
 *
 * @author Ignatov Mikhail
 */
public class UserCreateDto extends AbstractUserDto {

    @Override
    public String toString() {
        return "UserCreateDto{" +
                "firstName='" + getFirstName() + '\'' +
                ", lastName='" + getLastName() + '\'' +
                ", useRoleId" + getUserRoleId() +
                ", phone=" + getPhone() +
                ", email=" + getEmail() +
                ", username=" + getUsername() +
                ", password=" + getPassword() +
                '}';
    }
}