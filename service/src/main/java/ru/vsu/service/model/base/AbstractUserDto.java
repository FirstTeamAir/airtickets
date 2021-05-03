package ru.vsu.service.model.base;

import ru.vsu.repository.entity.User;
import ru.vsu.repository.entity.UserRole;
import ru.vsu.service.service.validation.annotation.ValueOfEnumWithId;
import ru.vsu.service.service.validation.code.ConstraintCode;
import ru.vsu.service.service.validation.code.ParameterCode;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * Abstract dto class for {@link User}.
 * Holds information shared between update and create DTOs.
 *
 * @author Ignatov Mikhail
 */

public abstract class AbstractUserDto {

    @NotBlank(message = ConstraintCode.NOT_EMPTY + ParameterCode.USER_FIRST_NAME)
    private String firstName;

    @NotBlank(message = ConstraintCode.NOT_EMPTY + ParameterCode.USER_LAST_NAME)
    private String lastName;

    @ValueOfEnumWithId(
            enumClass = UserRole.class,
            message = ConstraintCode.VALUE_OF_ENUM + ParameterCode.USER_ROLE
    )
    @NotNull(message = ConstraintCode.NOT_NULL + ParameterCode.USER_ROLE)
    private Integer userRoleId;

    @NotNull(message = ConstraintCode.NOT_NULL + ParameterCode.USER_PHONE)
    private Double phone;

    @NotBlank(message = ConstraintCode.NOT_EMPTY + ParameterCode.USER_EMAIL)
    private String email;

    @NotBlank(message = ConstraintCode.NOT_EMPTY + ParameterCode.USER_USERNAME)
    private String username;

    @NotBlank(message = ConstraintCode.NOT_EMPTY + ParameterCode.USER_PASSWORD)
    private String password;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getUserRoleId() {
        return userRoleId;
    }

    public void setUserRole(Integer userRoleId) {
        this.userRoleId = userRoleId;
    }

    public Double getPhone() {
        return phone;
    }

    public void setPhone(Double phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}