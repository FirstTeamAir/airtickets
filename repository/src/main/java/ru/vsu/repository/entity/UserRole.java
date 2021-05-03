package ru.vsu.repository.entity;

/**
 * Represents user role for {@link User}.
 *
 * @author Ignatov Mikhail
 */
public enum UserRole {
    Admin(1),
    Customer(2);

    private final int id;

    UserRole(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    /**
     * Tries to parse given id into {@link UserRole} instance.
     *
     * @param id id to find matching {@link UserRole}
     * @return {@link UserRole} with matching id or {@literal null}.
     */
    public static UserRole fromId(final Integer id) {
        if (id == null) {
            return null;
        }
        for (final var value : values()) {
            if (value.id == id) {
                return value;
            }
        }
        return null;
    }
}