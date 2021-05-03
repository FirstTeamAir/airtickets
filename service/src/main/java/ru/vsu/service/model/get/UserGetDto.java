package ru.vsu.service.model.get;

import ru.vsu.repository.entity.User;
import ru.vsu.repository.entity.UserRole;
import ru.vsu.service.model.base.BaseDto;
import ru.vsu.service.model.base.NamedDto;

/**
 * DTO class for {@link User}
 * Used for fetching information to client.
 *
 * @author Ignatov Mikhail
 */
public class UserGetDto extends BaseDto {

    private String firstName;
    private String lastName;
    private UserRole userRole;
    private Double phone;
    private Stirng email;
    private String username;
    private String password;


    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

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