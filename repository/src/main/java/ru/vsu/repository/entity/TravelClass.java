package ru.vsu.repository.entity;

/**
 * Represents travel class for {@link Ticket}.
 *
 * @author Kolesnikov Vladislav
 */
public enum TravelClass {
    ECONOMY(1),
    BUSINESS(2),
    FIRST(3);

    private final int id;

    TravelClass(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    /**
     * Tries to parse given id into {@link TravelClass} instance.
     *
     * @param id id to find matching {@link TravelClass}
     * @return {@link TravelClass} with matching id or {@literal null}.
     */
    public static TravelClass fromId(final Integer id) {
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
