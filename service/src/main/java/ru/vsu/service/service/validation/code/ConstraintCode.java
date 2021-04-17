package ru.vsu.service.service.validation.code;

/**
 * Holds codes to constraints.
 * Used as a message in constraint violations
 * in combination with {@link ParameterCode}.
 *
 * @author Kolesnikov Vladislav
 */
public class ConstraintCode {

    // Standard JSR-303 constraints codes 01-15
    public static final String NOT_NULL = "01";
    public static final String SIZE = "02";
    public static final String MIN = "03";
    public static final String NOT_EMPTY = "04";

    // Constraints dealing with db entities.
    public static final String UNIQUE_ENTITY_NAME = "05";
    public static final String ENTITY_EXISTS = "06";

    // Constraints dealing with dates
    public static final String AFTER_NOW = "07";
    public static final String DATE_FRAME = "08";

    // Enum constraints
    public static final String VALUE_OF_ENUM = "10";

    // Constraints dealing with search by db entities.
    public static final String ENTITY_EXISTS_SEARCH_BY = "11";

    private ConstraintCode() {
    }
}
