package ru.vsu.service.model.base;

import ru.vsu.repository.entity.Ticket;
import ru.vsu.repository.entity.TravelClass;
import ru.vsu.repository.entity.type.EntityType;
import ru.vsu.service.service.validation.annotation.AfterNow;
import ru.vsu.service.service.validation.annotation.DateFrame;
import ru.vsu.service.service.validation.annotation.EntityExists;
import ru.vsu.service.service.validation.annotation.ValueOfEnumWithId;
import ru.vsu.service.service.validation.code.ConstraintCode;
import ru.vsu.service.service.validation.code.ParameterCode;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.Instant;

/**
 * Abstract dto class for {@link Ticket}.
 * Holds information shared between update and create DTOs.
 *
 * @author Kolesnikov Vladislav
 */
@DateFrame(message = ConstraintCode.DATE_FRAME + ParameterCode.TICKET)
public abstract class AbstractTicketDto {

    @NotBlank(message = ConstraintCode.NOT_EMPTY + ParameterCode.TICKET_FROM_CITY)
    private String fromCity;

    @NotBlank(message = ConstraintCode.NOT_EMPTY + ParameterCode.TICKET_TO_CITY)
    private String toCity;

    @AfterNow(message = ConstraintCode.AFTER_NOW + ParameterCode.TICKET_DEPARTURE_DATETIME)
    @NotNull(message = ConstraintCode.NOT_NULL + ParameterCode.TICKET_DEPARTURE_DATETIME)
    private Instant departureDatetime;

    @AfterNow(message = ConstraintCode.AFTER_NOW + ParameterCode.TICKET_ARRIVAL_DATETIME)
    @NotNull(message = ConstraintCode.NOT_NULL + ParameterCode.TICKET_ARRIVAL_DATETIME)
    private Instant arrivalDatetime;

    @NotNull(message = ConstraintCode.NOT_NULL + ParameterCode.TICKET_AIRLINE)
    @EntityExists(
            entityType = EntityType.AIRLINE,
            message = ConstraintCode.ENTITY_EXISTS + ParameterCode.TICKET_AIRLINE
    )
    private Integer airlineId;

    @ValueOfEnumWithId(
            enumClass = TravelClass.class,
            message = ConstraintCode.VALUE_OF_ENUM + ParameterCode.TICKET_TRAVEL_CLASS
    )
    @NotNull(message = ConstraintCode.NOT_NULL + ParameterCode.TICKET_TRAVEL_CLASS)
    private Integer travelClassId;

    @NotNull(message = ConstraintCode.NOT_NULL + ParameterCode.TICKET_PRICE)
    private Integer price;

    public String getFromCity() {
        return fromCity;
    }

    public void setFromCity(String fromCity) {
        this.fromCity = fromCity;
    }

    public String getToCity() {
        return toCity;
    }

    public void setToCity(String toCity) {
        this.toCity = toCity;
    }

    public Instant getDepartureDatetime() {
        return departureDatetime;
    }

    public void setDepartureDatetime(Instant departureDatetime) {
        this.departureDatetime = departureDatetime;
    }

    public Instant getArrivalDatetime() {
        return arrivalDatetime;
    }

    public void setArrivalDatetime(Instant arrivalDatetime) {
        this.arrivalDatetime = arrivalDatetime;
    }

    public Integer getAirlineId() {
        return airlineId;
    }

    public void setAirlineId(Integer   airlineId) {
        this.airlineId = airlineId;
    }

    public Integer getTravelClassId() {
        return travelClassId;
    }

    public void setTravelClassId(Integer travelClassId) {
        this.travelClassId = travelClassId;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
