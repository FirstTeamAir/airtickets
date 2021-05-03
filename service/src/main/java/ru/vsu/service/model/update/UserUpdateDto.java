package ru.vsu.service.model.update;

import ru.vsu.repository.entity.User;
import ru.vsu.service.model.base.AbstractUserDto;

/**
 * DTO creating class for {@link User}.
 * Used to update existing entity in database.
 *
 * @author Ignatov Mikhail
 */
public class UserUpdateDto extends AbstractUserDto {

    @Override
    public String toString() {
        return "UserUpdateDto{" +
                "firstName='" + getFirstName() + '\'' +
                ", lastName='" + getLastName() + '\'' +
                ", userRoleId" + getUserRoleId() +
                ", phone=" + getPhone() +
                ", email=" + getEmail() +
                ", username=" + getUsername() +
                ", password=" + getPassword() +
                '}';
    }
}