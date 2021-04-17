package ru.vsu.service.model.get;

import ru.vsu.repository.entity.Ticket;
import ru.vsu.repository.entity.TravelClass;
import ru.vsu.service.model.base.BaseDto;
import ru.vsu.service.model.base.NamedDto;

import java.time.Instant;

/**
 * DTO class for {@link Ticket}
 * Used for fetching information to client.
 *
 * @author Kolesnikov Vladislav
 */
public class TicketGetDto extends BaseDto {

    private String fromCity;
    private String toCity;
    private Instant departureDatetime;
    private Instant arrivalDatetime;
    private NamedDto airline;
    private TravelClass travelClass;
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

    public NamedDto getAirline() {
        return airline;
    }

    public void setAirline(NamedDto airline) {
        this.airline = airline;
    }

    public TravelClass getTravelClass() {
        return travelClass;
    }

    public void setTravelClass(TravelClass travelClass) {
        this.travelClass = travelClass;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
