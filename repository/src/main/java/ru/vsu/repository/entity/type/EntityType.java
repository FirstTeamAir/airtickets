package ru.vsu.repository.entity.type;

/**
 * Enum for describing all existing entities in the application.
 *
 * @author Kolesnikov Vladislav
 */
public enum EntityType {
    TICKET("Ticket"),
    AIRLINE("Airline");

    private final String entityName;

    EntityType(String entityName) {
        this.entityName = entityName;
    }

    public String getEntityName() {
        return entityName;
    }
}
