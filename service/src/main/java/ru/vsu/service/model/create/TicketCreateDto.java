package ru.vsu.service.model.create;

import ru.vsu.repository.entity.Ticket;
import ru.vsu.service.model.base.AbstractTicketDto;

/**
 * DTO creating class for {@link Ticket}.
 * Used to create new entity in database.
 *
 * @author Kolesnikov Vladislav
 */
public class TicketCreateDto extends AbstractTicketDto {

    @Override
    public String toString() {
        return "TicketCreateDto{" +
                "fromCity='" + getFromCity() + '\'' +
                ", toCity='" + getToCity() + '\'' +
                ", departureDatetime=" + getDepartureDatetime() +
                ", arrivalDatetime=" + getArrivalDatetime() +
                ", airlineId=" + getAirlineId() +
                ", travelClassId=" + getTravelClassId() +
                ", price=" + getPrice() +
                '}';
    }
}
