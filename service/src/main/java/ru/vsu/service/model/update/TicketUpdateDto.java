package ru.vsu.service.model.update;

import ru.vsu.repository.entity.Ticket;
import ru.vsu.service.model.base.AbstractTicketDto;

/**
 * DTO creating class for {@link Ticket}.
 * Used to update existing entity in database.
 *
 * @author Kolesnikov Vladislav
 */
public class TicketUpdateDto extends AbstractTicketDto {

    @Override
    public String toString() {
        return "TicketUpdateDto{" +
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
